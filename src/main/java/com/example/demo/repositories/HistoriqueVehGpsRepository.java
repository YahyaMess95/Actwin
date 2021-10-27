package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.HistoriqueVehGps;

public interface HistoriqueVehGpsRepository extends JpaRepository<HistoriqueVehGps, Long> {

	List<HistoriqueVehGps> findByIdVehicule(String idVehicule);
	
	
}
