package com.example.demo.controllers.traccar;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

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

import com.example.demo.entities.traccar.Position;

@RestController
@CrossOrigin("*")
public class PositionController
{
@GetMapping("getPositions")
Position[] GetPosition()
{

    // HttpHeaders
    HttpHeaders headers = new HttpHeaders();
    String auth = "admin" + ":" + "admin";
    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
    String authHeader = "Basic " + new String(encodedAuth);
    headers.set("Authorization", authHeader);
    // HttpEntity<Employee[]>: To get result as Employee[].
    HttpEntity<Position[]> entity = new HttpEntity<Position[]>(headers);

    // RestTemplate
    RestTemplate restTemplate = new RestTemplate();

    // Send request with GET method, and Headers.
    ResponseEntity<Position[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/positions", //
            HttpMethod.GET, entity, Position[].class);

 

 
        // Response Body Data
Position[] list = response.getBody();

        return list ; 

      

}
}
