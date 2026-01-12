package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MatriculaDAO {

    public void inserirMatricula(int idAluno, int idDisciplina, int idTurma, Date dataMatricula) {
        String sql = "INSERT INTO Matricula (id_aluno, id_disciplina, id_turma, data_matricula) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            stmt.setInt(2, idDisciplina);
            stmt.setInt(3, idTurma);
            stmt.setDate(4, dataMatricula);
            stmt.executeUpdate();
            System.out.println("Matrícula inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarMatriculas() {
        String sql = "SELECT m.id_matricula, a.nome AS aluno, d.nome AS disciplina, t.nome AS turma, m.data_matricula " +
                     "FROM Matricula m " +
                     "JOIN Aluno a ON m.id_aluno = a.id_aluno " +
                     "JOIN Disciplina d ON m.id_disciplina = d.id_disciplina " +
                     "JOIN Turma t ON m.id_turma = t.id_turma";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_matricula") +
                                   ", Aluno: " + rs.getString("aluno") +
                                   ", Disciplina: " + rs.getString("disciplina") +
                                   ", Turma: " + rs.getString("turma") +
                                   ", Data: " + rs.getDate("data_matricula"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarMatricula(int id) {
        String sql = "DELETE FROM Matricula WHERE id_matricula = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Matrícula removida.");
            else System.out.println("Matrícula não encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
