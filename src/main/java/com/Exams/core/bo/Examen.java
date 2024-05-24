package com.Exams.core.bo;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExamen;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    private Set<Surveillance> surveillances;

    @ManyToOne
    @JoinColumn(name = "id_semestre")
    private Semestre semestre;

    @ManyToOne
    @JoinColumn(name = "id_session")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "id_type_examen")
    private TypeExamen typeExamen;

    @ManyToOne
    @JoinColumn(name = "id_element_pedagogique")
    private ElementPedagogique elementPedagogique;

    @NotNull(message = "Ce champ est obligatoire")
    private Date date;

    @NotBlank(message = "Ce champ est obligatoire")
    private String heureDeDebut;

    @NotBlank(message = "Ce champ est obligatoire")
    private String dureePrevue;

    @NotBlank(message = "Ce champ est obligatoire")
    private String dureeReelle;

    @NotBlank(message = "Ce champ est obligatoire")
    private String anneeUniversitaire;

    @NotBlank(message = "Ce champ est obligatoire")
    private String epreuve;

    @NotBlank(message = "Ce champ est obligatoire")
    private String pv;

    @NotBlank(message = "Ce champ est obligatoire")
    private String rapportTextuelle = "Rien à signaler";
	
	
	
	
	
}
