package app;

import java.util.Scanner;

public class TesteProfessor {
 public static void main(String[] args) {
     Scanner leia = new Scanner(System.in);
     ProfessorDAO dao = new ProfessorDAO();
     int opcao;

     do {
         System.out.println("\n--- MENU PROFESSOR ---");
         System.out.println("1 - Inserir Professor");
         System.out.println("2 - Listar Professores");
         System.out.println("3 - Atualizar Especialidade");
         System.out.println("4 - Remover Professor");
         System.out.println("0 - Sair");
         System.out.print("Escolha: ");
         opcao = leia.nextInt();
         leia.nextLine();

         switch (opcao) {
             case 1:
                 System.out.print("Nome: ");
                 String nome = leia.nextLine();
                 System.out.print("Especialidade: ");
                 String esp = leia.nextLine();
                 dao.inserirProfessor(nome, esp);
                 break;
             case 2:
                 dao.listarProfessores();
                 break;
             case 3:
                 System.out.print("ID do professor: ");
                 int idAtt = leia.nextInt();
                 leia.nextLine();
                 System.out.print("Nova especialidade: ");
                 String novaEsp = leia.nextLine();
                 dao.atualizarEspecialidade(idAtt, novaEsp);
                 break;
             case 4:
                 System.out.print("ID do professor a remover: ");
                 int idDel = leia.nextInt();
                 dao.deletarProfessor(idDel);
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
