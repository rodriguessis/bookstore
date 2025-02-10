DROP TABLE BOOK;

CREATE TABLE BOOK (
    id      SERIAL  PRIMARY KEY,
    title   TEXT    NOT NULL,
    summary TEXT,
    isbn    VARCHAR(20) UNIQUE
);