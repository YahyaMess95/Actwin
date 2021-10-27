package com.example.demo.controllers.traccar;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.traccar.Devices;
import com.example.demo.entities.traccar.Events;
import com.example.demo.entities.traccar.Trip;

@RestController
@CrossOrigin(origins = "*")
public class EventsController {
	
	
	@GetMapping("GetEvents/{dateDeb}/{dateFin}/{deviceId}/{type}")
	Events[] Getevents(@PathVariable String dateDeb , @PathVariable String dateFin ,@PathVariable Long deviceId,@PathVariable String type)
	{
	    // HttpHeaders
	    HttpHeaders headers = new HttpHeaders();
	    String auth = "admin" + ":" + "admin";
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	    String authHeader = "Basic " + new String(encodedAuth);
	    headers.set("Authorization", authHeader);
	    
	    // HttpEntity<Employee[]>: To get result as Employee[].
	    HttpEntity<Events[]> entity = new HttpEntity<Events[]>(headers);

	    // RestTemplate
	    RestTemplate restTemplate = new RestTemplate();

	    // Send request with GE	T method, and Headers.
	    ResponseEntity<Events[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/reports/events?from="+dateDeb+"T00:01:00Z&to="+dateFin+"T23:59:00Z&deviceId="+deviceId+"&type="+type, //
	    HttpMethod.GET, entity, Events[].class);

	    // Response Body Data
	    Events[] list = response.getBody();
	    
	    return list ; 

	      

	}
	
	
	
	
	
	
	
	@GetMapping("GetTrips/{dateDeb}/{dateFin}/{deviceId}")
	Trip[] GetTrips(@PathVariable String dateDeb , @PathVariable String dateFin ,@PathVariable Long deviceId)
	{
	    // HttpHeaders
	    HttpHeaders headers = new HttpHeaders();
	    String auth = "admin" + ":" + "admin";
	    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
	    String authHeader = "Basic " + new String(encodedAuth);
	    headers.set("Authorization", authHeader);
	    
	    // HttpEntity<Employee[]>: To get result as Employee[].
	    HttpEntity<Trip[]> entity = new HttpEntity<Trip[]>(headers);

	    // RestTemplate
	    RestTemplate restTemplate = new RestTemplate();

	    // Send request with GE	T method, and Headers.
	    ResponseEntity<Trip[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/reports/trips?from="+dateDeb+"T00:01:00Z&to="+dateFin+"T23:59:00Z&deviceId="+deviceId, //
	    HttpMethod.GET, entity, Trip[].class);

	    // Response Body Data
	    Trip[] list = response.getBody();
	    
	    return list ; 

	      

	}
	
	
	
	
	
	
	@GetMapping("offlineDevices")
	 List<Devices> testDate() {
		
		
		
		

		
		
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
		    List<Devices> list1 = new ArrayList<Devices>() ;
		    for (int i = 0; i < list.length; i++) {
				
		    	
		    	
		    	
		    
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	if (list[i].getLastUpdate() != null)    {
		    		
		    		
		    		
		    		
		    		
			    	Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					System.out.println(formatter.format(date));
					
					String dateStart = list[i].getLastUpdate().replace("T", " ").substring(0, 19) ;
					String dateStop = formatter.format(date) ;
					
					
					
					
					


					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

					Date d1 = null;
					Date d2 = null;
					try {
					    d1 = (Date) format.parse(dateStart);
					    d2 = (Date) format.parse(dateStop);
					} catch (ParseException e) {
					    e.printStackTrace();
					}    

					// Get msec from each, and subtract.
					long diff = d2.getTime() - d1.getTime();
					long diffSeconds = diff / 1000;         
					long diffMinutes = diff / (60 * 1000);         
					long diffHours = diff / (60 * 60 * 1000);                      
				
			    	
		    		if (diffHours > 12 ) {
						list1.add(list[i]) ;
					}
		    		
		    		
		    		
		    	}
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
			}
		    return list1 ; 
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
