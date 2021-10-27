package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.Message;
import com.example.demo.entities.Document;
import com.example.demo.entities.FileDocument;

import com.example.demo.repositories.DocumentRepository;
import com.example.demo.repositories.FileDocumentRepository;

@RestController
@CrossOrigin("*")

public class DocumentController {

	@Autowired
	DocumentRepository rp;

	@Autowired
	FileDocumentRepository fdr;
	
	
	static public Long GlobalDocId ;
	////////////////////////// CRUD ///////////////////////////////////

	// Affichage

	@GetMapping("getDocuments")
	List<Document> GetAllDocument() {
		return rp.findAll();
	}

	// Ajout

	@PostMapping("AddDocument")
	Message ajoutDocument(@RequestBody Document Action) {
		rp.save(Action);
		GlobalDocId = Action.getId() ;
		return new Message("Added successfully", true);
	}

	// Update

	@PutMapping("UpdateDocument/{id}")
	Message updateDocument(@RequestBody Document Action, @PathVariable  Long id) {

		
		 Action.setId(id);
		 rp.save(Action);
		 return new Message("updated successfully", true);
	}
	
	// Delete 
	
	@DeleteMapping("DeleteDocument/{id}")
	Message deleteDocument( @PathVariable  Long id) {rp.deleteById(id); return new Message("deleted successfully", true); }
	
	
	
	
	// upload 
	
	  @PostMapping("/uploadDocument")
	    public String uploadFacture(@RequestParam("file") MultipartFile file   ) {
	      try {
	        FileDocument filemode = new FileDocument(  file.getOriginalFilename(), file.getContentType(), file.getBytes() ,DocumentController.GlobalDocId  );
	        
	        
	        
	        fdr.save(filemode);
	        return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    
	      } 
	      catch (  Exception e) {
	      return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
	    }    
	    }
	
	
	
	  @GetMapping("/downloadDocument/{id}")
		 public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		   Optional<FileDocument> fileOptional =  fdr.findByIdDocument(id);
		   
		   if(fileOptional.isPresent()) {
			   FileDocument file = fileOptional.get();
		     return ResponseEntity.ok()
		         .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
		         .body(file.getPic());  
		   }
		   
		   return ResponseEntity.status(404).body(null);
		 }
	
	
		//get document by id vehicule
			@GetMapping("getDocumentsByIdVehicule/{VehiculeDocument}")
			List<Document> GetAllDocument(@PathVariable String  matVehicule) {
				return rp.findByVehiculeDocument(matVehicule);
			}
	
	
	
	
	
	
	
}
