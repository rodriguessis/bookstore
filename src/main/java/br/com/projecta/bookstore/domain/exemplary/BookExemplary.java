package br.com.projecta.bookstore.domain.exemplary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="BOOK_EXEMPLARY")
@Entity(name="BOOK_EXEMPLARY")
public class BookExemplary {

    @Id
    private Integer number;

    private Integer book_id;

    public BookExemplary(Integer number, Integer book_id) {
        this.number = number;
        this.book_id = book_id;
    }

    public BookExemplary() {}

    public Integer getNumber() {
        return number;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

}
