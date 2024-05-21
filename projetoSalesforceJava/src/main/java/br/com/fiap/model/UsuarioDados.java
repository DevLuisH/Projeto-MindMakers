package br.com.fiap.model;

/**
 * Classe que representa os dados de um usuário.
 * Armazena informações como nome, empresa, email, senha, CPF, CNPJ, e o ID do cargo associado ao usuário.
 */

public class UsuarioDados {
    private String nome_user;
    private String empresa_user;
    private String email_user;
    private String senha;
    private String cpf;
    private String cnpj_user;
    private int fk_Cargo_id_cargo;
    
    /**
     * Construtor completo para criação de um objeto UsuarioDados.
     *
     * @param nome Nome do usuário.
     * @param empresa Nome da empresa do usuário (opcional).
     * @param email Email do usuário.
     * @param senha Senha do usuário.
     * @param cpf CPF do usuário.
     * @param cnpj CNPJ da empresa do usuário (opcional).
     * @param fk_Cargo_id_cargo ID do cargo do usuário (0 indica nenhum cargo).
     */

    
    public UsuarioDados(String nome, String empresa, String email, String senha, String cpf, String cnpj, int fk_Cargo_id_cargo) {
        this.nome_user = nome;
        this.empresa_user = empresa;
        this.email_user = email;
        this.senha = senha;
        this.cpf = cpf;
        this.cnpj_user = cnpj;
        this.fk_Cargo_id_cargo = fk_Cargo_id_cargo;
    }
    
    /**
     * Construtor padrão sem parâmetros.
     */

    
    public UsuarioDados() {}

    
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public void setEmpresa_user(String empresa_user) {
        this.empresa_user = empresa_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj_user(String cnpj_user) {
        this.cnpj_user = cnpj_user;
    }

    public void setFk_Cargo_id_cargo(int fk_Cargo_id_cargo) {
        this.fk_Cargo_id_cargo = fk_Cargo_id_cargo;
    }

    
    public String getNome_user() {
        return nome_user;
    }

    public String getEmpresa_user() {
        return empresa_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCnpj_user() {
        return cnpj_user;
    }

    public int getFk_Cargo_id_cargo() {
        return fk_Cargo_id_cargo;
    }
    
    /**
     * Retorna uma representação em String dos dados do usuário, incluindo nome, empresa, email, CPF, CNPJ e ID do cargo.
     *
     * @return Uma string representando os dados do usuário.
     */

    @Override
    public String toString() {
        return "Nome: " + nome_user + "\n" +
               "Empresa: " + empresa_user + "\n" +
               "Email: " + email_user + "\n" +
               "CPF: " + cpf + "\n" +
               "CNPJ: " + cnpj_user + "\n" +
               "Cargo ID: " + fk_Cargo_id_cargo;
    }
}
