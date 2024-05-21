package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    // Construtor que inicializa a instância de UsuarioDAO
    public UsuarioBO() throws ClassNotFoundException, SQLException {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para inserir um novo usuário
    public void inserirBO(UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        usuarioDAO.inserir(usuario);
    }

    // Método para atualizar um usuário existente
    public void atualizarBO(UsuarioBeans usuario) throws ClassNotFoundException, SQLException {
        usuarioDAO.atualizar(usuario);
    }

    // Método para deletar um usuário pelo email
    public void deletarBO(String email) throws ClassNotFoundException, SQLException {
        usuarioDAO.deletar(email);
    }

    // Método para selecionar e retornar todos os usuários
    public List<UsuarioBeans> selecionarBO() throws ClassNotFoundException, SQLException {
        return usuarioDAO.selecionar();
    }
}
