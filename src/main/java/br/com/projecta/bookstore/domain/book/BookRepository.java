package br.com.projecta.bookstore.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {

    //@Override
    Optional<Book> findByName(String name);

}
