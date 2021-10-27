package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ModelVehicule;

public interface ModelVehiculeRepository extends JpaRepository<ModelVehicule, Long> {
 List<ModelVehicule> findByMarqueModel(String marqueModel);
 
}
