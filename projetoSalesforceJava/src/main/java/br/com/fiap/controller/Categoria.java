package br.com.fiap.controller;

import java.util.Scanner;

/**
 * Classe Categoria responsável por gerenciar as interações do usuário com as categorias de produtos ou serviços.
 * Oferece opções para o usuário explorar diferentes categorias de empreendimentos e nichos de indústrias.
 */

public class Categoria {
	
	/**
     * Constrói uma instância de Categoria.
     * Atualmente, este construtor não armazena o Scanner passado como parâmetro, mas está preparado para futuras expansões onde a entrada do usuário possa ser necessária.
     *
     * @param scanner um Scanner para ler a entrada do usuário, não utilizado no momento.
     */

    public Categoria(Scanner scanner) {
    }
    
    /**
     * Processa a seleção de categoria feita pelo usuário.
     * Baseado na escolha do usuário, este método exibe informações sobre os níveis de categorias de empreendimento,
     * abrange diversos nichos de indústrias ou retorna ao menu inicial.
     *
     * @param selectCategoria a opção de categoria selecionada pelo usuário.
     */

    public void processarOpcao(String selectCategoria) {
        switch(selectCategoria) {
            case "1":
                System.out.println("");
                System.out.println("Possuímos 3 níveis de categorias de empreendimento nos pacotes");
                System.out.println("");
                break;
            case "2":
                System.out.println("");
                System.out.println("Abrangemos diversos nichos de indústrias...");
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
