CREATE DATABASE bankdb;
USE bankdb;
CREATE TABLE accounts (
    accountNumber BIGINT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);
CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accountNumber BIGINT,
    type VARCHAR(20),
    amount DOUBLE,
    transactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO users VALUES ('admin','1234');
SHOW TABLES;