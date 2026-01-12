package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DisciplinaDAO {

    public void inserirDisciplina(String nome, int cargaHoraria, int idTurma) {
        String sql = "INSERT INTO Disciplina (nome, carga_horaria, id_turma) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, cargaHoraria);
            stmt.setInt(3, idTurma);
            stmt.executeUpdate();
            System.out.println("Disciplina inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarDisciplinas() {
        String sql = "SELECT d.id_disciplina, d.nome, d.carga_horaria, t.nome AS turma " +
                     "FROM Disciplina d JOIN Turma t ON d.id_turma = t.id_turma";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_disciplina") +
                                   ", Nome: " + rs.getString("nome") +
                                   ", Carga: " + rs.getInt("carga_horaria") + "h" +
                                   ", Turma: " + rs.getString("turma"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCargaHoraria(int id, int novaCarga) {
        String sql = "UPDATE Disciplina SET carga_horaria = ? WHERE id_disciplina = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novaCarga);
            stmt.setInt(2, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Carga horária atualizada!");
            else System.out.println("Disciplina não encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarDisciplina(int id) {
        String sql = "DELETE FROM Disciplina WHERE id_disciplina = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Disciplina removida.");
            else System.out.println("Disciplina não encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}