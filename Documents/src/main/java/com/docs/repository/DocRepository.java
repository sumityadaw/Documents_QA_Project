package com.docs.repository;

import com.docs.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocRepository extends JpaRepository<Document, Long> {

    List<Document> findByTitleContainingIgnoreCase(String keyword);
    List<Document> findByAuthorIgnoreCase(String author);

}
