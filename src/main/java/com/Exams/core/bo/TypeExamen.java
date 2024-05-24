package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class TypeExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeExamen;

    @NotBlank(message = "Ce champ est obligatoire")
    private String intitule;

    @OneToMany(mappedBy = "typeExamen", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;
	
	
}
