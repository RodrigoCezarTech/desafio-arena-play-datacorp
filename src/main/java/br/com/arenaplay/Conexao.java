package br.com.arenaplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
        "jdbc:mysql://localhost:3306/arenaplay?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USUARIO = "root";

    // Senha obtida de uma variável de ambiente
    private static final String SENHA =
        System.getenv("ARENAPLAY_DB_PASSWORD");

    public static Connection conectar() throws SQLException {

        if (SENHA == null || SENHA.isBlank()) {
            throw new SQLException(
                "Variável ARENAPLAY_DB_PASSWORD não configurada."
            );
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void main(String[] args) {

        try (Connection conexao = conectar()) {

            System.out.println("================================");
            System.out.println(" ARENAPLAY SPORTS");
            System.out.println(" Conexao com MySQL estabelecida!");
            System.out.println("================================");

        } catch (SQLException e) {

            System.out.println("Erro ao conectar ao MySQL:");
            System.out.println(e.getMessage());
        }
    }
}