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
public class HistoriqueVehDep {
	@Id
	@GeneratedValue
	private Long id ;
	private String idVehicule ;
    private String avant ; 
    private String apres ;
    private String date ;

}
