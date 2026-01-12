package app;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Professores");
            System.out.println("3 - Gerenciar Disciplinas");
            System.out.println("4 - Gerenciar Turmas");
            System.out.println("5 - Gerenciar Matrículas");
            System.out.println("6 - Consultar VIEW aluno + disciplina");
            System.out.println("7 - Consultar FUNCTION total de matrículas");
            System.out.println("8 - Executar PROCEDURE de matrícula");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    TesteAluno.main(null);
                    break;
                case 2:
                    TesteProfessor.main(null);
                    break;
                case 3:
                    TesteDisciplina.main(null);
                    break;
                case 4:
                    TesteTurma.main(null);
                    break;
                case 5:
                    TesteMatricula.main(null);
                    break;
                case 6:
                    ConsultaView.main(null);
                    break;
                case 7:
                    ChamadaFunction.main(null);
                    break;
                case 8:
                    ChamadaProcedure.main(null);
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        leia.close();
    }
}