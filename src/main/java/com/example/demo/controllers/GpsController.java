package com.example.demo.controllers;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class GpsController {

	
   @GetMapping("GpsPosition")
   public String GPS()
	{
		  // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
 
        // 
        // Authentication
        // 
        String auth = "admin" + ":" + "admin";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        headers.set("Authorization", authHeader);
        // 
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("my_other_key", "my_other_value");
 
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);
 
        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange("http://62.171.157.49:8081/api/positions", //
                HttpMethod.GET, entity, String.class);
 
        String result = response.getBody();
 
        return (result);
	}
	
	
	
}
