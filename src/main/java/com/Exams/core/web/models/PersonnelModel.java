package com.Exams.core.web.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class PersonnelModel {

	public static final int TYPE_ADMIN = 1;
	public static final int TYPE_ENSEIGNANT= 2;
	
	private Long idPersonnel;
	private int typePersonnel;


	@NotBlank(message = "This field is required")
	private String nom;

	@NotBlank(message = "This field is required")
	private String prenom;

	
	
	public PersonnelModel() {
		
	}
	

	@Override
	public String toString() {
		return "PersonnelModel [idPersonnel=" + idPersonnel + ", typePersonnel=" + typePersonnel + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}


	public PersonnelModel(int typePersonnel) {
		this.typePersonnel = typePersonnel;
	}




	public int getTypePersonnel() {
		return typePersonnel;
	}


	public void setTypePersonnel(int typePersonnel) {
		this.typePersonnel = typePersonnel;
	}


	public static int getTypeAdmin() {
		return TYPE_ADMIN;
	}


	public static int getTypeEnseignant() {
		return TYPE_ENSEIGNANT;
	}


	public Long getIdPersonnel() {
		return idPersonnel;
	}

	public void setIdPersonnel(Long idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public int getTypePerson() {
		return typePersonnel;
	}

	public void setTypePerson(int typePersonnel) {
		this.typePersonnel = typePersonnel;
	}



}
