package br.com.fiap.controller;

import java.util.Scanner;

import br.com.fiap.model.CadastroUsuario;

/**
 * Classe Usuario responsável por gerenciar as interações relacionadas a operações de usuário,
 * como login, recuperação de senha, e informações sobre acessibilidade.
 */

public class Usuario {

    private Scanner scanner;
    
    /**
     * Construtor da classe Usuario.
     * Inicializa a classe com um objeto Scanner para leitura de entradas do usuário.
     *
     * @param scanner Um objeto Scanner para leitura de entradas do usuário.
     */

    public Usuario(Scanner scanner) {
        this.scanner = scanner;
    }
    
    /**
     * Processa a seleção de opção feita pelo usuário no menu relacionado a usuário.
     * Direciona para a funcionalidade escolhida, como fazer login, recuperar senha, acessar informações sobre acessibilidade, ou retornar ao menu principal.
     *
     * @param selectUsuario A opção de menu escolhida pelo usuário.
     * @param cadastroUsuario Uma instância de CadastroUsuario para acessar métodos de login e recuperação de senha.
     */

    public void processarOpcao(String selectUsuario, CadastroUsuario cadastroUsuario) {
        switch (selectUsuario) {
            case "1":
                System.out.println("");
                System.out.println("Para criar uma conta basta ir na opção Cadastro");
                System.out.println("");
                break;
            case "2":
                fazerLogin(cadastroUsuario);
                break;
            case "3":
                recuperarSenha(cadastroUsuario);
                break;
            case "4":
                System.out.println("");
                System.out.println("No Menu acessibilidade oferecemos as seguintes ferramentas...");
                System.out.println("");
                break;
            case "5":
                System.out.println("");
                System.out.println("\nVoltando ao Menu Inicial...");
                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.println("\nOpção inválida, digite novamente");
                System.out.println("");
        }
    }
    
    /**
     * Auxilia o usuário a realizar o login no sistema.
     * Solicita o e-mail e senha do usuário, e verifica se eles correspondem a um usuário cadastrado.
     *
     * @param cadastroUsuario A instância de CadastroUsuario usada para verificar as credenciais do usuário.
     */

    private void fazerLogin(CadastroUsuario cadastroUsuario) {
        System.out.println("");
        System.out.println("Login");
        System.out.println("");

        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (cadastroUsuario.verificarCliente(email, senha)) {
            System.out.println("");
            System.out.println("Você fez o login!");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("E-mail ou senha incorretos. Tente novamente.");
            System.out.println("");
        }
    }
    
    /**
     * Auxilia o usuário a recuperar a senha.
     * Solicita o CPF e o e-mail do usuário para iniciar o processo de recuperação de senha.
     *
     * @param cadastroCliente A instância de CadastroUsuario usada para o processo de recuperação de senha.
     */

    private void recuperarSenha(CadastroUsuario cadastroCliente) {
        System.out.println("");
        System.out.println("Recuperação de Senha");
        System.out.println("");

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();

        cadastroCliente.recuperarSenha(cpf, email);
        
    }
}
