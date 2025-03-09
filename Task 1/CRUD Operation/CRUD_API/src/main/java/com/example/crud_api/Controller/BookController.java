package com.example.crud_api.Controller;

import com.example.crud_api.Service.BookService;
import com.example.crud_api.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // TODO get all books
    @GetMapping()
    public ResponseEntity<List<Book>> RetrieveAllBooks(){
        List<Book> books=bookService.ReceiveAllBooks();
        return ResponseEntity.ok(books);
    }

    // TODO retrieve specific book by id
    @GetMapping("/{id}")
    public ResponseEntity<Book> RetrieveBookById( @PathVariable String id ){
        Optional<Book> book=bookService.findBookById(Integer.parseInt(id));
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // TODO ADD new BOOK
    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (book.getId() != null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook( @PathVariable String id, @RequestBody Book book) {
        Optional<Book> updatedBook = bookService.update(id, book);
        return updatedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
        if (!bookService.deleteById(id)) {
            return ResponseEntity.notFound().build();
        }
       return ResponseEntity.noContent().build();
    }


}
