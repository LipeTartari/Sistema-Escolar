package app;

import java.sql.Date;
import java.util.Scanner;

public class TesteMatricula {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        MatriculaDAO dao = new MatriculaDAO();
        int opcao;

        do {
            System.out.println("\n--- MENU MATRÍCULA ---");
            System.out.println("1 - Inserir Matrícula");
            System.out.println("2 - Listar Matrículas");
            System.out.println("3 - Remover Matrícula");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("ID do aluno: ");
                    int idAluno = leia.nextInt();
                    System.out.print("ID da disciplina: ");
                    int idDisciplina = leia.nextInt();
                    System.out.print("ID da turma: ");
                    int idTurma = leia.nextInt();
                    leia.nextLine();
                    System.out.print("Data da matrícula (YYYY-MM-DD): ");
                    String data = leia.nextLine();
                    dao.inserirMatricula(idAluno, idDisciplina, idTurma, Date.valueOf(data));
                    break;
                case 2:
                    dao.listarMatriculas();
                    break;
                case 3:
                    System.out.print("ID da matrícula a remover: ");
                    int idMat = leia.nextInt();
                    dao.deletarMatricula(idMat);
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
