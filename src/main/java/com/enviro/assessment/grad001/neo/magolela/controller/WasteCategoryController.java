package com.enviro.assessment.grad001.neo.magolela.controller;

import com.enviro.assessment.grad001.neo.magolela.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;
import com.enviro.assessment.grad001.neo.magolela.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService) {
        this.wasteCategoryService = wasteCategoryService;
    }


    @PostMapping("/save")
    public ResponseEntity<WasteCategory> addCategory(@RequestBody @Validated  WasteCategory wasteCategory) {
        WasteCategory newCategory = wasteCategoryService.addCategory(wasteCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping("/all")
    public ResponseEntity<List<WasteCategoryDTO>> getAllCategories() {
        List<WasteCategoryDTO> categories = wasteCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategoryDTO> getCategoryById(@PathVariable Long id) {
        WasteCategoryDTO categoryDTO = wasteCategoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<WasteCategoryDTO> getCategoryByName(@PathVariable String name) {
        WasteCategoryDTO categoryDTO = wasteCategoryService.getCategoryByName(name);
        return ResponseEntity.ok(categoryDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WasteCategoryDTO> updateCategory(@PathVariable Long id, @RequestBody @Validated WasteCategory wasteCategory) {
        WasteCategoryDTO updatedCategory = wasteCategoryService.updateCategory(id, wasteCategory);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
