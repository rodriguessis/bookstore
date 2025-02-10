package br.com.projecta.bookstore.domain.reader;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}