package br.com.projecta.bookstore.domain.loan;

import java.sql.Date;
import java.util.Calendar;

public record ResponseLoan(
        Integer idLoan,
        Integer idReader,
        String  name,
        Integer number,
        String  title,
        Date dateLoan,
        Date dateForecast
) {
}