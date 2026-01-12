package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class TurmaDAO {

    public void inserirTurma(String nome, int ano) {
        String sql = "INSERT INTO Turma (nome, ano) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, ano);
            stmt.executeUpdate();
            System.out.println("Turma inserida com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarTurmas() {
        String sql = "SELECT * FROM Turma";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_turma") +
                                   ", Nome: " + rs.getString("nome") +
                                   ", Ano: " + rs.getInt("ano"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarNomeTurma(int id, String novoNome) {
        String sql = "UPDATE Turma SET nome = ? WHERE id_turma = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Nome da turma atualizado!");
            else System.out.println("Turma não encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarTurma(int id) {
        String sql = "DELETE FROM Turma WHERE id_turma = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Turma removida.");
            else System.out.println("Turma não encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
