package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HistoriqueVehChauff;

public interface HistoriqueVehChauffRepository extends JpaRepository<HistoriqueVehChauff,Long>{

	List<HistoriqueVehChauff> findByIdVehicule(String idVehicule);
	
	
}
