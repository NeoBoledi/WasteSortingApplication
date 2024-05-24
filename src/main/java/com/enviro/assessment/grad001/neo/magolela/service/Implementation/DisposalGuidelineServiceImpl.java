package com.enviro.assessment.grad001.neo.magolela.service.Implementation;

import com.enviro.assessment.grad001.neo.magolela.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.neo.magolela.exception.InvalidRequestException;
import com.enviro.assessment.grad001.neo.magolela.exception.ResourceConflictException;
import com.enviro.assessment.grad001.neo.magolela.model.DisposalGuideline;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;
import com.enviro.assessment.grad001.neo.magolela.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.neo.magolela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.neo.magolela.service.DisposalGuidelineService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisposalGuidelineServiceImpl implements DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public DisposalGuidelineServiceImpl(DisposalGuidelineRepository disposalGuidelineRepository, WasteCategoryRepository wasteCategoryRepository) {
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public DisposalGuideline addGuidelines(DisposalGuideline disposalGuideline,Long wasteCategoryId) {
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(wasteCategoryId);

        if(existingCategory.isPresent()){
            WasteCategory category = existingCategory.get();
            disposalGuideline.setCategory(category);
            disposalGuideline.setDescription(disposalGuideline.getDescription());
            return disposalGuidelineRepository.save(disposalGuideline);
        }else {
            throw new EntityNotFoundException("Waste Category with ID: " + wasteCategoryId + " not found");
        }
    }

    @Override
    public List<DisposalGuidelineDTO> getAllGuidelines() {
        List<DisposalGuideline> tips = disposalGuidelineRepository.findAll();
        return tips.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DisposalGuidelineDTO getGuidelineById(Long id) {
     Optional<DisposalGuideline> existingGuideline = disposalGuidelineRepository.findById(id);

     if(existingGuideline.isPresent()){
         return convertToDTO(existingGuideline.get());
     }else {
         throw new EntityNotFoundException("Disposal guideline with ID: " + id + " not found ");
     }
    }

    @Override
    public DisposalGuidelineDTO updateGuideline(Long id, DisposalGuideline disposalGuideline,Long wasteCategoryId) {
        Optional<DisposalGuideline> existingGuideline = disposalGuidelineRepository.findById(disposalGuideline.getId());

        boolean update = true;

        if(existingGuideline.isPresent()){
            DisposalGuideline guidelineToUpdate = existingGuideline.get();

            if(wasteCategoryId != null){
                Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(wasteCategoryId);

                if(existingCategory.isPresent()){
                    WasteCategory category = existingCategory.get();
                    guidelineToUpdate.setCategory(category);
                }else{
                    throw new EntityNotFoundException("Waste Category with ID: " + wasteCategoryId + " not found");
                }

            }
            guidelineToUpdate.setDescription(guidelineToUpdate.getDescription());
            disposalGuidelineRepository.save(guidelineToUpdate);

            if(!update){
                throw new InvalidRequestException("unable to make changes ");
            }

            return convertToDTO(guidelineToUpdate);
        } else {
            throw new EntityNotFoundException("Disposal guideline with ID: " + id + " not found!");
        }
    }


    @Override
    public void deleteGuideline(Long id) {

        Optional<DisposalGuideline> existingGuideline = disposalGuidelineRepository.findById(id);

        if (existingGuideline.isPresent()){
            disposalGuidelineRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Disposal guideline with ID: " + id + " not found ");
        }
    }

    public DisposalGuidelineDTO convertToDTO(DisposalGuideline disposalGuideline) {

        return new DisposalGuidelineDTO(disposalGuideline.getId(), disposalGuideline.getDescription(), disposalGuideline.getCategory().getName());
    }
}
