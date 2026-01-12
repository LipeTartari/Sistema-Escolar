package app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class AlunoDAO {

 public void inserirAluno(String nome, String email, Date dataNascimento) {
     String sql = "INSERT INTO Aluno (nome, email, data_nascimento) VALUES (?, ?, ?)";
     try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setString(1, nome);
         stmt.setString(2, email);
         stmt.setDate(3, dataNascimento);
         stmt.executeUpdate();
         System.out.println("Aluno inserido com sucesso!");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void listarAlunos() {
     String sql = "SELECT * FROM Aluno";
     try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
         while (rs.next()) {
             System.out.println("ID: " + rs.getInt("id_aluno") +
                                ", Nome: " + rs.getString("nome") +
                                ", Email: " + rs.getString("email") +
                                ", Nascimento: " + rs.getDate("data_nascimento"));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void atualizarAluno(int id, String novoEmail) {
     String sql = "UPDATE Aluno SET email = ? WHERE id_aluno = ?";
     try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setString(1, novoEmail);
         stmt.setInt(2, id);
         int linhas = stmt.executeUpdate();
         if (linhas > 0) System.out.println("Email atualizado!");
         else System.out.println("Aluno não encontrado.");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void deletarAluno(int id) {
     String sql = "DELETE FROM Aluno WHERE id_aluno = ?";
     try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
         stmt.setInt(1, id);
         int linhas = stmt.executeUpdate();
         if (linhas > 0) System.out.println("Aluno removido.");
         else System.out.println("Aluno não encontrado.");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}