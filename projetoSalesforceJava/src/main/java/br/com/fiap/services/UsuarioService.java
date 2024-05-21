package br.com.fiap.services;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.bo.UsuarioBO;

public class UsuarioService {

    private UsuarioBO usuarioBO;

    public UsuarioService() throws ClassNotFoundException, SQLException {
        this.usuarioBO = new UsuarioBO();
    }

    public String inserirUsuario(UsuarioBeans usuario) {
        try {
            usuarioBO.inserirBO(usuario);
            return "Usuário cadastrado com sucesso!";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar usuário: " + e.getMessage();
        }
    }

    public String atualizarUsuario(UsuarioBeans usuario) {
        try {
            usuarioBO.atualizarBO(usuario);
            return "Usuário atualizado com sucesso!";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Erro ao atualizar usuário: " + e.getMessage();
        }
    }

    public String deletarUsuario(String email) {
        try {
            usuarioBO.deletarBO(email);
            return "Usuário deletado com sucesso!";
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return "Erro ao deletar usuário: " + e.getMessage();
        }
    }

    public List<UsuarioBeans> listarUsuarios() {
        try {
            return usuarioBO.selecionarBO();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UsuarioBeans buscarUsuarioPorEmail(String email) {
        try {
            List<UsuarioBeans> usuarios = usuarioBO.selecionarBO();
            for (UsuarioBeans usuario : usuarios) {
                if (usuario.getEmail_user().equals(email)) {
                    return usuario;
                }
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
