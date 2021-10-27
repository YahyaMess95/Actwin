package com.example.demo.entities.traccar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.entities.Colonnes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Position {
	
	@Id
private Long id ; 
private float latitude ; 
private float longitude ;
private float speed ;
private String protocol ; 
private Long deviceId ; 


}
