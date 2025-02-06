package br.com.projecta.bookstore.domain.book;

import jakarta.validation.constraints.NotBlank;

public record RequestBook(@NotBlank String name ) {
}
