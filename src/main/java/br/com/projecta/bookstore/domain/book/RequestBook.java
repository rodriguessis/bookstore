package br.com.projecta.bookstore.domain.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestBook(

        @NotBlank
        @NotNull
        String title,

        @NotBlank
        @NotNull
        String summary,

        @NotBlank
        @NotNull
        String isbn


        ) { }
