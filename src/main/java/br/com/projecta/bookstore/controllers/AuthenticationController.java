package br.com.projecta.bookstore.controllers;

import br.com.projecta.bookstore.domain.user.*;
import br.com.projecta.bookstore.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authentication ) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(authentication.email(), authentication.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok( new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register( @RequestBody @Valid RegisterDTO  registerUser ) {

        if ( this.repository.findByEmail(registerUser.email()) != null ) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerUser.password());

        User newUser = new User(registerUser.email(),  encryptedPassword, registerUser.name(), registerUser.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();

    }



}
