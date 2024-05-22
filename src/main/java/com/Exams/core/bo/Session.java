package com.Exams.core.bo;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSession;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private String intitulé;
	
	
	@OneToMany(mappedBy = "examen", cascade = CascadeType.ALL)
	private Set<Examen> examens;
	
	

	
	
	
	
	
}
