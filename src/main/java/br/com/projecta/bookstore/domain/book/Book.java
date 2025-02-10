package br.com.projecta.bookstore.domain.book;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Table(name="BOOK")
@Entity(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String summary;

    private String isbn;

    public Book() {}

    public Book(Integer id, String title, String summary, String isbn) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.isbn = isbn;
    }

    public Book( RequestBook data ) {
        this.title = data.title();
        this.summary = data.summary();
        this.isbn = data.isbn();
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAll(@Valid RequestBook data) {
        this.title      = data.title();
        this.summary    = data.summary();
        this.isbn       = data.isbn();
    }
}