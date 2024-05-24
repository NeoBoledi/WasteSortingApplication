package com.enviro.assessment.grad001.neo.magolela.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "tbl_categories")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<DisposalGuideline> guidelines;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<RecyclingTip> tips;

    public WasteCategory() {
    }

    public WasteCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DisposalGuideline> getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(List<DisposalGuideline> guidelines) {
        this.guidelines = guidelines;
    }

    public List<RecyclingTip> getTips() {
        return tips;
    }

    public void setTips(List<RecyclingTip> tips) {
        this.tips = tips;
    }
}
