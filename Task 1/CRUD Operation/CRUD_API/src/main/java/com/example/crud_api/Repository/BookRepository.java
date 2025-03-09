package com.example.crud_api.Repository;

import com.example.crud_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
 public Book findByTitle(String title);
 public Optional<Book> findById( Long id);

}
