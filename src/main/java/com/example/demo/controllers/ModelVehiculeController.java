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
import com.example.demo.entities.ModelVehicule;
import com.example.demo.repositories.ModelVehiculeRepository;

@RestController
@CrossOrigin("*")
public class ModelVehiculeController {
	@Autowired
	ModelVehiculeRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getModelVehicules")
	List<ModelVehicule> GetAllModelVehicule() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddModelVehicule")
	Message ajoutModelVehicule(@RequestBody ModelVehicule Action) {
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateModelVehicule/{id}")
	Message updateModelVehicule(@RequestBody ModelVehicule Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteModelVehicule/{id}")
	Message deleteModelVehicule( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
	
	
	   @GetMapping("findModelbyMarque/{marque}")
	   List<ModelVehicule> FindModelByMarque(@PathVariable String marque){  return rp.findByMarqueModel(marque);}
	
}
