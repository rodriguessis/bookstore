package br.com.projecta.bookstore.domain.reader;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Calendar;

public record RequestReader(
        @NotBlank
        String name,
        // @CPF
        String cpf,
        String address,
        String neighborhood,
        String zipcode,
        String city,
        String state,
        String telephone,
        String cellphone,
        @Email
        String email,
        Calendar birth
) {
}
