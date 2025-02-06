package br.com.projecta.bookstore.infra.security;

import br.com.projecta.bookstore.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String key_secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key_secret);
            String token = JWT.create()
                    .withIssuer("bookstore")
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirationDateIn(2))
                    .sign(algorithm);
            return token;

        }
        catch (JWTCreationException exception ) {
            throw new RuntimeException("Erro ao gerar o token", exception);
        }

    }

    public String validateToken( String token ) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(key_secret);
            return JWT.require(algorithm)
                    .withIssuer("bookstore")
                    .build()
                    .verify(token)
                    .getSubject();
        }
        catch (JWTVerificationException exception ) {
            return "";
        }
    }

    private Instant expirationDateIn(int hours) {
        return LocalDateTime.now().plusHours(hours).toInstant(ZoneOffset.of("-03:00"));
    }

}
