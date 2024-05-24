package com.Exams.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Niveau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNiveau;

    @NotBlank(message = "Ce champ est obligatoire")
    private String titre;

	
	
	public Long getIdNiveau() {
		return idNiveau;
	}



	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	@Override
	public String toString() {
		return "Niveau [idNiveau=" + idNiveau + ", titre=" + titre + "]";
	}
	
	
	
	
	
	
	
	

	
	
}
