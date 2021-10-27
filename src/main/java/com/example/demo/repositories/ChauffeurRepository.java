package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long>{

	
	List<Chauffeur> findByNomChauffeur(String nomChauffeur) ;
	List<Chauffeur>  findByCodeAuthChauffeur(String code);
}
