package br.com.fiap.controller;

import java.util.Scanner;

import br.com.fiap.model.CadastroUsuario;


/**
 * Classe Cadastro responsável por gerenciar as ações de cadastro de usuários.
 * Oferece funcionalidades para cadastrar novos usuários e listar todos os usuários cadastrados.
 */

public class Cadastro {

    private Scanner scanner;
    private CadastroUsuario cadastroUsuario;
    
    /**
     * Constrói uma instância de Cadastro com as dependências necessárias.
     *
     * @param scanner um Scanner para ler a entrada do usuário.
     * @param cadastroCliente uma instância de CadastroUsuario para realizar operações relacionadas ao cadastro de usuários.
     */

    public Cadastro(Scanner scanner, CadastroUsuario cadastroCliente) {
        this.scanner = scanner;
        this.cadastroUsuario = cadastroCliente;
    }
    
    /**
     * Processa a opção selecionada pelo usuário no menu de cadastro.
     * Baseado na entrada do usuário, esta função irá redirecionar para a funcionalidade adequada,
     * como cadastrar um novo usuário, listar todos os usuários, ou voltar ao menu principal.
     *
     * @param selectCadastro a opção de cadastro selecionada pelo usuário.
     */

    public void processarOpcao(String selectCadastro) {
        switch (selectCadastro) {
            case "1":
                cadastrarNovoUsuario();
                break;
            case "2":
                listarTodosUsuarios();
                break;
            case "3":
                System.out.println("\nVoltando ao Menu inicial...");
                break;
            default:
                System.out.println("\nOpção inválida, digite novamente");
                break;
        }
    }
    
    /**
     * Inicia o processo de cadastro de um novo usuário.
     * Solicita ao usuário que insira as informações necessárias para o cadastro e as passa para o modelo de cadastro de usuários.
     */

    private void cadastrarNovoUsuario() {
        System.out.println("\n--- Cadastro de Novo Usuário ---");
        cadastroUsuario.cadastrarUsuario(scanner);
    }
    
    /**
     * Exibe a lista de todos os usuários cadastrados.
     * Invoca a funcionalidade de listar usuários do modelo de cadastro de usuários para exibir uma lista de todos os usuários.
     */

    private void listarTodosUsuarios() {
        System.out.println("\n--- Lista de Usuários ---");
        cadastroUsuario.listarTodosUsuarios();
    }
}
