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
import com.example.demo.entities.Colonnes;
import com.example.demo.repositories.ColonnesRepository;


@RestController
@CrossOrigin("*")
public class ColonnesController {
	
	@Autowired
	ColonnesRepository rp;
	
	

	// Affichage

	@GetMapping("getColonnes")
	List<Colonnes> GetAllColonnes() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddColonnes")
	Message ajoutColonnes(@RequestBody List<Colonnes> Action) {
		for (Colonnes colonnes : Action) {
			rp.save(colonnes);	
		}
		
		
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateColonnes/{id}")
	Message updateCompte(@RequestBody Colonnes Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	
	
	// Affichage selon idUser

	@GetMapping("getColonnes/{idUser}")
	List<Colonnes> GetAllColonnes(@PathVariable  Long idUser) {
		return rp.findByIdUser(idUser);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteColonnes/{id}")
	Message deleteColonnes( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
}
