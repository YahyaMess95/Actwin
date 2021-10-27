package com.example.demo.controllers.traccar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PositionDevice;
import com.example.demo.entities.traccar.Position;

import ch.qos.logback.core.joran.conditional.IfAction;

import com.example.demo.entities.traccar.Devices;
@RestController
@CrossOrigin("*")

public class PositionDevicesController {


    @GetMapping("GetPositionAndDevice")
	public List<PositionDevice> GetDeviceByPosition( )
	{
	
		// Devices
		DeviceController DC = new DeviceController() ; 
		Devices[] listDevices =  DC.GetDevices() ;	
		
		// Position
		PositionController PC = new PositionController() ;
		Position[] listPositions =  PC.GetPosition() ;	
		
		// PositionDevice 
		List<PositionDevice>  PositionDevices = new ArrayList<PositionDevice>() ; 
		
		
		for (int i = 0; i < listDevices.length; i++) {
   			for (int j = 0; j <  listPositions.length; j++) {
   			if ( listDevices[i].getId() == listPositions[j].getDeviceId()) {
   				
   			        PositionDevice positionDevice = new PositionDevice() ;
   					positionDevice.setDeviceId(listDevices[i].getId());
   					positionDevice.setLastUpdate(listDevices[i].getLastUpdate());
   					positionDevice.setLatitude(listPositions[j].getLatitude()); 
   					positionDevice.setLongitude(listPositions[j].getLongitude());
   					positionDevice.setStatus(listDevices[i].getStatus());
   					positionDevice.setName(listDevices[i].getName());
   					positionDevice.setPhone(listDevices[i].getPhone());
   					positionDevice.setPositionId(listDevices[i].getPositionId());
   					PositionDevices.add(positionDevice);	
   		     		}
   	              	}}
   	
   	return PositionDevices;	}
   	
	
    
    
    
    @GetMapping("GetPositionAndDeviceById/{id}")
   	public List<PositionDevice> GetDeviceByPositionById( @PathVariable  Long id )
   	{
   	
   		//Devices
   		DeviceController DC = new DeviceController() ; 
   		Devices[] listDevices =  DC.GetDevices() ;	
   		
   		//Position
   		PositionController PC = new PositionController() ;
   		Position[] listPositions =  PC.GetPosition() ;	
   		
   		//PositionDevice 
   		List<PositionDevice>  PositionDevices = new ArrayList<PositionDevice>() ; 
   
   	
   		
   		for (int i = 0; i < listDevices.length; i++) {
   			for (int j = 0; j <  listPositions.length; j++) {
   			if (listDevices[i].getId() == id && listDevices[i].getId() == listPositions[j].getDeviceId()) {
   				
   			        PositionDevice positionDevice = new PositionDevice() ;
   					positionDevice.setDeviceId(listDevices[i].getId());
   					positionDevice.setLastUpdate(listDevices[i].getLastUpdate());
   					positionDevice.setLatitude(listPositions[j].getLatitude()); 
   					positionDevice.setLongitude(listPositions[j].getLongitude());
   					positionDevice.setStatus(listDevices[i].getStatus());
   					positionDevice.setName(listDevices[i].getName());
   					positionDevice.setPhone(listDevices[i].getPhone());
   					positionDevice.setPositionId(listDevices[i].getPositionId());
   					PositionDevices.add(positionDevice);	
   		     		}
   	              	}}
   	
   	return PositionDevices;	}
   	
       
    
    
	
}
