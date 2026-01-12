package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class ProfessorDAO {

    public void inserirProfessor(String nome, String especialidade) {
        String sql = "INSERT INTO Professor (nome, especialidade) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, especialidade);
            stmt.executeUpdate();
            System.out.println("Professor inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProfessores() {
        String sql = "SELECT * FROM Professor";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_professor") +
                                   ", Nome: " + rs.getString("nome") +
                                   ", Especialidade: " + rs.getString("especialidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarEspecialidade(int id, String novaEspecialidade) {
        String sql = "UPDATE Professor SET especialidade = ? WHERE id_professor = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaEspecialidade);
            stmt.setInt(2, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Especialidade atualizada!");
            else System.out.println("Professor não encontrado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarProfessor(int id) {
        String sql = "DELETE FROM Professor WHERE id_professor = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) System.out.println("Professor removido.");
            else System.out.println("Professor não encontrado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}