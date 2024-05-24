package com.enviro.assessment.grad001.neo.magolela.service;

import com.enviro.assessment.grad001.neo.magolela.dto.RecyclingTipDTO;
import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;

import java.util.List;
import java.util.Optional;

public interface RecyclingTipService {

    RecyclingTip addTips(RecyclingTip recyclingTip,Long wasteCategoryId);
    List<RecyclingTipDTO> getAllTips();
    RecyclingTipDTO getTipsById(Long id);
    RecyclingTipDTO updateTip(Long id, RecyclingTip recyclingTip,Long wasteCategoryId);
    void deleteTip(Long id);
}
