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
import com.example.demo.entities.MarqueVehicule;
import com.example.demo.repositories.MarqueVehiculeRepository;

@RestController
@CrossOrigin("*")
public class MarqueVehiculeController {
	@Autowired
	MarqueVehiculeRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getMarqueVehicules")
	List<MarqueVehicule> GetAllMarqueVehicule() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddMarqueVehicule")
	Message ajoutMarqueVehicule(@RequestBody MarqueVehicule Action) {
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateMarqueVehicule/{id}")
	Message updateMarqueVehicule(@RequestBody MarqueVehicule Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteMarqueVehicule/{id}")
	Message deleteMarqueVehicule( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
}
