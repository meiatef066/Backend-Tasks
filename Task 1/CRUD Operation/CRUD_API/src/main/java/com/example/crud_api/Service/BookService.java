package com.example.crud_api.Service;

import com.example.crud_api.Repository.BookRepository;
import com.example.crud_api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // add new book to database
    public Optional<Book> findBookById( int id) {
        return this.bookRepository.findById(Long.valueOf(id));
    }
    // receive book
  public List<Book> ReceiveAllBooks(){
       List<Book> books = new ArrayList<>();
    books=bookRepository.findAll();
    for(Book book:books){
        System.out.println(book);
    }
       return books;
   }

    public Book save( Book book ) {
        return this.bookRepository.save(book);
    }
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublishedDate(book.getPublishedDate());
            return bookRepository.save(existingBook);
        });
    }

    public boolean deleteById (String id) {
        Optional<Book> book=this.bookRepository.findById(Long.valueOf(id));
        if(book.isPresent()){
            this.bookRepository.delete(book.get());
            return true;
        }
        return false;
    }
}
