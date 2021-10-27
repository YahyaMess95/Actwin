package com.example.demo.controllers.traccar;

import java.nio.charset.Charset;
import java.util.ArrayList;
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

import com.example.demo.entities.traccar.Users;

@RestController
@CrossOrigin("*")
public class UserController {

	@GetMapping("getUsers")
	Users[] GetUsers() {

		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		String auth = "admin" + ":" + "admin";
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		// HttpEntity<Employee[]>: To get result as Employee[].
		HttpEntity<Users[]> entity = new HttpEntity<Users[]>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method, and Headers.
		ResponseEntity<Users[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/users", //
				HttpMethod.GET, entity, Users[].class);

		// Response Body Data
		Users[] list = response.getBody();
		return list;

	}

	@GetMapping("Session/{login}/{mdp}")
	List<Users> Session(@PathVariable String login, @PathVariable String mdp) {

		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		String auth = "admin" + ":" + "admin";
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);
		// HttpEntity<Employee[]>: To get result as Employee[].
		HttpEntity<Users[]> entity = new HttpEntity<Users[]>(headers);

		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET method, and Headers.
		ResponseEntity<Users[]> response = restTemplate.exchange("http://62.171.157.49:8081/api/users", //
				HttpMethod.GET, entity, Users[].class);

		// Response Body Data
		Users[] list = response.getBody();
		List<Users> Lusers = new ArrayList<Users>();

		for (int i = 0; i < list.length; i++) {

			if (list[i].getEmail().equals(login) )
				Lusers.add(list[i]);
		}
		

		return Lusers;

	}

}
