
package br.com.arenaplay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    private Connection conexao;

    public AtletaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // CADASTRAR ATLETA
    public void cadastrarAtleta(Atleta atleta) throws SQLException {

        String sql = "INSERT INTO atletas "
                + "(nome, posicao, idade, salario, status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, atleta.getNome());
            stmt.setString(2, atleta.getPosicao());
            stmt.setInt(3, atleta.getIdade());
            stmt.setDouble(4, atleta.getSalario());
            stmt.setString(5, atleta.getStatus());

            stmt.executeUpdate();

            System.out.println("Atleta cadastrado com sucesso!");
        }
    }

    // LISTAR ELENCO
    public List<Atleta> listarElenco() throws SQLException {

        List<Atleta> atletas = new ArrayList<>();

        String sql = "SELECT * FROM atletas ORDER BY id";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Atleta atleta = new Atleta(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("posicao"),
                        rs.getInt("idade"),
                        rs.getDouble("salario"),
                        rs.getString("status")
                );

                atletas.add(atleta);
            }
        }

        return atletas;
    }

    // ATUALIZAR SALÁRIO E STATUS
    public void atualizarSalarioEStatus(
            int id, double novoSalario, String novoStatus)
            throws SQLException {

        String sql = "UPDATE atletas "
                + "SET salario = ?, status = ? "
                + "WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDouble(1, novoSalario);
            stmt.setString(2, novoStatus);
            stmt.setInt(3, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Atleta atualizado com sucesso!");
            } else {
                System.out.println("Atleta não encontrado.");
            }
        }
    }

    // EXCLUIR ATLETA
    public void dispensarAtleta(int id) throws SQLException {

        String sql = "DELETE FROM atletas WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                System.out.println("Atleta excluído com sucesso!");
            } else {
                System.out.println("Atleta não encontrado.");
            }
        }
    }
}
