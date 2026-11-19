-- ==========================================
-- ARENAPLAY SPORTS
-- MISSÃO 1 — Banco de Dados do Clube
-- ==========================================

-- Criação da tabela de atletas

CREATE TABLE atletas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    posicao VARCHAR(30),
    idade INT,
    salario DECIMAL(10,2),
    status VARCHAR(20)
);
