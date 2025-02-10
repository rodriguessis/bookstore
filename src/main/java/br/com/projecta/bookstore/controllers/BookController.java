package br.com.projecta.bookstore.controllers;

import br.com.projecta.bookstore.domain.book.Book;
import br.com.projecta.bookstore.domain.book.BookRepository;
import br.com.projecta.bookstore.domain.book.RequestBook;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity listAll() {

        var allBook = this.repository.findAll();
        return ResponseEntity.ok(allBook);

    }

    @PostMapping
    public ResponseEntity registerBook(@RequestBody @Valid RequestBook book ) {

        var newBook = new Book( book );
        var salvedBook = this.repository.save(newBook);

        return ResponseEntity.ok(salvedBook);
    }

    @PutMapping("{id}")
    @Transactional
    public  ResponseEntity updateBook( @PathVariable("id") Integer id,
                                       @RequestBody @Valid RequestBook book ) {

        Optional<Book> optionalBook = this.repository.findById(id);

        if ( optionalBook.isPresent() ) {
            Book upBook = optionalBook.get();
            upBook.setAll(book);
            return ResponseEntity.ok(upBook);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Integer id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build() ;
    }

}
