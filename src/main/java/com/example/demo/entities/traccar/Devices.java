package com.example.demo.entities.traccar;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Devices {
	@Id
private Long id ; 
private String name ; 
private String status ; 
private String uniqueId ; 
private Long positionId ;
private Long phone ; 
private String model ; 
private String lastUpdate ;
private String matricule ;
}
