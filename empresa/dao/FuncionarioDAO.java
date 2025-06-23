
package dao;

import java.sql.*;
import conexao.Conexao;
import model.Funcionario;

public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        try (Connection conn = Conexao.conectar()) {
            // Verifica se Pessoa existe
            String verificaPessoa = "SELECT * FROM pessoa WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(verificaPessoa);
            checkStmt.setInt(1, f.getId());
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Erro: Pessoa com ID " + f.getId() + " não existe.");
                return;
            }

            // Insere funcionário
            String sql = "INSERT INTO funcionario (id, matricula, departamento) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, f.getId());
            stmt.setString(2, f.getMatricula());
            stmt.setString(3, f.getDepartamento());
            stmt.executeUpdate();
            System.out.println("Funcionário inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir funcionário: " + e.getMessage());
        }
    }

    public boolean estaVinculadoAProjeto(int idFuncionario) {
        String sql = "SELECT * FROM projeto WHERE id_funcionario = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public void deletar(int id) {
        if (estaVinculadoAProjeto(id)) {
            System.out.println("Erro: Não é possível excluir um funcionário vinculado a projetos.");
            return;
        }
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Funcionário excluído com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }
}
