package app;

import java.sql.Date;
import java.util.Scanner;

public class TesteAluno {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        AlunoDAO dao = new AlunoDAO();
        int opcao;

        do {
            System.out.println("\n--- MENU ALUNO ---");
            System.out.println("1 - Inserir Aluno");
            System.out.println("2 - Listar Alunos");
            System.out.println("3 - Atualizar Email");
            System.out.println("4 - Remover Aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = leia.nextLine();
                    System.out.print("Email: ");
                    String email = leia.nextLine();
                    System.out.print("Data de nascimento (YYYY-MM-DD): ");
                    String data = leia.nextLine();
                    dao.inserirAluno(nome, email, Date.valueOf(data));
                    break;
                case 2:
                    dao.listarAlunos();
                    break;
                case 3:
                    System.out.print("ID do aluno: ");
                    int idAtt = leia.nextInt();
                    leia.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = leia.nextLine();
                    dao.atualizarAluno(idAtt, novoEmail);
                    break;
                case 4:
                    System.out.print("ID do aluno a remover: ");
                    int idDel = leia.nextInt();
                    dao.deletarAluno(idDel);
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
