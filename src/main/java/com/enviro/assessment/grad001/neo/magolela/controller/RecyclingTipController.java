package com.enviro.assessment.grad001.neo.magolela.controller;

import com.enviro.assessment.grad001.neo.magolela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tips")
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }


    @PostMapping("/save/{wasteCategoryId}")
    public ResponseEntity<RecyclingTip> addTip(@RequestBody @Validated RecyclingTip recyclingTip, @PathVariable Long wasteCategoryId) {
        RecyclingTip createdTip = recyclingTipService.addTips(recyclingTip, wasteCategoryId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTip);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecyclingTipDTO>> getAllTips() {
        List<RecyclingTipDTO> tips = recyclingTipService.getAllTips();
        return ResponseEntity.ok(tips);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RecyclingTipDTO> getTipById(@PathVariable Long id) {
        RecyclingTipDTO tip = recyclingTipService.getTipsById(id);
        return ResponseEntity.ok(tip);
    }

    @PutMapping("/update/{id}/{wasteCategoryId}")
    public ResponseEntity<RecyclingTipDTO> updateTip(@PathVariable Long id,@RequestBody  @Validated RecyclingTip recyclingTip, @PathVariable Long wasteCategoryId) {
        RecyclingTipDTO updatedTip = recyclingTipService.updateTip(id, recyclingTip, wasteCategoryId);
        return ResponseEntity.ok(updatedTip);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTip(@PathVariable Long id) {
        recyclingTipService.deleteTip(id);
        return ResponseEntity.noContent().build();
    }
}
