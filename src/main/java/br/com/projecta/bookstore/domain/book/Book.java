package br.com.projecta.bookstore.domain.book;

import jakarta.persistence.*;

@Table(name="BOOK")
@Entity(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    public Book( String name ) {
        this.name = name;
    }

    public Book() {}

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

}