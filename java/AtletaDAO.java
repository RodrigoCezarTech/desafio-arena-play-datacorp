import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtletaDAO {

    // Conexão com o banco de dados
    private Connection conn;

    // Construtor
    public AtletaDAO(Connection conn) {
        this.conn = conn;
    }

    // Cadastrar atleta no banco de dados
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
}
