package br.com.fiap.controller;

import java.util.Scanner;

public class Solucoes {
	
	/**
	 * Classe Solucoes é responsável por gerenciar as interações do usuário com as soluções oferecidas.
	 * Permite ao usuário explorar diferentes pacotes de soluções e preencher um formulário para personalização de serviços.
	 */

	public Solucoes(Scanner scanner) {
	}
	 /**
     * Processa a seleção de soluções feita pelo usuário.
     * Direciona o usuário para explorar pacotes de soluções, preencher um formulário de personalização, ou retornar ao menu principal baseando-se na escolha feita.
     *
     * @param selectSolucoes A opção de soluções selecionada pelo usuário.
     */
	
	public void processarOpcao(String selectSolucoes) {
		switch (selectSolucoes) {
	        case "1":
	        	System.out.println("");
	            System.out.println("Aqui temos 4 pacotes que possam atender sua solicitação...");
	            System.out.println("");
	            break;
	        case "2":
	        	System.out.println("");
	            System.out.println("Para preencher nosso formulário baste preencher as seguintes perguntas...");
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
