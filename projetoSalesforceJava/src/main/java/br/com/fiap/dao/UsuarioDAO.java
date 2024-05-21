package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.conexoes.ConexaoFactory;

public class UsuarioDAO {

    public void inserir(UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        Connection minhaConexao = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            minhaConexao = new ConexaoFactory().conexao();
            System.out.println("Conexão estabelecida.");
            
            String sql = "INSERT INTO Usuario (empresa_user, email_user, nome_user, cnpj_user) VALUES (?, ?, ?, ?)";
            stmt = minhaConexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmpresa_user());
            stmt.setString(2, usuario.getEmail_user());
            stmt.setString(3, usuario.getNome_user());
            stmt.setString(4, usuario.getCnpj_user());
            stmt.execute();
            System.out.println("Usuário inserido com sucesso.");
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (minhaConexao != null) {
                minhaConexao.close();
            }
        }
    }

    public void atualizar(UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        Connection minhaConexao = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            minhaConexao = new ConexaoFactory().conexao();
            System.out.println("Conexão estabelecida.");
            
            String sql = "UPDATE Usuario SET empresa_user = ?, nome_user = ?, cnpj_user = ? WHERE email_user = ?";
            stmt = minhaConexao.prepareStatement(sql);
            stmt.setString(1, usuario.getEmpresa_user());
            stmt.setString(2, usuario.getNome_user());
            stmt.setString(3, usuario.getCnpj_user());
            stmt.setString(4, usuario.getEmail_user());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuário atualizado com sucesso.");
            } else {
                System.out.println("Nenhum usuário encontrado com o email fornecido.");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (minhaConexao != null) {
                minhaConexao.close();
            }
        }
    }

    public void deletar(String email) throws ClassNotFoundException, SQLException {
        Connection minhaConexao = null;
        PreparedStatement stmt = null;
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            minhaConexao = new ConexaoFactory().conexao();
            System.out.println("Conexão estabelecida.");
            
            String sql = "DELETE FROM Usuario WHERE email_user = ?";
            stmt = minhaConexao.prepareStatement(sql);
            stmt.setString(1, email);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Usuário deletado com sucesso.");
            } else {
                System.out.println("Nenhum usuário encontrado com o email fornecido.");
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (minhaConexao != null) {
                minhaConexao.close();
            }
        }
    }

    public List<UsuarioBeans> selecionar() throws ClassNotFoundException, SQLException {
        List<UsuarioBeans> listaUsuario = new ArrayList<>();
        Connection minhaConexao = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            System.out.println("Tentando conectar ao banco de dados...");
            minhaConexao = new ConexaoFactory().conexao();
            System.out.println("Conexão estabelecida.");
            
            String sql = "SELECT * FROM Usuario";
            stmt = minhaConexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioBeans usuario = new UsuarioBeans();
                usuario.setEmpresa_user(rs.getString("empresa_user"));
                usuario.setEmail_user(rs.getString("email_user"));
                usuario.setNome_user(rs.getString("nome_user"));
                usuario.setCnpj_user(rs.getString("cnpj_user"));
                listaUsuario.add(usuario);
            }
            System.out.println("Usuários selecionados com sucesso.");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (minhaConexao != null) {
                minhaConexao.close();
            }
        }
        return listaUsuario;
    }
}
