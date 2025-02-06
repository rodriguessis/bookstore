package br.com.projecta.bookstore.domain.user;

public record RegisterDTO(
         String email,
         String password,
         String name,
         UserRole role

) {
}
