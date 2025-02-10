CREATE TABLE IF NOT EXISTS READER (
    id SERIAL       PRIMARY KEY,
    name            varchar(80)     NOT NULL,
    cpf             varchar(11)     not null unique,
    address         varchar(100)    NOT NULL,
    neighborhood    varchar(80)     NOT NULL,
    zipcode         varchar(8),
    city            varchar(40),
    state           varchar(2),
    telephone       varchar(8),
    cellphone       varchar(18),
    email           varchar(100),
    birth           DATE,
    registration    DATE
);