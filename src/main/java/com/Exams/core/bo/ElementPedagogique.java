package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ElementPedagogique {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idElementPedagogique;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private String titre;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_element_enseignant")
	private Enseignant enseignant;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_element_coordinateur")
	private Enseignant coordinateur;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_element_typeElement")
	private TypeElement typeElement;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_element_niveau")
	private Niveau niveau;
	
	@OneToMany(mappedBy = "elementPedagogique", cascade = CascadeType.ALL)
	private Set<Examen> examens;

	public Long getIdElementPedagogique() {
		return idElementPedagogique;
	}

	public void setIdElementPedagogique(Long idElementPedagogique) {
		this.idElementPedagogique = idElementPedagogique;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "ElementPedagogique [idElementPedagogique=" + idElementPedagogique + ", titre=" + titre + "]";
	}

	
	
	
}
