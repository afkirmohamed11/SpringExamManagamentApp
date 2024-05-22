package com.Exams.core.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Exams.core.bo.Personnel;




public interface IPersonnelRepository extends JpaRepository<Personnel, Long> {
	
		Personnel getPersonneById(Long id);
		List<Personnel> getPersonnelByNomAndPrenom(String nom, String prenom);
		Personnel getPersonnelByNom(String nom);




}
