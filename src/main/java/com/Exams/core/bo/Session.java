package com.Exams.core.bo;
import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSession;

    @NotBlank(message = "Ce champ est obligatoire")
    private String intitule;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, targetEntity = Examen.class)
    private Set<Examen> examens;
	
	

	
	
	
	
	
}
