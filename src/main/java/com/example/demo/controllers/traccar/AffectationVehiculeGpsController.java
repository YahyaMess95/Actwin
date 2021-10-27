package com.example.demo.controllers.traccar;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controllers.VehiculeController;
import com.example.demo.entities.Vehicule;
import com.example.demo.entities.traccar.AffectationVehiculeGps;
import com.example.demo.entities.traccar.Devices;
import com.example.demo.repositories.AffectationVehiculeGpsRepository;
import com.example.demo.repositories.VehiculeRepository;

@RestController
@CrossOrigin(origins = "*")
public class AffectationVehiculeGpsController {

	@Autowired
	AffectationVehiculeGpsRepository AVGR ; 
	@Autowired
	VehiculeRepository rp;
	
	
	
	
	
	
	

	@GetMapping("affectedgpsfromcar/{idUser}/{idGps}")
	List<Vehicule> GetAllAffected(@PathVariable long idUser ,@PathVariable long idGps  ){
	
		VehiculeController VC = new VehiculeController() ;
		
		
		
		List<Vehicule> vehicule1 = new ArrayList<Vehicule>() ; 
		
		for (int i = 0; i < AVGR.findAll().size(); i++) {
			
			
		if ( AVGR.findAll().get(i).getIdGps().equals(idGps) && AVGR.findAll().get(i).getIdUser().equals(idUser) ) {
		
			 vehicule1.addAll(getVehiculeById1(AVGR.findAll().get(i).getIdVehicule())) ;
			
			
			
		
	}}
		
		return vehicule1 ;
	}
	
	
	  public  List<Vehicule> getVehiculeById1( Long id){
			
			List<Vehicule> vehicule1 = new ArrayList<Vehicule>() ; 
			for (int i = 0; i < rp.findAll().size(); i++) {
			
				if(rp.findAll().get(i).getId().equals(id) ) {	vehicule1.add(rp.findAll().get(i));}
				
			
				
			}
			
			
			
			
			return vehicule1;
			
		}
	  
	  
	  
	  
	  
	
	
}
