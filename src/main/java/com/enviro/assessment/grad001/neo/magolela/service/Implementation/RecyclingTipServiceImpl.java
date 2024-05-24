package com.enviro.assessment.grad001.neo.magolela.service.Implementation;

import com.enviro.assessment.grad001.neo.magolela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.neo.magolela.exception.InvalidRequestException;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;
import com.enviro.assessment.grad001.neo.magolela.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.neo.magolela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.neo.magolela.service.RecyclingTipService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public RecyclingTipServiceImpl(RecyclingTipRepository recyclingTipRepository, WasteCategoryRepository wasteCategoryRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public RecyclingTip addTips(RecyclingTip recyclingTip, Long wasteCategoryId) {
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(wasteCategoryId);

        if(existingCategory.isPresent()){
            WasteCategory category = existingCategory.get();
            recyclingTip.setCategory(category);
            recyclingTip.setTip(recyclingTip.getTip());
            return recyclingTipRepository.save(recyclingTip);
        }else {
            throw new EntityNotFoundException("Waste Category with ID: " + wasteCategoryId + " not found");
        }
    }

    @Override
    public List<RecyclingTipDTO> getAllTips() {
        List<RecyclingTip> tips = recyclingTipRepository.findAll();
        return tips.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public RecyclingTipDTO getTipsById(Long id) {
        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(id);

        if(existingTip.isPresent()){
            return  convertToDTO(existingTip.get());
        }else {
            throw new EntityNotFoundException("Recycling tip with ID: " + id + " not found!");
        }
    }


    @Override
    public RecyclingTipDTO updateTip(Long id, RecyclingTip recyclingTip,Long wasteCategoryId) {
        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(recyclingTip.getId());

        boolean update = true;
        if(existingTip.isPresent()){
            RecyclingTip tipToUpdate = existingTip.get();

         if(wasteCategoryId != null){
             Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(wasteCategoryId);

             if(existingCategory.isPresent()){
                 WasteCategory category = existingCategory.get();
                 tipToUpdate.setCategory(category);
             }else{
                 throw new EntityNotFoundException("Waste Category with ID: " + wasteCategoryId + " not found");
             }

         }
            tipToUpdate.setTip(recyclingTip.getTip());
            recyclingTipRepository.save(tipToUpdate);

            if(!update){
                throw new InvalidRequestException("unable to make changes ");
            }

            return convertToDTO(tipToUpdate);
        } else {
            throw new EntityNotFoundException("Recycling tip with ID: " + id + " not found!");
        }
    }


    @Override
    public void deleteTip(Long id) {

        Optional<RecyclingTip> existingTip = recyclingTipRepository.findById(id);

        if (existingTip.isPresent()){
            recyclingTipRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Recycling tip with ID: " + id + " not found!");
        }

    }


    public RecyclingTipDTO convertToDTO(RecyclingTip recyclingTip) {
        return new RecyclingTipDTO(recyclingTip.getId(), recyclingTip.getTip(), recyclingTip.getCategory().getName());
    }

}
