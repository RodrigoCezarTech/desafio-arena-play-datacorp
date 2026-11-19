# ⚽ ArenaPlay Sports — Sistema de Gerenciamento de Atletas

Sistema de gerenciamento de atletas desenvolvido em **Java**, com integração ao banco de dados **MySQL** e gerenciamento de dependências utilizando **Maven**.

O projeto simula operações de administração de um elenco esportivo, permitindo cadastrar, consultar, atualizar e remover atletas.

---

## 🎯 Objetivo do Projeto

Desenvolver uma aplicação Java integrada a um banco de dados relacional, aplicando conceitos de:

- Programação Orientada a Objetos (POO).
- JDBC para conexão com MySQL.
- Operações CRUD.
- Organização de projetos com Maven.
- Manipulação de dados utilizando SQL.
- Versionamento de código com Git e GitHub.

## 🚀 Funcionalidades

| Funcionalidade | Descrição |
|---|---|
| Cadastrar atleta | Insere novos atletas no banco de dados. |
| Listar elenco | Consulta os atletas cadastrados. |
| Atualizar atleta | Atualiza salário e status do atleta. |
| Dispensar atleta | Remove um atleta do cadastro. |
| Conectar ao MySQL | Realiza a comunicação com o banco de dados. |

## 🛠️ Tecnologias utilizadas

- **Java 17+** — linguagem de programação.
- **Maven** — gerenciamento de dependências e compilação.
- **MySQL 8.0** — banco de dados relacional.
- **JDBC** — integração entre Java e MySQL.
- **MySQL Connector/J** — driver de conexão.
- **Git e GitHub** — versionamento e hospedagem do código.

## 📁 Estrutura do Projeto

```text
desafio-arena-play-datacorp/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/com/arenaplay/
│   │           ├── App.java
│   │           ├── Atleta.java
│   │           ├── AtletaDAO.java
│   │           ├── Conexao.java
│   │           └── Main.java
│   │
│   └── test/
│       └── java/
│           └── br/com/arenaplay/
│               └── AppTest.java
│
├── java/
│   ├── Atleta.java
│   ├── AtletaDAO.java
│   └── Main.java
│
├── sql/
│   ├── criar_tabela.sql
│   └── scout_queries.sql
│
├── pom.xml
├── .gitignore
└── README.md
```

## 💾 Banco de Dados

O projeto utiliza o MySQL com o banco de dados `arenaplay`.

### 1. Criar o banco

```sql
CREATE DATABASE arenaplay;
USE arenaplay;
```

### 2. Criar a tabela de atletas

```sql
CREATE TABLE atletas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    posicao VARCHAR(30),
    idade INT,
    salario DECIMAL(10,2),
    status VARCHAR(20)
);
```

Os scripts SQL complementares estão disponíveis na pasta `sql/`.

## ⚙️ Configuração e execução

### Pré-requisitos

- Java JDK 17 ou superior.
- Apache Maven.
- MySQL Server 8.0 ou superior.
- Git.

### 1. Clonar o repositório

```bash
git clone https://github.com/RodrigoCezarTech/desafio-arena-play-datacorp.git
```

### 2. Acessar a pasta

```bash
cd desafio-arena-play-datacorp
```

### 3. Configurar a senha do MySQL

A aplicação utiliza a variável de ambiente `ARENAPLAY_DB_PASSWORD` para proteger a senha do banco de dados.

No PowerShell do Windows:

```powershell
$env:ARENAPLAY_DB_PASSWORD="SUA_SENHA_DO_MYSQL"
```

Substitua pelo valor configurado no seu MySQL.

### 4. Compilar o projeto

```bash
mvn clean compile
```

### 5. Executar a aplicação

```bash
mvn exec:java "-Dexec.mainClass=br.com.arenaplay.Main"
```

## 📌 Conceitos aplicados

- Encapsulamento.
- Classes e objetos.
- Construtores e métodos.
- Separação de responsabilidades.
- DAO (Data Access Object).
- Conexão com banco de dados.
- Consultas SQL parametrizadas.
- Operações CRUD.

## 🔐 Segurança

A senha do banco de dados não deve ser armazenada diretamente no código-fonte ou publicada no GitHub.

A aplicação utiliza variável de ambiente para obter a credencial de conexão.

## 👨‍💻 Desenvolvedor

**Rodrigo Cezar**

Projeto desenvolvido para fins de aprendizado e demonstração prática de conhecimentos em desenvolvimento Java, banco de dados MySQL e integração de sistemas.

---

## 🎓 Contexto Educacional

Este projeto foi desenvolvido como atividade prática durante a formação oferecida pela **Generation Brasil**.

O desenvolvimento teve como referência o **DataCorp Simulator**, ferramenta didática desenvolvida e apresentada pelo professor durante o curso.

A partir dessa referência, foi desenvolvida uma implementação própria do **ArenaPlay Sports**, utilizando Java, Maven e MySQL, com foco na aplicação prática dos conceitos de programação, persistência de dados e operações CRUD.

**Referência didática:** [DataCorp Simulator](https://script.google.com/macros/s/AKfycbxV7Q-OJLobvmJL8G_vVkk5t5Ig58EwuoaT5ngNPf7le_6kAKgf0-JyrRCRHF8U6sAX_A/exec).

---

⭐ Se este projeto foi útil ou interessante, considere deixar uma estrela no repositório!
