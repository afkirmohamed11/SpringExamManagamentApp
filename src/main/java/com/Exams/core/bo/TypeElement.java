package com.Exams.core.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class TypeElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeElement;

    @NotBlank(message = "Ce champ est obligatoire")
    private String titre;

	
	
	public Long getIdTypeElement() {
		return idTypeElement;
	}



	public void setIdTypeElement(Long idTypeElement) {
		this.idTypeElement = idTypeElement;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	@Override
	public String toString() {
		return "TypeElement [idTypeElement=" + idTypeElement + ", titre=" + titre + "]";
	}
	
	
	
	
	
	
	
	

	
	
}
