package br.com.projecta.bookstore.domain.book;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class BookRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("deve retornar um sucesso ao consultar o Book")
    void findBookByNameSucess() {

        String nameOfBook = "The Name Of Book";
        RequestBook requestBook = new RequestBook( nameOfBook, "este é um livro muito bom", "123445667" );

        Book bookCreated = createOneBook( requestBook );

        Optional<Book> foundeBook = this.bookRepository.findByTitle( nameOfBook );

        assertThat(foundeBook.isPresent()).isTrue();

    }

    @Test
    @DisplayName("não deve retornar um sucesso ao consultar um book nao existente")
    void notFindBookByName() {

        String nameOfBook = "The Name Of Book";

        Optional<Book> foundeBook = this.bookRepository.findByTitle( nameOfBook );

        assertThat(foundeBook.isEmpty() ).isTrue();

    }


    private Book createOneBook( RequestBook requestBook  ) {

        Book newBook = new Book( requestBook );
        this.entityManager.persist(newBook);
        return newBook;

    }


}