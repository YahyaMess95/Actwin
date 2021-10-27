package com.example.demo.entities.traccar;

import com.example.demo.entities.Colonnes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

	public Long id ;
	public String email ; 
	public String phone ; 
	public String readonly ;
	public String administrator ; 
}
