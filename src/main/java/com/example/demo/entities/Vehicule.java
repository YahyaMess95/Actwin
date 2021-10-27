package com.example.demo.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicule {
	@Id
	@GeneratedValue
	private Long id ;
	private String matVehicule ;
	private String depVehicule ;
	private String etatInstVehicule ;
	private String chaufVehicule ;
	private String marqVehicule ;
	private String modVehicule ;
	private String annVehicule ;
	private String typeEnergVehicule ;
	private String equipeVehicule ;
	private String numPuceVehicule ; 
	private String capReservVehicule ;
	private String kiloVehicule ;
	private String consoTheoVehicule ;
	private String TypeVehicule ;
	private String modDevice ;

	
	
	
}
