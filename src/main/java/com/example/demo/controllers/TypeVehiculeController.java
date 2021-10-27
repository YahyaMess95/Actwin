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
import com.example.demo.entities.TypeVehicule;
import com.example.demo.repositories.TypeVehiculeRepository;

@RestController
@CrossOrigin("*")
public class TypeVehiculeController {

	@Autowired
	TypeVehiculeRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getTypeVehicules")
	List<TypeVehicule> GetAllTypeVehicule() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddTypeVehicule")
	Message ajoutTypeVehicule(@RequestBody TypeVehicule Action) {
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateTypeVehicule/{id}")
	Message updateTypeVehicule(@RequestBody TypeVehicule Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteTypeVehicule/{id}")
	Message deleteTypeVehicule( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
	
}
