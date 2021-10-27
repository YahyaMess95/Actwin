package com.example.demo.entities.traccar;

import com.example.demo.dto.PositionDevice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Events {

	public long id ; 
	public long deviceId ; 
	public String type ; 
	public String eventTime ; 
	public String deviceName ; 
}
