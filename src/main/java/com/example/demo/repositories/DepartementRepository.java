package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

	List<Departement>findByNomDepartement(String departement) ;
}
