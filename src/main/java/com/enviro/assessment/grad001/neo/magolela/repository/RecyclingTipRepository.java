package com.enviro.assessment.grad001.neo.magolela.repository;

import com.enviro.assessment.grad001.neo.magolela.model.RecyclingTip;
import com.enviro.assessment.grad001.neo.magolela.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecyclingTipRepository extends JpaRepository<RecyclingTip,Long> {
   
}
