package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Message;
import com.example.demo.entities.Chauffeur;
import com.example.demo.repositories.ChauffeurRepository;

@RestController
@CrossOrigin("*")

public class ChauffeurController {
	@Autowired
	ChauffeurRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getChauffeurs")
	List<Chauffeur> GetAllChauffeur() {
		
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddChauffeur")
	Message ajoutChauffeur(@RequestBody Chauffeur Action) {
		
		if (rp.findByNomChauffeur(Action.getNomChauffeur()).size() != 0 ) {return new Message("chauffeur name exist", false);}
		if (rp.findByCodeAuthChauffeur(Action.getCodeAuthChauffeur()).size() != 0 ) {return new Message("code auth exist", false);}
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateChauffeur/{id}")
	Message updateChauffeur(@RequestBody Chauffeur Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteChauffeur/{id}")
	Message deleteChauffeur( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
	

}
