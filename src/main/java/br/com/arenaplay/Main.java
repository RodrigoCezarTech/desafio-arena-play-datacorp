
package br.com.arenaplay;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Converte valores monetários para double
    public static double converterSalario(String valor) {

        valor = valor.trim();

        if (valor.contains(",")) {
            valor = valor.replace(".", "").replace(",", ".");
        }

        return Double.parseDouble(valor);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (Connection conexao = Conexao.conectar()) {

            AtletaDAO dao = new AtletaDAO(conexao);

            int opcao;

            do {

                System.out.println("\n==================================");
                System.out.println("       ARENAPLAY SPORTS");
                System.out.println("==================================");
                System.out.println("1 - Cadastrar atleta");
                System.out.println("2 - Listar elenco");
                System.out.println("3 - Atualizar salário e status");
                System.out.println("4 - Dispensar atleta");
                System.out.println("0 - Sair");
                System.out.println("==================================");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1: {

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Posição: ");
                        String posicao = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Salário (exemplo: 1200000,00): ");
                        String salarioTexto = scanner.nextLine();

                        double salario = converterSalario(salarioTexto);

                        System.out.print("Status (Ativo/Inativo): ");
                        String status = scanner.nextLine();

                        Atleta atleta = new Atleta(
                                nome, posicao, idade, salario, status);

                        dao.cadastrarAtleta(atleta);

                        break;
                    }

                    case 2: {

                        List<Atleta> atletas = dao.listarElenco();

                        System.out.println("\n========== ELENCO ==========");

                        for (Atleta a : atletas) {

                            System.out.println(
                                    "ID: " + a.getId()
                                    + " | Nome: " + a.getNome()
                                    + " | Posição: " + a.getPosicao()
                                    + " | Idade: " + a.getIdade()
                                    + " | Salário: R$ " + String.format(
                                            java.util.Locale.forLanguageTag("pt-BR"),
                                            "%,.2f", a.getSalario())
                                    + " | Status: " + a.getStatus()
                            );
                        }

                        if (atletas.isEmpty()) {
                            System.out.println("Nenhum atleta cadastrado.");
                        }

                        break;
                    }

                    case 3: {

                        System.out.print("ID do atleta: ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Novo salário: ");
                        String novoSalarioTexto = scanner.nextLine();

                        double novoSalario = converterSalario(novoSalarioTexto);

                        System.out.print("Novo status: ");
                        String novoStatus = scanner.nextLine();

                        dao.atualizarSalarioEStatus(
                                idAtualizar, novoSalario, novoStatus);

                        break;
                    }

                    case 4: {

                        System.out.print("ID do atleta para dispensar: ");
                        int idExcluir = scanner.nextInt();
                        scanner.nextLine();

                        dao.dispensarAtleta(idExcluir);

                        break;
                    }

                    case 0:

                        System.out.println("Encerrando ArenaPlay Sports...");
                        break;

                    default:

                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);

        } catch (SQLException e) {

            System.out.println("Erro no banco de dados: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Valor numérico inválido. Tente novamente.");

        }

        scanner.close();
    }
}