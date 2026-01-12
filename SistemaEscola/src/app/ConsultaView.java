package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaView {
    public static void main(String[] args) {
        String sql = "SELECT * FROM vw_aluno_disciplinas";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("--- Alunos e Disciplinas ---");
            while (rs.next()) {
                String aluno = rs.getString("nome_aluno");
                String disciplina = rs.getString("nome_disciplina");
                String data = rs.getDate("data_matricula").toString();

                System.out.println("Aluno: " + aluno +
                                   ", Disciplina: " + disciplina +
                                   ", Matrícula: " + data);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar a VIEW:");
            e.printStackTrace();
        }
        MenuPrincipal.main(null);
    }
}
