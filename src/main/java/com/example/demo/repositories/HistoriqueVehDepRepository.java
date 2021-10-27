package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HistoriqueVehDep;

public interface HistoriqueVehDepRepository extends JpaRepository<HistoriqueVehDep, Long> {

	List<HistoriqueVehDep> findByIdVehicule(String idVehicule);
	
	

	
	
	
	
}
