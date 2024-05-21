package br.com.fiap.main;

import java.util.Scanner;

import br.com.fiap.controller.Menu;
import br.com.fiap.model.CadastroUsuario;

/**
 * Classe principal que atua como ponto de entrada para a aplicação do Menu e seus atributos.
 * Inicia o programa criando os componentes necessários para a execução e apresenta o menu principal ao usuário.
 */

public class MainMenu {
    public static void main(String[] args) {
    	// Cria um objeto Scanner para leitura da entrada do usuário. Este objeto será usado em toda a aplicação
        // para ler a entrada do console.
        Scanner scanner = new Scanner(System.in);
        // Instancia CadastroUsuario, que gerencia a lógica de negócios relacionada ao cadastro e gestão de usuários.

        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        // Cria o objeto Menu, fornecendo o Scanner e o CadastroUsuario. O objeto Menu é responsável por
        // apresentar as opções do menu principal ao usuário e processar suas escolhas.
        Menu menu = new Menu(scanner, cadastroUsuario);
        // Exibe o menu principal e inicia o processo de interação com o usuário.
        // O método exibirMenu permanecerá executando até que o usuário escolha sair da aplicação.
        menu.exibirMenu();
    }
}
