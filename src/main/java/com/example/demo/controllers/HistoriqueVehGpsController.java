package com.example.demo.controllers;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.HistoriqueVehChauff;
import com.example.demo.entities.HistoriqueVehGps;
import com.example.demo.repositories.HistoriqueVehGpsRepository;
import com.example.demo.services.implementations.ReportVehChauff;
import com.example.demo.services.implementations.ReportVehGps;
import com.lowagie.text.DocumentException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin("*")
public class HistoriqueVehGpsController {
	@Autowired 
	HistoriqueVehGpsRepository rp ;
	
	
	@GetMapping("getAllHistoriqueGps")
	List<HistoriqueVehGps> getAllHistoriqueGps() {
		return rp.findAll();
	}
	
	@GetMapping("getAllHistoriqueGpsById/{id}")
	List<HistoriqueVehGps> getAllHistoriqueGpsById(@PathVariable String id ) {
		return rp.findByIdVehicule(id);
	}
	@Operation(summary = "new (tet7at fel bouton general)")
	@GetMapping("/Vehicule/Gps/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename= Rapport_Veh_Gps_" + currentDateTime + ".pdf";

		response.setHeader(headerKey, headerValue);

		List<HistoriqueVehGps> chauff = rp.findAll();

		ReportVehGps exporter = new ReportVehGps(chauff);

		exporter.export(response);
	       
	         
	    }
	@Operation(summary = "new (tet7at fel bouton detail)")
	@GetMapping("/Vehicule/Gps/pdf/{idVehicule}")
    public void exportToPDFbyId(HttpServletResponse response , @PathVariable String idVehicule) throws DocumentException, IOException {
	response.setContentType("application/pdf");
	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String currentDateTime = dateFormatter.format(new Date());

	String headerKey = "Content-Disposition";
	String headerValue = "attachment; filename= Rapport_Veh_Gps_" + currentDateTime + ".pdf";

	response.setHeader(headerKey, headerValue);

	List<HistoriqueVehGps> chauff = rp.findByIdVehicule(idVehicule) ;

	ReportVehGps exporter = new ReportVehGps(chauff);

	exporter.export(response);
       
         
    }
	

}
