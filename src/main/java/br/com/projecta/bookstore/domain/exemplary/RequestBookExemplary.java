package br.com.projecta.bookstore.domain.exemplary;

import jakarta.validation.constraints.NotNull;

public record RequestBookExemplary(

        @NotNull
        Integer number,

        @NotNull
        Integer book_id

) {
}
