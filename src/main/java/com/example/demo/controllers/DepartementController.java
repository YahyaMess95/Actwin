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
import com.example.demo.entities.Departement;
import com.example.demo.repositories.DepartementRepository;
import com.example.demo.repositories.HistoriqueVehDepRepository;

@RestController
@CrossOrigin(origins = "*")
public class DepartementController {
	
	@Autowired
	DepartementRepository rp;
	
	@Autowired 
	HistoriqueVehDepRepository HVDR ;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getDepartements")
	List<Departement> GetAllDepartement() {
		
		
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddDepartement")
	Message ajoutDepartement(@RequestBody Departement Action) {
		
		if (rp.findByNomDepartement(Action.getNomDepartement()).size() != 0 ) {return new Message("departement exist", false);}
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateDepartement/{id}")
	Message updateDepartement(@RequestBody Departement Action, @PathVariable  Long id) {

		 
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteDepartement/{id}")
	Message deleteDepartement( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
}
