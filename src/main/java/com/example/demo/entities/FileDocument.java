package com.example.demo.entities;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class FileDocument {

	@Id
	@Column(name = "id")
	@GeneratedValue 
	@JsonView(View.FileInfo.class)
	private Long id;
  
    @Column(name = "name")
    @JsonView(View.FileInfo.class)
    private String name;
    
  
    @Column(name = "mimetype")
    private String mimetype;
  
    @Lob
    @Column(name="pic")
    private byte[] pic;
    

    private Long idDocument ;
    


	public FileDocument(String name, String mimetype, byte[] pic, Long idDocument ) {
		super();
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;
		this.idDocument = idDocument;
	}
    
    
    
    
}
