package br.com.fiap.controller;

import java.util.Scanner;

import br.com.fiap.model.CadastroUsuario;

/**
 * Classe Suporte é responsável por gerenciar as interações de suporte ao usuário.
 * Permite ao usuário acessar opções de suporte, como verificar se é cliente, enviar um formulário de suporte ou retornar ao menu principal.
 */

public class Suporte {

    private Scanner scanner;
    private CadastroUsuario cadastroUsuario;
    
    /**
     * Constrói uma instância de Suporte com as dependências necessárias para operação.
     * 
     * @param scanner Um objeto Scanner para leitura de entradas do usuário.
     * @param cadastroUsuario Uma instância de CadastroUsuario para verificar informações de clientes.
     */

    public Suporte(Scanner scanner, CadastroUsuario cadastroUsuario) {
        this.scanner = scanner;
        this.cadastroUsuario = cadastroUsuario;
    }
    
    /**
     * Processa a opção de suporte selecionada pelo usuário.
     * Baseado na seleção do usuário, pode verificar o status do cliente, enviar um formulário de suporte, ou retornar ao menu principal.
     *
     * @param selectSuporte A opção de suporte escolhida pelo usuário.
     */

    public void processarOpcao(String selectSuporte) {
        switch(selectSuporte) {
            case "1":
                System.out.println("");
                System.out.println("Você é cliente?");
                System.out.println("");
                
                // Solicitar email e senha
                System.out.print("Digite o email: ");
                String email = scanner.nextLine();
                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();
                
                // Verificar se o usuário é cliente
                if (cadastroUsuario.verificarCliente(email, senha)) {
                    System.out.println("Você é um cliente.");
                } else {
                    System.out.println("Você ainda não é um cliente.");
                }
                break;
            case "2":
                System.out.println("");
                System.out.println("Enviando email de formulário de suporte!");
                System.out.println("");
                break;
            case "3":
                System.out.println("");
                System.out.println("Voltando ao Menu inicial...");
                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.println("Opção inválida");
                System.out.println("");
        }
    }
}
