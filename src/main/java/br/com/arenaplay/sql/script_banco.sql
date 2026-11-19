```sql
CREATE DATABASE IF NOT EXISTS arenaplay;

USE arenaplay;

CREATE TABLE IF NOT EXISTS atletas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    posicao VARCHAR(30),
    idade INT,
    salario DECIMAL(10,2),
    status VARCHAR(20)
);

INSERT INTO atletas (nome, posicao, idade, salario, status)
VALUES
('Carlos Mendes', 'Atacante', 25, 15000.00, 'Ativo'),
('Lucas Ferreira', 'Atacante', 22, 1200000.00, 'Ativo'),
('Rafael Santos', 'Goleiro', 28, 10000.00, 'Ativo'),
('Pedro Oliveira', 'Meio-campo', 24, 11000.00, 'Ativo'),
('Marcos Costa', 'Atacante', 30, 18000.00, 'Inativo');
```