package com.example.demo.controllers;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Message;
import com.example.demo.entities.Compte;
import com.example.demo.repositories.CompteRepository;

@RestController
@CrossOrigin("*")
public class CompteController {

	
	@Autowired
	CompteRepository rp;

	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getComptes")
	List<Compte> GetAllCompte() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddCompte")
	Message ajoutCompte(@RequestBody Compte Action) {
		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateCompte/{id}")
	Message updateCompte(@RequestBody Compte Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteCompte/{id}")
	Message deleteCompte( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
	
	
	
	   @GetMapping("GetUsers/{login}/{mdp}")
	   public String Users(@PathVariable  String login , @PathVariable  String mdp)
		{
		   
		   String user = "" ; 
			 if(login.equals("admin")  &&  login.equals("admin") ) {user =  "admin" ; }
			 else {user = "client";}
			 return user ; 
		}
	
	
	
	
}
