package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Surveillance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSurveillance;
	
	@ManyToMany(mappedBy = "surveillances")
    private Set<Enseignant> surveillants = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	private Enseignant coordinateur;
	
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Administrateur administrateur;
	
	
	@ManyToOne
	@JoinColumn(name = "id_salle")
	private Salle salle;
	
	
	@ManyToOne
	@JoinColumn(name = "id_examen")
	private Examen examen;



}
