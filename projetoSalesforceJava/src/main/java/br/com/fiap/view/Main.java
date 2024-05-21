package br.com.fiap.view;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.UsuarioBeans;
import br.com.fiap.dao.UsuarioDAO;

/**
 * Classe Main para interagir com a funcionalidade do Banco de dados.
 * Demonstra o uso da classe UsuarioDAO para salvar novos usuários no banco de dados e listar todos os usuários cadastrados.
 * 
 * Autor:
 * MindMakers
 * Luis Henrique Oliveira 552692
 * Sabrina Café 553568
 * João 553698
 * 
 */

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando a aplicação...");
            
            System.out.println("\nInserindo usuário...");
            
            System.out.println("----------------------");
            try {
                UsuarioDAO usuarioDao = new UsuarioDAO();
                UsuarioBeans usuarioBens = new UsuarioBeans();
                usuarioBens.setEmpresa_user("Faculdade de Informatica");
                usuarioBens.setEmail_user("fiap@email.com");
                usuarioBens.setNome_user("FIAP");
                usuarioBens.setCnpj_user("11319526000155");
                usuarioDao.inserir(usuarioBens);
                System.out.println("Usuário inserido com sucesso.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            
            System.out.println("Listando todos os usuários...");
            try {
                UsuarioDAO usuarioDao = new UsuarioDAO();
                List<UsuarioBeans> usuarios = usuarioDao.selecionar();
                for (UsuarioBeans usuario : usuarios) {
                    System.out.println("Usuário: " + usuario.getNome_user());
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
