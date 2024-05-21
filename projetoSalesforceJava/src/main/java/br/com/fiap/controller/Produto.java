package br.com.fiap.controller;

import java.util.Scanner;

/**
 * Classe Produto responsável por gerenciar as interações do usuário relacionadas a produtos.
 * Permite ao usuário explorar informações detalhadas sobre produtos específicos e acessar funcionalidades como visualização de detalhes do produto ou preenchimento de formulários.
 */

public class Produto {
	
	/**
     * Construtor da classe Produto.
     * Este construtor está preparado para futuras expansões que podem requerer a leitura de entradas do usuário através do objeto Scanner fornecido.
     *
     * @param scanner Um objeto Scanner para leitura da entrada do usuário. Atualmente não utilizado.
     */

    public Produto(Scanner scanner) {
    }
    
    /**
     * Processa a seleção de produto feita pelo usuário.
     * Direciona o usuário para a informação ou ação específica escolhida, como detalhes sobre Slack, Customer 360, CRM, acesso ao formulário ou retorno ao menu principal.
     *
     * @param selectProduto A opção de produto selecionada pelo usuário.
     */
    

    public void processarOpcao(String selectProduto) {
        switch (selectProduto) {
            case "1":
                System.out.println("");
                System.out.println("Slack se baseia em ...");
                System.out.println("");
                break;
            case "2":
                System.out.println("");
                System.out.println("Customer 360 se baseia em ...");
                System.out.println("");
                break;
            case "3":
                System.out.println("");
                System.out.println("CRM é uma ferramenta ...");
                System.out.println("");
                break;
            case "4":
                System.out.println("");
                System.out.println("Aqui está o formulário...");
                System.out.println("");
                break;
            case "5":
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
