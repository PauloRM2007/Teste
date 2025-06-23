
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexao.Conexao;
import model.Pessoa;

public class PessoaDAO {

    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.executeUpdate();
            System.out.println("Pessoa inserida com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";
        try (Connection conn = Conexao.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                pessoas.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
        return pessoas;
    }

    public Pessoa buscarPorId(int id) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                return p;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar pessoa: " + e.getMessage());
        }
        return null;
    }

    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
            System.out.println("Pessoa atualizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pessoa excluída com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pessoa: " + e.getMessage());
        }
    }
}
