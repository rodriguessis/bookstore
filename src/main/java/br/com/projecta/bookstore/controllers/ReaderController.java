package br.com.projecta.bookstore.controllers;

import br.com.projecta.bookstore.domain.reader.Reader;
import br.com.projecta.bookstore.domain.reader.ReaderRepository;
import br.com.projecta.bookstore.domain.reader.RequestReader;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reader")
public class ReaderController {

    @Autowired
    ReaderRepository repository;

    @GetMapping
    public ResponseEntity listAll() {
        var allReaders = this.repository.findAll();
        return ResponseEntity.ok(allReaders);
    }

    @PostMapping
    public ResponseEntity registerReader(@RequestBody @Valid RequestReader request ) {

        Reader newReader = new Reader(request);

        var result = this.repository.save(newReader);

        return ResponseEntity.ok( result );
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteReader(@PathVariable("id") Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build() ;
    }


}
