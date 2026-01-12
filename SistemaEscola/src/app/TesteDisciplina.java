package app;

import java.util.Scanner;

public class TesteDisciplina {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        DisciplinaDAO dao = new DisciplinaDAO();
        int opcao;

        do {
            System.out.println("\n--- MENU DISCIPLINA ---");
            System.out.println("1 - Inserir Disciplina");
            System.out.println("2 - Listar Disciplinas");
            System.out.println("3 - Atualizar Carga Horária");
            System.out.println("4 - Remover Disciplina");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da disciplina: ");
                    String nome = leia.nextLine();
                    System.out.print("Carga horária (em horas): ");
                    int carga = leia.nextInt();
                    System.out.print("ID da turma: ");
                    int idTurma = leia.nextInt();
                    dao.inserirDisciplina(nome, carga, idTurma);
                    break;
                case 2:
                    dao.listarDisciplinas();
                    break;
                case 3:
                    System.out.print("ID da disciplina: ");
                    int id = leia.nextInt();
                    System.out.print("Nova carga horária: ");
                    int novaCarga = leia.nextInt();
                    dao.atualizarCargaHoraria(id, novaCarga);
                    break;
                case 4:
                    System.out.print("ID da disciplina a remover: ");
                    int idDel = leia.nextInt();
                    dao.deletarDisciplina(idDel);
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