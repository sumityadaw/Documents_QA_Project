package com.docs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private LocalDate uploadDate;

    @Lob
    private String content;

    private String type; // PDF, TEXT, DOCX
}
