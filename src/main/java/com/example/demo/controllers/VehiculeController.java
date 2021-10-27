package com.example.demo.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.entities.HistoriqueVehChauff;
import com.example.demo.entities.HistoriqueVehDep;
import com.example.demo.entities.HistoriqueVehGps;
import com.example.demo.entities.Vehicule;
import com.example.demo.repositories.HistoriqueVehChauffRepository;
import com.example.demo.repositories.HistoriqueVehDepRepository;
import com.example.demo.repositories.HistoriqueVehGpsRepository;
import com.example.demo.repositories.VehiculeRepository;

@RestController
@CrossOrigin("*")
public class VehiculeController {
	@Autowired
	VehiculeRepository rp;

	@Autowired
	HistoriqueVehDepRepository HVDR;

	@Autowired
	HistoriqueVehChauffRepository HVCR;
	
	@Autowired
	HistoriqueVehGpsRepository HVGR;
	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getVehicules")
	List<Vehicule> GetAllVehicule() {
		return rp.findAll();
	}
	
	
  @GetMapping("getVehiculeById/{id}")
  public  List<Vehicule> getVehiculeById(@PathVariable Long id){
		
		List<Vehicule> vehicule1 = new ArrayList<Vehicule>() ; 
		for (int i = 0; i < rp.findAll().size(); i++) {
		
			if(rp.findAll().get(i).getId().equals(id) ) {	vehicule1.add(rp.findAll().get(i));}
			
		
			
		}
		
		
		
		
		return vehicule1;
		
	}
	
	// Ajout

	@PostMapping("AddVehicule")
	Message ajoutVehicule(@RequestBody Vehicule Action) {
		
		if (rp.findByMatVehicule(Action.getMatVehicule()).size() != 0 ) {return new Message("Matricule exist", false);}
		if (rp.findByDepVehicule(Action.getDepVehicule()).size() != 0 ) {return new Message("dep exist", false);}

		if (rp.findByChaufVehicule(Action.getChaufVehicule()).size() != 0 ) {return new Message("chauffeur exist", false);}

		rp.save(Action);
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateVehicule/{id}")
	
	public Message updateVehicule(@RequestBody Vehicule Action, @PathVariable Long id) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		
		String avantdep = rp.findById(id).get().getDepVehicule();
		String avantgps = rp.findById(id).get().getEquipeVehicule() ; 
		String avantchauff = rp.findById(id).get().getChaufVehicule() ;
		String matricule = rp.findById(id).get().getMatVehicule() ;	
		HistoriqueVehDep chargeDep = new HistoriqueVehDep();
		HistoriqueVehChauff chargeChauff = new HistoriqueVehChauff();
		HistoriqueVehGps chargeGps = new HistoriqueVehGps();
		
		Action.setId(id);
		rp.save(Action);
		
				
		if (!avantdep.equals(Action.getDepVehicule())  ) {
						
			chargeDep.setAvant(avantdep);
			chargeDep.setApres(Action.getDepVehicule());
			chargeDep.setIdVehicule(matricule);
			chargeDep.setDate(formatter.format(date));
			HVDR.save(chargeDep);
		
		}
				
				
		if (!avantgps.equals(Action.getEquipeVehicule()) ) {
			
			chargeGps.setAvant(avantgps);
			chargeGps.setApres(Action.getEquipeVehicule());
			chargeGps.setIdVehicule(matricule);
			chargeGps.setDate(formatter.format(date));
			chargeGps.setKilometrage(Action.getKiloVehicule());
			HVGR.save(chargeGps) ;
		}
				

		
		if (!avantchauff.equals(Action.getChaufVehicule())) {
			
			chargeChauff.setAvant(avantchauff);
			chargeChauff.setApres(Action.getChaufVehicule());
			chargeChauff.setIdVehicule(matricule);
			chargeChauff.setDate(formatter.format(date));
			HVCR.save(chargeChauff) ;
		
		}
		
	
		
		return new Message("updated successfully", true);
	}
	

	// Delete

	@DeleteMapping("DeleteVehicule/{id}")
	Message deleteVehicule(@PathVariable Long id) {
		rp.deleteById(id);
		return new Message("deleted successfully", true);
	}
	
	
	
   
}
