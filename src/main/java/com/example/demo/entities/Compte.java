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
public class Compte {
	@Id
	@GeneratedValue
	private Long id;
	private String nomCompte;
	private String prenomCompte;
	private String loginCompte;
	

	private String depAsuivreCompte;

}
