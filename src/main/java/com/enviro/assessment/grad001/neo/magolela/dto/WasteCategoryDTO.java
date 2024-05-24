package com.enviro.assessment.grad001.neo.magolela.dto;

import com.enviro.assessment.grad001.neo.magolela.model.DisposalGuideline;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;

import java.util.List;

public record WasteCategoryDTO(Long id, String name, List<DisposalGuideline> guideline, List<RecyclingTip> tips) {
}
