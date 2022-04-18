package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Equipement {
	@Id
	@GeneratedValue
	Long id ; 
	String raisonSocial;
	String nom ; 
	String siteWeb ; 
	String adresse ; 
	String tel1 ;
	String tel2 ; 
	String email1;
	String email2;
	String decalageHoraire; 
	int nombreAut ; 
	int nombreIll ; 
	String nomUser ; 
	String password; 
	String confPassword;
	public Equipement(Long id, String raisonSocial, String nom, String siteWeb, String adresse, String tel1,
			String tel2, String email1, String email2, String decalageHoraire, int nombreAut, int nombreIll,
			String nomUser, String password, String confPassword) {
		super();
		this.id = id;
		this.raisonSocial = raisonSocial;
		this.nom = nom;
		this.siteWeb = siteWeb;
		this.adresse = adresse;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email1 = email1;
		this.email2 = email2;
		this.decalageHoraire = decalageHoraire;
		this.nombreAut = nombreAut;
		this.nombreIll = nombreIll;
		this.nomUser = nomUser;
		this.password = password;
		this.confPassword = confPassword;
	} 
	
	
	
	
	
}
