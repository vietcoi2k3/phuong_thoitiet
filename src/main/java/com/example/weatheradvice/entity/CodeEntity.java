package com.example.weatheradvice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "adviceEntityId")
    private Integer adviceEntityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adviceEntityId",insertable = false,updatable = false)
    @JsonBackReference(value = "advice-code")
    private AdviceEntity adviceEntity;
}
