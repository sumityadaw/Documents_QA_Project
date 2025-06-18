package com.docs.service;

import com.docs.entity.Document;
import com.docs.repository.DocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;

    public ResponseEntity<?> processFile(MultipartFile file, String author) {
        try {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            Document doc = new Document();
            doc.setTitle(file.getOriginalFilename());
            doc.setAuthor(author);
            doc.setUploadDate(LocalDate.now());
            doc.setContent(content);
            doc.setType("TEXT"); // Assume TEXT or parse extension
            docRepository.save(doc);
            return ResponseEntity.ok("Saved");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error uploading");
        }
    }

    public List<Document> searchByKeyword(String keyword) {
        return docRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Document> filterByAuthor(String author) {
        return docRepository.findByAuthorIgnoreCase(author);
    }
}

