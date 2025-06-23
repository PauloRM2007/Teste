
===========================================
  PROJETO JAVA + JDBC + MYSQL - EMPRESA
===========================================

▶ OBJETIVO:
Aplicação em Java com acesso a banco de dados MySQL via JDBC.
Gerencia Pessoas, Funcionários e Projetos com validações e operações CRUD completas.

───────────────────────────────────────────
📦 ESTRUTURA DE PASTAS (dentro de /src):

- conexao/Conexao.java          → Conexão com MySQL
- model/Pessoa.java            → Classe base
- model/Funcionario.java       → Herda Pessoa
- model/Projeto.java           → Entidade Projeto
- dao/PessoaDAO.java           → CRUD Pessoa
- dao/FuncionarioDAO.java      → CRUD + regras
- dao/ProjetoDAO.java          → CRUD + regras
- app/Main.java                → Testes de exemplo
───────────────────────────────────────────

🚀 COMO EXECUTAR O PROJETO:

1. CRIAR O PROJETO NO ECLIPSE:
   - File > New > Java Project
   - Nome: empresa
   - Clique em Finish
   - Crie os pacotes: conexao, model, dao, app
   - Copie os arquivos .java para os pacotes corretos

2. ADICIONAR CONECTOR JDBC:
   - Baixe: https://dev.mysql.com/downloads/connector/j/
   - Extraia o .zip
   - Vá em Eclipse > botão direito no projeto > Build Path > Configure Build Path
   - Aba "Libraries" > Add External JARs > selecione o arquivo .jar do conector

3. CRIAR BANCO DE DADOS NO HEIDISQL:
   - Abra o HeidiSQL e conecte-se ao MySQL
   - Abra o script empresa.sql que está no projeto
   - Execute todo o script
   - Isso criará o banco `empresa` com as tabelas corretas

4. CONFIGURAR O ARQUIVO Conexao.java:
   - Edite com seu usuário e senha do MySQL:

     private static final String URL = "jdbc:mysql://localhost:3306/empresa";
     private static final String USUARIO = "root";  // seu usuário
     private static final String SENHA = "";        // sua senha

5. EXECUTAR A APLICAÇÃO:
   - Clique com o botão direito em Main.java > Run As > Java Application
   - Verifique as mensagens no console

───────────────────────────────────────────
✔ REGRAS DE NEGÓCIO IMPLEMENTADAS:

1. Funcionário só é cadastrado se a Pessoa existir
2. Projeto só pode ser criado com funcionário existente
3. Funcionário com projeto não pode ser excluído
4. Mensagens de erro claras no console
5. Mensagens de sucesso para operações bem-sucedidas

───────────────────────────────────────────
❗ DICA:
Caso deseje interações via console (menu CRUD interativo),
solicite o arquivo Menu.java que será facilmente integrado.

───────────────────────────────────────────

Desenvolvido para avaliação prática Java + JDBC.
