package com.Exams.core.bo;

import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;




@Entity
public class Salle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalle;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private String nomSalle;
	
	@NotBlank(message = "Ce champs est obligatoire")
	private Integer capacité;
	
    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL, targetEntity = Surveillance.class )
    private Set<Surveillance> surveillances;
	
	

}
