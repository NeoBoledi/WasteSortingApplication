package com.enviro.assessment.grad001.neo.magolela.service.Implementation;

import com.enviro.assessment.grad001.neo.magolela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.neo.magolela.exception.InvalidRequestException;
import com.enviro.assessment.grad001.neo.magolela.exception.ResourceConflictException;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;
import com.enviro.assessment.grad001.neo.magolela.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.neo.magolela.service.WasteCategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryServiceImpl(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    @Override
    public WasteCategory addCategory(WasteCategory wasteCategory) {
      Optional<WasteCategory> existingCategory = wasteCategoryRepository.findCategoryByName(wasteCategory.getName());

      if(existingCategory.isEmpty()){
          WasteCategory category = new WasteCategory();
          category.setName(wasteCategory.getName());
          return wasteCategoryRepository.save(category);
      }else {
          throw new ResourceConflictException("category name already exist");
      }

    }

    @Override
    public List<WasteCategoryDTO> getAllCategories() {
        List<WasteCategory> categories = wasteCategoryRepository.findAll();
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    @Override
    public WasteCategoryDTO getCategoryById(Long id) {
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(id);

        if(existingCategory.isPresent()){
            return convertToDTO(existingCategory.get());
        }else {
            throw new EntityNotFoundException("Category with ID: " + id + " not found!");
        }
    }


    @Override
    public WasteCategoryDTO getCategoryByName(String name) {
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findCategoryByName(name);

        if(existingCategory.isPresent()){
            return convertToDTO(existingCategory.get());
        }else {
            throw new EntityNotFoundException("Category with Name: " + name + " not found!");
        }
    }


    @Override
    public WasteCategoryDTO updateCategory(Long id, WasteCategory wasteCategory) {
        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(id);

        boolean updated = true;

        if(existingCategory.isPresent()){
            WasteCategory categoryToUpdate = existingCategory.get();

            if(wasteCategory.getName() != null){
                    categoryToUpdate.setName(wasteCategory.getName());
            }
            wasteCategoryRepository.save(categoryToUpdate);

            if(!updated){
                 throw new InvalidRequestException("unable to make changes ");
            }

            return convertToDTO(categoryToUpdate);
        } else {
            throw new EntityNotFoundException("Category with ID: " + id + " not found!");
        }
    }


    @Override
    public void deleteCategory(Long id) {

        Optional<WasteCategory> existingCategory = wasteCategoryRepository.findById(id);

        if(existingCategory.isPresent()){
            wasteCategoryRepository.deleteById(id);

        }else {
            throw new EntityNotFoundException("Category with ID: " + id + " not found!");
        }

    }


    public WasteCategoryDTO convertToDTO(WasteCategory category) {

        return new WasteCategoryDTO(category.getId(), category.getName(), category.getGuidelines(), category.getTips());
    }
}
