package br.com.projecta.bookstore.controllers;

import br.com.projecta.bookstore.domain.exemplary.BookExemplary;
import br.com.projecta.bookstore.domain.exemplary.BookExemplaryRepository;
import br.com.projecta.bookstore.domain.exemplary.RequestBookExemplary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-exemplary")
public class BookExemplaryController {

    @Autowired
    private BookExemplaryRepository repository;

    @PostMapping
    public ResponseEntity addExemplary(@RequestBody @Valid RequestBookExemplary bookExemplary ) {

        var exemplary = new BookExemplary(bookExemplary.number(), bookExemplary.book_id() );

        this.repository.save(exemplary);

        return ResponseEntity.ok().build();
    }

}
