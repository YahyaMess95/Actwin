package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.FileDocument;

public interface FileDocumentRepository  extends JpaRepository<FileDocument, Long>{

	Optional<FileDocument> findByIdDocument(Long id) ;
}
