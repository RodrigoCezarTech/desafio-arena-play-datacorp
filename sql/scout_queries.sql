```sql
-- ==========================================
-- ARENAPLAY SPORTS
-- MISSÃO 4 — Radar de Scout (SQL Read)
-- ==========================================

-- Selecionar atacantes ativos
-- Exibir: id, nome, posição e salário
-- Ordenar pelo maior salário

SELECT
    id,
    nome,
    posicao,
    salario
FROM atletas
WHERE posicao = 'Atacante'
  AND status = 'Ativo'
ORDER BY salario DESC;
```
