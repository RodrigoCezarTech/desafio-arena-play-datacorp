```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Configurações do banco de dados
    private static final String URL =
            "jdbc:mysql://localhost:3306/arenaplay";

    private static final String USUARIO = "root";

    private static final String SENHA = "SUA_SENHA";

    public static void main(String[] args) {

        try (
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            Scanner scanner = new Scanner(System.in)
        ) {

            AtletaDAO dao = new AtletaDAO(conn);

            int opcao;

            do {
                System.out.println("\n===== ARENAPLAY SPORTS =====");
                System.out.println("1 - Cadastrar atleta");
                System.out.println("2 - Listar elenco");
                System.out.println("3 - Atualizar atleta");
                System.out.println("4 - Dispensar atleta");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Posição: ");
                        String posicao = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        System.out.print("Salário: ");
                        double salario = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Status: ");
                        String status = scanner.nextLine();

                        Atleta atleta = new Atleta(
                                0, nome, posicao, idade, salario, status
                        );

                        dao.cadastrarAtleta(atleta);

                        System.out.println("Atleta cadastrado!");
                        break;

                    case 2:
                        List<Atleta> elenco = dao.listarElenco();

                        System.out.println("\n===== ELENCO =====");

                        for (Atleta a : elenco) {
                            System.out.println(
                                "ID: " + a.getId()
                                + " | Nome: " + a.getNome()
                                + " | Posição: " + a.getPosicao()
                                + " | Idade: " + a.getIdade()
                                + " | Salário: " + a.getSalario()
                                + " | Status: " + a.getStatus()
                            );
                        }
                        break;

                    case 3:
                        System.out.print("ID do atleta: ");
                        int idAtualizar = scanner.nextInt();

                        System.out.print("Novo salário: ");
                        double novoSalario = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Novo status: ");
                        String novoStatus = scanner.nextLine();

                        dao.atualizarSalarioEStatus(
                                idAtualizar, novoSalario, novoStatus
                        );

                        System.out.println("Atleta atualizado!");
                        break;

                    case 4:
                        System.out.print("ID do atleta: ");
                        int idExcluir = scanner.nextInt();

                        boolean excluido = dao.dispensarAtleta(idExcluir);

                        if (excluido) {
                            System.out.println("Atleta dispensado!");
                        } else {
                            System.out.println("Atleta não encontrado.");
                        }
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } while (opcao != 0);

        } catch (SQLException e) {
            System.out.println("Erro no banco de dados: " + e.getMessage());
        }
    }
}
```
