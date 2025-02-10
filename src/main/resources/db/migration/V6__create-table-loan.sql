CREATE TABLE LOAN (
    id            SERIAL    PRIMARY KEY,
    number_book_exemplary   INTEGER not null,
    id_reader               int not null,
    date_loan               date,
    date_forecast           date,
    date_return             date,
    active                  BOOLEAN,
    constraint FK_LOAN_BOOK_EXEMPLARY
        FOREIGN KEY (number_book_exemplary)
            REFERENCES BOOK_EXEMPLARY(number) ON DELETE CASCADE,
    constraint FK_LOAN_READER
        FOREIGN KEY (id_reader)
            REFERENCES READER(id) ON DELETE CASCADE
);