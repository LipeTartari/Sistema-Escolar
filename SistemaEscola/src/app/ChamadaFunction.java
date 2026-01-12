package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChamadaFunction {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.print("Digite o ID do aluno: ");
        int idAluno = leia.nextInt();

        String sql = "SELECT fn_total_matriculas_aluno(?) AS total";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                System.out.println("Total de matrículas do aluno: " + total);
            } else {
                System.out.println("Aluno não encontrado ou sem matrículas.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao chamar a function:");
            e.printStackTrace();
        }
        MenuPrincipal.main(null);
        leia.close();
    }
}
