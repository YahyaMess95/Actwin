package com.example.demo.controllers.traccar;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Message;
import com.example.demo.entities.traccar.Devices;
import com.example.demo.entities.traccar.UserDevices;
import com.example.demo.entities.traccar.Users;
import com.example.demo.repositories.AffectationVehiculeGpsRepository;
import com.example.demo.repositories.UserDevicesRepository;
import com.example.demo.repositories.VehiculeRepository;
@RestController
@CrossOrigin(origins = "*")
public class AffectationController {
	@Autowired 
	UserDevicesRepository uD ;
	
	@Autowired
	AffectationVehiculeGpsRepository AVGR ; 
	@Autowired
	VehiculeRepository rp;
	
	
	@PostMapping("affecterClientDevice")
	Message affecter(@RequestBody UserDevices UsD) 
	{
		uD.save(UsD) ;
		return new Message("affcter avec succées" , true);
	}
	
	
	
	@GetMapping("AfficherAffected")
	List<UserDevices> GetUsersAffected(){return uD.findAll() ;}
	
	
	@DeleteMapping("DeleteAffected/{id}")
	Message DeleteDevice(@PathVariable long id) {uD.deleteById(id);return  new Message("delete affected" , true);}
	
	
	
	@GetMapping("AllAffected/{id}")
	List<Devices> GetAllAffected(@PathVariable long id ){
	
		DeviceController DC = new DeviceController() ;
		
		
		
		List<Devices> devices1 = new ArrayList<Devices>() ; 
		
		for (int i = 0; i < uD.findAll().size(); i++) {
			
			
		if (id == uD.findAll().get(i).getIdUser() ) {
		
		devices1.addAll(GetDevicesById(uD.findAll().get(i).getIdDevice()) ) ;
		
		
	}}
		
		return devices1 ;
	}
	
public List<Devices> GetDevicesById( Long id )
	{
	    // HttpHeaders
	    HttpHeaders headers = new HttpHeaders();
	    String auth = "admin" + ":" + "admin";
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	    String authHeader = "Basic " + new String(encodedAuth);
	    headers.set("Authorization", authHeader);
	    
	    // HttpEntity<Employee[]>: To get result as Employee[].
	    HttpEntity<Devices[]> entity = new HttpEntity<Devices[]>(headers);

	    // RestTemplate
	    RestTemplate restTemplate = new RestTemplate();

	    // Send request with GET method, and Headers.
	    ResponseEntity<Devices[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/devices", //
	    HttpMethod.GET, entity, Devices[].class);

	    // Response Body Data
	    Devices[] list = response.getBody();
	    List<Devices> list1 = new ArrayList<Devices>();
	    
	    
	    for (int i = 0; i < list.length; i++) {
	    	
	    	Devices b  = new Devices() ; 
	    	b = list[i] ;
	    	
	    	if(id == list[i].getId()) {
	    		
	    	
	    		
	    	
	    		list1.add(b) ;}
			
		}
	    
	    list1.get(0).setMatricule(matriculeByDevice(id));
	    
	    return list1 ; 

	      

	}
	
String matriculeByDevice( long idDevice) {
	
	String matricule = "" ;
	
	for (int i = 0; i < AVGR.findAll().size(); i++) {
		
		
		if ( AVGR.findAll().get(i).getIdGps().equals(idDevice)) {
		
			matricule = rp.findById(AVGR.findAll().get(i).getIdVehicule()).get().getMatVehicule() ; 
			
			
		
	}}
	
	
	return matricule ;
}
	
	
}
