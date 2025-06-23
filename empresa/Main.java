
package app;

import dao.*;
import model.*;

public class Main {
    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        ProjetoDAO projetoDAO = new ProjetoDAO();

        // Exemplo de uso básico
        Pessoa p = new Pessoa("João da Silva", "joao@email.com");
        pessoaDAO.inserir(p);

        // Suponha que João recebeu id 1 no banco
        Funcionario f = new Funcionario("João da Silva", "joao@email.com", "F001", "TI");
        f.setId(1);
        funcionarioDAO.inserir(f);

        Projeto proj = new Projeto("Sistema Interno", "Projeto para automatizar processos internos", 1);
        projetoDAO.inserir(proj);
    }
}
