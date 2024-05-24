package com.enviro.assessment.grad001.neo.magolela.service;

import com.enviro.assessment.grad001.neo.magolela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;

import java.util.List;

public interface WasteCategoryService {

    WasteCategory addCategory(WasteCategory wasteCategory);
    List<WasteCategoryDTO> getAllCategories();
    WasteCategoryDTO getCategoryById(Long id);
    WasteCategoryDTO getCategoryByName(String name);
    WasteCategoryDTO updateCategory(Long id, WasteCategory wasteCategory);
    void deleteCategory(Long id);
}




