package com.example.demo.dto;

import com.example.demo.entities.traccar.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDevice {
	
	// position part 
	
	// id similar to positionId
	private Long id ; 
	private float latitude ; 
	private float longitude ;
	private float speed ;
	private String protocol ; 
	private Long deviceId ; 
	
	
	// device part 
	
	private String name ; 
	private String status ; 
	private String uniqueId ; 
	private Long positionId ;
	private Long phone ; 
	private String model ; 
	private String lastUpdate ;
	
	
	
	
}
