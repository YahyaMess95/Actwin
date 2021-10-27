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
public class Colonnes {
	
	@Id
	@GeneratedValue
	public Long id ;
	public String nomColonnes ;
	public Long idUser ;
	public String data ;
}
