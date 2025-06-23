
package dao;

import java.sql.*;
import conexao.Conexao;
import model.Projeto;

public class ProjetoDAO {

    public void inserir(Projeto p) {
        try (Connection conn = Conexao.conectar()) {
            // Verifica se o funcionário existe
            String verificaFuncionario = "SELECT * FROM funcionario WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(verificaFuncionario);
            checkStmt.setInt(1, p.getIdFuncionario());
            ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Erro: Funcionário com ID " + p.getIdFuncionario() + " não existe.");
                return;
            }

            // Inserir projeto
            String sql = "INSERT INTO projeto (nome, descricao, id_funcionario) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getIdFuncionario());
            stmt.executeUpdate();
            System.out.println("Projeto inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir projeto: " + e.getMessage());
        }
    }
}
