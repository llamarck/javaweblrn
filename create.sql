create database base;
use base;
create table contatos (
id BIGINT NOT NULL AUTO_INCREMENT,
nome VARCHAR(255),
email VARCHAR(255),
endereco VARCHAR(255),
dataNascimento DATE,
primary key (id)
);