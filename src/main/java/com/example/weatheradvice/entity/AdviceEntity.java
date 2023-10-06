package com.example.weatheradvice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String weatherConEn;
    private String adviceEn;
    private String adviceVn;
    private String weatherConVn;

    @Column(name = "adviceTypeId")
    private Integer adviceTypeId;

    @OneToMany(mappedBy = "adviceEntity")
    @JsonManagedReference(value = "advice-code")
    private List<CodeEntity> codeEntityList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adviceTypeId",insertable = false,updatable = false)
    @JsonBackReference(value = "advice-type")
    private AdviceTypeEntity adviceTypeEntity;
}
