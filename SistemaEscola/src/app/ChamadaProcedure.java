package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ChamadaProcedure {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("ID do aluno: ");
        int idAluno = leia.nextInt();
        System.out.print("ID da disciplina: ");
        int idDisciplina = leia.nextInt();
        System.out.print("ID da turma: ");
        int idTurma = leia.nextInt();
        leia.nextLine();
        System.out.print("Data da matrícula (YYYY-MM-DD): ");
        String data = leia.nextLine();

        String sql = "CALL sp_matricular_aluno(?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idAluno);
            stmt.setInt(2, idDisciplina);
            stmt.setInt(3, idTurma);
            stmt.setDate(4, Date.valueOf(data));

            stmt.execute();
            System.out.println("Aluno matriculado com sucesso pela procedure!");

        } catch (SQLException e) {
            System.out.println("Erro ao executar a procedure:");
            e.printStackTrace();
        }
        MenuPrincipal.main(null);
        leia.close();
    }
}