package br.com.fiap.controller;

import java.util.Scanner;

/**
 * Classe Empresa responsável por gerenciar as interações do usuário relacionadas à informações empresariais.
 * Esta classe permite ao usuário acessar informações sobre a história da empresa, seus cases de sucesso, e retornar ao menu principal.
 */

public class Empresa {
	
	 /**
     * Construtor da classe Empresa.
     * Este construtor atualmente não utiliza o objeto Scanner fornecido, mas está preparado para expansões futuras
     * que podem requerer leitura de entradas do usuário.
     *
     * @param scanner Um objeto Scanner para leitura da entrada do usuário. Atualmente não utilizado.
     */

	public Empresa(Scanner scanner) {
	}
	
	/**
     * Processa a seleção feita pelo usuário no menu de informações da empresa.
     * Este método direciona o usuário para a seção escolhida, podendo ver a história da empresa, seus cases de sucesso,
     * ou para voltar ao menu principal, baseando-se na entrada fornecida.
     *
     * @param selectEmpresa A opção selecionada pelo usuário, que determina a ação a ser realizada.
     */
	
	public void processarOpcao(String selectEmpresa) {
		switch(selectEmpresa) {
	        case "1":
	        	System.out.println("");
	            System.out.println("Nossa história começa quando...");
	            System.out.println("");
	            break;
	        case "2":
	        	System.out.println("");
	            System.out.println("Nossos principais cases de sucesso são...");
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
