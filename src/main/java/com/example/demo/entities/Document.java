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
public class Document {
	@Id
	@GeneratedValue
	private Long id ;
    private String nomDocument ; 
    private String dateValDocument ;
    private String etatPayDocument ;
    private String vehiculeDocument ;


	
}
