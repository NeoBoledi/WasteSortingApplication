package com.enviro.assessment.grad001.neo.magolela.controller;

import com.enviro.assessment.grad001.neo.magolela.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.neo.magolela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.neo.magolela.model.DisposalGuideline;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/guideline")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @PostMapping("/save/{wasteCategoryId}")
    public ResponseEntity<DisposalGuideline> addGuideline(@RequestBody @Validated DisposalGuideline disposalGuideline, @PathVariable Long wasteCategoryId) {
        DisposalGuideline createdGuideline = disposalGuidelineService.addGuidelines(disposalGuideline, wasteCategoryId);
        return ResponseEntity.ok(createdGuideline);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DisposalGuidelineDTO>> getAllGuidelines() {
        List<DisposalGuidelineDTO> guidelines = disposalGuidelineService.getAllGuidelines();
        return ResponseEntity.ok(guidelines);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DisposalGuidelineDTO> getGuidelineById(@PathVariable Long id) {
        DisposalGuidelineDTO guideline = disposalGuidelineService.getGuidelineById(id);
        return ResponseEntity.ok(guideline);
    }

    @PutMapping("/update/{id}/{wasteCategoryId}")
    public ResponseEntity<DisposalGuidelineDTO> updateGuideline(@PathVariable Long id,
                                                                 @RequestBody @Validated DisposalGuideline disposalGuideline,
                                                                @PathVariable Long wasteCategoryId) {
        DisposalGuidelineDTO updatedGuideline = disposalGuidelineService.updateGuideline(id, disposalGuideline, wasteCategoryId);
        return ResponseEntity.ok(updatedGuideline);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
