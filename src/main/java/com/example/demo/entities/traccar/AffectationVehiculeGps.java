package com.example.demo.entities.traccar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.entities.HistoriqueVehDep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AffectationVehiculeGps {

	
	@Id
	@GeneratedValue
		Long id ; 
	    Long idUser ; 
		Long idGps ;
		Long idVehicule ; 
		
}
