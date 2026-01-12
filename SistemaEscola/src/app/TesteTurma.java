package app;

import java.util.Scanner;

public class TesteTurma {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        TurmaDAO dao = new TurmaDAO();
        int opcao;

        do {
            System.out.println("\n--- MENU TURMA ---");
            System.out.println("1 - Inserir Turma");
            System.out.println("2 - Listar Turmas");
            System.out.println("3 - Atualizar Nome da Turma");
            System.out.println("4 - Remover Turma");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da turma: ");
                    String nome = leia.nextLine();
                    System.out.print("Ano: ");
                    int ano = leia.nextInt();
                    dao.inserirTurma(nome, ano);
                    break;
                case 2:
                    dao.listarTurmas();
                    break;
                case 3:
                    System.out.print("ID da turma: ");
                    int idAtt = leia.nextInt();
                    leia.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = leia.nextLine();
                    dao.atualizarNomeTurma(idAtt, novoNome);
                    break;
                case 4:
                    System.out.print("ID da turma a remover: ");
                    int idDel = leia.nextInt();
                    dao.deletarTurma(idDel);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
        MenuPrincipal.main(null);
        leia.close();
    }
}
