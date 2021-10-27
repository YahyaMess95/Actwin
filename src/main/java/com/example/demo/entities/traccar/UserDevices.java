package com.example.demo.entities.traccar;

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
public class UserDevices {
	@Id
	@GeneratedValue
	public Long id ; 
	public Long idUser ; 
	public Long idDevice ; 

}
