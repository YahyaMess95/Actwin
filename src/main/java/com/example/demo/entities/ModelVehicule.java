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
public class ModelVehicule {
	@Id
	@GeneratedValue
	private Long id ;
	private String nomModele ;
	//List
	private String marqueModel ; 
}
