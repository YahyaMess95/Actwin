package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
List<Vehicule> findByMatVehicule(String matVehicule);
List<Vehicule> findByChaufVehicule(String chaufVehicule);
List<Vehicule> findByDepVehicule(String depVehicule);


}
