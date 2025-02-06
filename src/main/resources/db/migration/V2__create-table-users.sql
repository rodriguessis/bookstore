CREATE TABLE users (
    email       TEXT PRIMARY KEY UNIQUE NOT NULL,
    password    TEXT NOT NULL,
    name        TEXT NOT NULL,
    role        TEXT NOT NULL
);