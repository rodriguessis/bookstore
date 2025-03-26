package br.com.projecta.bookstore.domain.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserInitializer(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {

        String initialUser = "admin@gmail.com";
        if ( this.repository.findByEmail(initialUser) == null )
        {
            String encryptedPassword = new BCryptPasswordEncoder().encode("admin");

            User newUser = new User( initialUser,  encryptedPassword, "Usuário Administrador",  UserRole.ADMIN );
            this.repository.save(newUser);
        }
    }
}
