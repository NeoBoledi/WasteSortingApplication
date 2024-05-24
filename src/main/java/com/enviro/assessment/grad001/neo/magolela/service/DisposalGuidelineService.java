package com.enviro.assessment.grad001.neo.magolela.service;

import com.enviro.assessment.grad001.neo.magolela.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.neo.magolela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.neo.magolela.model.DisposalGuideline;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;

import java.util.List;

public interface DisposalGuidelineService {

    DisposalGuideline addGuidelines(DisposalGuideline disposalGuideline,Long wasteCategoryId);
    List<DisposalGuidelineDTO> getAllGuidelines();
    DisposalGuidelineDTO getGuidelineById(Long id);
    DisposalGuidelineDTO updateGuideline(Long id, DisposalGuideline disposalGuideline,Long wasteCategoryId);
    void deleteGuideline(Long id);
}
