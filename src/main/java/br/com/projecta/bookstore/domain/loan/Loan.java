package br.com.projecta.bookstore.domain.loan;

import jakarta.persistence.*;

import java.util.Calendar;

@Table(name="LOAN")
@Entity(name="LOAN")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer numberBookExemplary;

    private Integer idReader;

    private Calendar dateLoan;

    private Calendar dateForecast;

    private Calendar dateReturn;

    private Boolean active;

    public Loan() {}

    public Loan( RequestLoan data ) {
        this.numberBookExemplary = data.exemplary();
        this.idReader = data.reader();
        this.dateLoan = Calendar.getInstance();
        this.dateForecast = Calendar.getInstance();
        this.dateForecast.add(Calendar.DATE, 14);
        this.active = Boolean.TRUE;
    }

    public Loan(Integer id, Integer numberBookExemplary, Integer idReader, Calendar dateLoan, Calendar dateForecast, Calendar dateReturn, Boolean active) {
        this.id = id;
        this.numberBookExemplary = numberBookExemplary;
        this.idReader = idReader;
        this.dateLoan = dateLoan;
        this.dateForecast = dateForecast;
        this.dateReturn = dateReturn;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumberBookExemplary() {
        return numberBookExemplary;
    }

    public Integer getIdReader() {
        return idReader;
    }

    public Calendar getDateLoan() {
        return dateLoan;
    }

    public Calendar getDateForecast() {
        return dateForecast;
    }

    public Calendar getDateReturn() {
        return dateReturn;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumberBookExemplary(Integer numberBookExemplary) {
        this.numberBookExemplary = numberBookExemplary;
    }

    public void setIdReader(Integer idReader) {
        this.idReader = idReader;
    }

    public void setDateLoan(Calendar dateLoan) {
        this.dateLoan = dateLoan;
    }

    public void setDateForecast(Calendar dateForecast) {
        this.dateForecast = dateForecast;
    }

    public void setDateReturn(Calendar dateReturn) {
        this.dateReturn = dateReturn;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}