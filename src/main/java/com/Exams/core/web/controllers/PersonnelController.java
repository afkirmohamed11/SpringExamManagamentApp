package com.Exams.core.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.Exams.core.services.IPersonnelService;
import com.Exams.core.web.models.PersonnelModel;
import com.Exams.core.bo.Enseignant;
import com.Exams.core.bo.Administrateur;
import com.Exams.core.bo.Personnel;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;




// Ce controleur gère les personnes de type Admin et Enseignant

public class PersonnelController {
	
	@Autowired IPersonnelService personnelService;
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());


	public PersonnelController() {}
	
	
	@GetMapping(value = "showForm")
	public String showForm(@RequestParam int typePerson, Model model) {

		PersonnelModel pmodel = new PersonnelModel(typePerson);
		model.addAttribute("personnelModel", pmodel);

		List<Personnel> personnels = personnelService.getAllPersonnels();
		List<PersonnelModel> modelPersonnels = new ArrayList<PersonnelModel>();

		for (int i = 0; i < personnels.size(); i++) {
			PersonnelModel pm = new PersonnelModel();
			if (personnels.get(i) instanceof Enseignant) {

				BeanUtils.copyProperties((Enseignant) personnels.get(i), pm);
				pm.setTypePerson(PersonnelModel.TYPE_ENSEIGNANT);
				modelPersonnels.add(pm);
			} else {
				BeanUtils.copyProperties((Enseignant) personnels.get(i), pm);
				pm.setTypePerson(PersonnelModel.TYPE_ADMIN);
				modelPersonnels.add(pm);
			}
		}
		// Mettre la liste des personnes dans le modèle de Spring MVC
		model.addAttribute("personList", modelPersonnels);

		return "form";
	}
	

	@RequestMapping(value = "addPersonnel", method = RequestMethod.POST)
	public String process(@Valid @ModelAttribute("personnelModel") PersonnelModel personnel, BindingResult bindingResult,
			Model model, HttpServletRequest rq) {

		if (bindingResult.hasErrors()) {
			return "form";
		}

		if (personnel.getTypePerson() == PersonnelModel.TYPE_ENSEIGNANT) {
			Enseignant ens = new Enseignant();
			BeanUtils.copyProperties(personnel, ens);

			personnelService.addPersonnel(ens);

		}

		else{
			Administrateur admin = new Administrateur();
			BeanUtils.copyProperties(personnel, admin);
			personnelService.addPersonnel(admin);

		}

		// rediriger vers l'action shwoForm avec le meme type de personne
		return "redirect:/showForm?typePerson=" + personnel.getTypePerson();
	}
	
	
	@RequestMapping(value = "updatePersonnelForm/{idPerson}", method = RequestMethod.GET)
	public String updatePersonForm(@PathVariable("idPersonnel") int idPersonnel, Model model) {

		Personnel personnel = personnelService.getPersonnelById(Long.valueOf(idPersonnel));
		PersonnelModel pm = new PersonnelModel();


		if (personnel instanceof Enseignant) {
			BeanUtils.copyProperties((Enseignant) personnel, pm);
			pm.setTypePerson(PersonnelModel.TYPE_ENSEIGNANT);
		} else  {
			BeanUtils.copyProperties((Enseignant) personnel, pm);
			pm.setTypePerson(PersonnelModel.TYPE_ADMIN);
		} 
		model.addAttribute("personModel", pm);

		return "updateForm";
	}
	
	@RequestMapping("updatePerson")
	public String updatePerson(@Valid @ModelAttribute("personModel") PersonnelModel personnel, BindingResult bindingResult,
			Model model) {

		// En cas d'erreur
		if (bindingResult.hasErrors()) {

			return "updateForm";
		}

		if (personnel.getTypePerson() == PersonnelModel.TYPE_ENSEIGNANT) {
			Enseignant ens = new Enseignant();
			BeanUtils.copyProperties(personnel, ens);

			personnelService.updatePersonnel(ens);

		} else  {
			Administrateur admin = new Administrateur();
			BeanUtils.copyProperties(personnel, admin);
			personnelService.updatePersonnel(admin);


		}

		// Mettre le message de succès dans le modèle
		model.addAttribute("msg", "Opération effectuée avec succès");

		return "updateForm";
	}	
	
	@RequestMapping(value = "deletePersonnel/{idPersonnel}", method = RequestMethod.GET)
		public String delete(@PathVariable int idPersonnel) {

			personnelService.deletePersonnel(Long.valueOf(idPersonnel));

			return "redirect:/form";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
