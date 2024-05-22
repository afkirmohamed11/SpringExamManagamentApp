package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "enseignantId")
public class Enseignant extends Personnel{
	
	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	private Departement departement;
	
	@ManyToOne
	@JoinColumn(name = "id_enseignant")
	private Filiere filiere;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "enseignant_surveillance",
        joinColumns = @JoinColumn(name = "id_enseignant"),
        inverseJoinColumns = @JoinColumn(name = "id_surveillance")
    )
    private Set<Surveillance> surveillances = new HashSet<>();
	
	@OneToMany(mappedBy = "coordinateur", cascade = CascadeType.ALL)
	private Set<Surveillance> surveillance;
	
	@OneToOne(mappedBy = "enseignant")
	private ElementPedagogique elementPedagogique;
	
	@OneToOne(mappedBy = "coordinateur")
	private ElementPedagogique elementPedagogique1;
	
	
	

	
	
	

	
	
}
