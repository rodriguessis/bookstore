CREATE TABLE LOAN (
    id            SERIAL    PRIMARY KEY,
    number_book_exemplary   INTEGER not null,
    id_reader               int not null,
    date_loan               date,
    date_forecast           date,
    date_return             date,

    FOREIGN KEY (number_book_exemplary) REFERENCES BOOK_EXEMPLARY(number) ON DELETE CASCADE
    FOREIGN KEY (id_reader) REFERENCES READER(id) ON DELETE CASCADE
);