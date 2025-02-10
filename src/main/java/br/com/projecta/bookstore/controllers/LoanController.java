package br.com.projecta.bookstore.controllers;

import br.com.projecta.bookstore.domain.loan.Loan;
import br.com.projecta.bookstore.domain.loan.LoanRepository;
import br.com.projecta.bookstore.domain.loan.RequestLoan;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("loan")
public class LoanController {

    @Autowired
    private LoanRepository repository;

    @PostMapping
    public ResponseEntity registerLoan(@RequestBody @Valid RequestLoan requestLoan ) {

        Loan newLoan = new Loan(requestLoan);

        this.repository.save(newLoan);

        var allLoan = this.repository.findAll();

        return ResponseEntity.ok(allLoan);

    }

    @GetMapping
    public ResponseEntity listAll() {

        var allLoan = this.repository.findAll();

        return ResponseEntity.ok(allLoan);
    }

}
