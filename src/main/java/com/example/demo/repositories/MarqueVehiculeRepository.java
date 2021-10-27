package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MarqueVehicule;

public interface MarqueVehiculeRepository extends JpaRepository<MarqueVehicule, Long> {

}
