```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtletaDAO {

    private Connection conn;

    // Construtor
    public AtletaDAO(Connection conn) {
        this.conn = conn;
    }

    // MISSÃO 3 — CREATE: cadastrar atleta
    public void cadastrarAtleta(Atleta atleta) throws SQLException {

        String sql = "INSERT INTO atletas "
                   + "(nome, posicao, idade, salario, status) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, atleta.getNome());
            pstmt.setString(2, atleta.getPosicao());
            pstmt.setInt(3, atleta.getIdade());
            pstmt.setDouble(4, atleta.getSalario());
            pstmt.setString(5, atleta.getStatus());

            pstmt.executeUpdate();
        }
    }

    // MISSÃO 5 — READ: listar elenco
    public List<Atleta> listarElenco() throws SQLException {

        List<Atleta> elenco = new ArrayList<>();

        String sql = "SELECT * FROM atletas";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Atleta a = new Atleta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("posicao"),
                    rs.getInt("idade"),
                    rs.getDouble("salario"),
                    rs.getString("status")
                );

                elenco.add(a);
            }
        }

        return elenco;
    }

    // MISSÃO 6 — UPDATE: atualizar salário e status
    public void atualizarSalarioEStatus(
            int id, double novoSalario, String novoStatus)
            throws SQLException {

        String sql = "UPDATE atletas SET salario = ?, status = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, novoSalario);
            pstmt.setString(2, novoStatus);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();
        }
    }

    // MISSÃO 7 — DELETE: dispensar atleta
    public boolean dispensarAtleta(int id) throws SQLException {

        String sql = "DELETE FROM atletas WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhas = pstmt.executeUpdate();

            return linhas > 0;
        }
    }
}
```
