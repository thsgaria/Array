DROP DATABASE IF EXISTS locadora; -- Apagar o bd caso existir
CREATE DATABASE locadora; -- Criar o bd
USE locadora; -- Apontar para o bd
CREATE TABLE filmes (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100),
    PRIMARY KEY (id)
);

