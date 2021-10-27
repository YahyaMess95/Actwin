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
import com.example.demo.entities.TypePermis;
import com.example.demo.repositories.TypePermisRepository;

@RestController
@CrossOrigin("*")
public class TypePermisController {
	@Autowired
	TypePermisRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getTypePermis")
	List<TypePermis> GetAllTypePermis() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddTypePermis")
	Message ajoutTypePermis(@RequestBody TypePermis Action) {
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateTypePermis/{id}")
	Message updateTypePermis(@RequestBody TypePermis Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteTypePermis/{id}")
	Message deleteTypePermis( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
}
