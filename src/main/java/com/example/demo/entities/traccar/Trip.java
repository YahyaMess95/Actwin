package com.example.demo.entities.traccar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

	Long deviceId ; 
	String  deviceName ;
	float distance ;
	float averageSpeed ;
	float maxSpeed ;
	float spentFuel ;
	float startOdometer ;
	float endOdometer ; 
	String startTime ; 
	String endTime ; 
	Long startPositionId ;
	Long endPositionId ;
	float startLat ;
	float startLon ;
	float endLat ;
	float endLon ;
	String startAddress ; 
	String endAddress ;
	float duration ;
	
	
	
	
	
	
	
	
	
}
