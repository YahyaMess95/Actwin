package com.example.demo.controllers;
import java.util.Date;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.HistoriqueVehChauff;
import com.example.demo.entities.HistoriqueVehDep;
import com.example.demo.repositories.HistoriqueVehChauffRepository;
import com.example.demo.repositories.HistoriqueVehDepRepository;
import com.example.demo.repositories.HistoriqueVehGpsRepository;
import com.example.demo.services.implementations.ReportVehChauff;
import com.example.demo.services.implementations.ReportVehDep;
import com.lowagie.text.*;

import io.swagger.v3.oas.annotations.Operation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
 

@RestController
@CrossOrigin("*")
public class HistoriqueVehDepController {
	@Autowired 
	HistoriqueVehDepRepository rp ;
	
	@Autowired 
	HistoriqueVehGpsRepository rp1 ;
	
	@Autowired 
	HistoriqueVehChauffRepository rp2 ;
	
	@Autowired 
	HistoriqueVehDepRepository rp3 ;
	
	@GetMapping("getAllHistoriqueDep")
	List<HistoriqueVehDep> getAllHistoriqueDep() {
		return rp.findAll();
	}

	@GetMapping("getAllHistoriqueDepById/{id}")
	List<HistoriqueVehDep> getAllHistoriqueDepById(@PathVariable String id ) {
		return rp.findByIdVehicule(id);
	}

	
	@Operation(summary = "new (tet7at fel bouton general)")
	   @GetMapping("/Vehicule/Dep/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= Rapport_Veh_Dep_" + currentDateTime + ".pdf";
	       
	        response.setHeader(headerKey, headerValue);
	         
	        List<HistoriqueVehDep> dep = rp.findAll();
	  

	        ReportVehDep exporter = new ReportVehDep(dep);
	       
	        exporter.export(response);
	       
	         
	    }
	   
	   
	@Operation(summary = "new (tet7at fel bouton detail)")
	   @GetMapping("/Vehicule/Dep/pdf/{idVehicule}")
	    public void exportToPDFById(HttpServletResponse response , @PathVariable String idVehicule ) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= Rapport_Veh_Dep_" + currentDateTime + ".pdf";
	       
	        response.setHeader(headerKey, headerValue);
	         
	        List<HistoriqueVehDep> dep =  rp.findByIdVehicule(idVehicule);
	  

	        ReportVehDep exporter = new ReportVehDep(dep);
	       
	        exporter.export(response);
	       
	         
	    }
	   
	   
	   
	   

}
