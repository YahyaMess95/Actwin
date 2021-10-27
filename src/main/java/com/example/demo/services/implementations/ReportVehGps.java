package com.example.demo.services.implementations;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entities.HistoriqueVehGps;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ReportVehGps {

	private List<HistoriqueVehGps> listHisGps;
	
	   public ReportVehGps(List<HistoriqueVehGps> listUsers) {
	        this.listHisGps = listUsers;
	    }
	
	   private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	      
	         
	        cell.setPhrase(new Phrase("Matricule", font));
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Kilometrage", font));
	         
	        table.addCell(cell);
	        
	        cell.setPhrase(new Phrase("Avant", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Aprés", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Date", font));
	        table.addCell(cell);       
	    }
	   
	   
	   private void writeTableData(PdfPTable table) {
	        for (HistoriqueVehGps Gps : listHisGps) {
	            
	            table.addCell(String.valueOf(Gps.getIdVehicule()));
	            table.addCell(String.valueOf(Gps.getKilometrage()));
	            table.addCell(Gps.getAvant());
	            table.addCell(Gps.getApres());
	            table.addCell(Gps.getDate().toString());
	            
	        }
	    }
	   
	   
	   
	   
	   
	   
	   
	   public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A3);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        
	        document.open();
	        
	        

	        
	        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font1.setSize(10);
	     
	        
	        Paragraph p1 = new Paragraph("Rapport généré en "+currentDateTime, font1);
	        p1.setAlignment(Paragraph.ALIGN_LEFT);
	        document.add(p1);
	        
	        
	        
	        
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        
	        
	        Paragraph p = new Paragraph("Rapport Gps-Vehicule", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 1.5f, 3.0f, 3.0f, 3.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
