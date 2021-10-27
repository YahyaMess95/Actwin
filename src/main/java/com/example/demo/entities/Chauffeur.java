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

public class Chauffeur {
	@Id
	@GeneratedValue
	private Long id ;
	private String nomChauffeur ;
	private String prenomChauffeur ;
	private String etatChauffeur ;
	private String typePermis ; 
	private String vehiculeChauffeur  ;
	private String depChauffeur ;
	private String codeAuthChauffeur ;
	private String emailChauffeur ; 
	private String numPhoneChauffeur ;
}
