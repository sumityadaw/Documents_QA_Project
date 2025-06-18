package com.docs.controller;

import com.docs.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/docs")
public class DocController {

    @Autowired
    private DocService docService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDocument(@RequestParam("file") MultipartFile file,
                                            @RequestParam String author) {
        return docService.processFile(file, author);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String keyword) {
        return ResponseEntity.ok(docService.searchByKeyword(keyword));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filterByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(docService.filterByAuthor(author));
    }
}
