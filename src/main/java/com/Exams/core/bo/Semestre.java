package com.Exams.core.bo;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Semestre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSemestre;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private String intitulé;
	

	@OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
	private Set<Examen> examens;
	
	
	
}
