package br.com.projecta.bookstore.domain.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Query(value =
            "SELECT l.id AS idLoan, l.id_reader AS idReader, r.name, " +
                  " e.number, b.title, l.date_loan as dateLoan, l.date_forecast as dateForecast " +
              "FROM LOAN l LEFT JOIN READER r ON l.id_reader = r.id " +
              "LEFT JOIN BOOK_EXEMPLARY e ON l.number_book_exemplary = e.number " +
              "LEFT JOIN BOOK b on e.book_id = b.id " +
             "WHERE l.date_return is null " +
               "AND l.active = '1' ",
            nativeQuery = true)
    public List<ResponseLoan> loansOpens();

}
