package com.Exams.core.bo;

import java.util.*;
import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "enseignantId")
public class Enseignant extends Personnel {

    @ManyToOne
    @JoinColumn(name = "id_departement")
    private Departement departement;

    @ManyToOne
    @JoinColumn(name = "id_filiere")
    private Filiere filiere;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    @JoinTable(
        name = "enseignant_surveillance",
        joinColumns = @JoinColumn(name = "id_enseignant"),
        inverseJoinColumns = @JoinColumn(name = "id_surveillance")
    )
    private Set<Surveillance> surveillances = new HashSet<>();

    @OneToMany(mappedBy = "coordinateur", cascade = CascadeType.ALL, targetEntity = Surveillance.class)
    private Set<Surveillance> coordinateurSurveillances;

    @OneToOne(mappedBy = "enseignant")
    private ElementPedagogique elementPedagogique;

    @OneToOne(mappedBy = "coordinateur")
    private ElementPedagogique coordinateurElementPedagogique;
	
	
	

	
	
	

	
	
}
