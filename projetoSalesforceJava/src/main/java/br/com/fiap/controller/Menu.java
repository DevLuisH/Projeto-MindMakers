package br.com.fiap.controller;

import java.util.Scanner;
import br.com.fiap.model.CadastroUsuario;

/**
 * Classe Menu responsável por exibir o menu principal do aplicativo e processar as opções selecionadas pelo usuário.
 * Esta classe gerencia a navegação principal do usuário pelo aplicativo, permitindo acessar diferentes funcionalidades como produtos, categorias, suporte, entre outros.
 */

public class Menu {
	
	 /**
     * Construtor da classe Menu.
     * Inicializa um novo Menu com o Scanner e CadastroUsuario fornecidos.
     *
     * @param scanner o Scanner para leitura da entrada do usuário.
     * @param cadastroUsuario o gerenciador de cadastro de usuários.
     */
	
    private Scanner scanner;
    private Cadastro cadastro;
    private Usuario usuario;
    private CadastroUsuario cadastroUsuario;

    public Menu(Scanner scanner, CadastroUsuario cadastroUsuario) {
        this.scanner = scanner;
        this.cadastro = new Cadastro(scanner, cadastroUsuario);
        this.usuario = new Usuario(scanner);
        this.cadastroUsuario = cadastroUsuario;
    }
    
    /**
     * Exibe o menu principal e processa a seleção do usuário.
     * Este método mantém o usuário no loop do menu até que a opção de saída seja selecionada.
     */

    public void exibirMenu() {
        boolean executarMenu = true;
        
        while (executarMenu) {
            System.out.println("Bem vindo ao Menu Salesforce");
            System.out.println();
            System.out.println("1. Produtos");
            System.out.println("2. Categorias");
            System.out.println("3. Suporte");
            System.out.println("4. Empresa");
            System.out.println("5. Soluções");
            System.out.println("6. Usuário");
            System.out.println("7. Cadastro");
            System.out.println("8. Sair");
            System.out.println("Selecione uma opção: ");

            String opcaoMenu = scanner.nextLine();

            switch (opcaoMenu) {
                case "1":
                    exibirOpcoesProdutos();
                    break;
                case "2":
                    exibirOpcoesCategoria();
                    break;
                case "3":
                    exibirOpcoesSuporte();
                    break;
                case "4":
                	exibirOpcoesEmpresa();
                    break;
                case "5":
                    exibirOpcoesSolucoes();
                    break;
                case "6":
                	exibirOpcoesUsuario();
                    break;
                case "7":
                	exibirOpcoesCadastro();
                    break;
                case "8":
                    System.out.println("Saindo do programa. Volte sempre!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }
    }
    
    /**
     * Exibe as opções de produtos e processa a seleção do usuário.
     * Mantém o usuário no loop de produtos até que a opção de voltar seja selecionada.
     */

    public void exibirOpcoesProdutos() {
        boolean executarServicos = true;
        Produto produto = new Produto(scanner);
        
        while (executarServicos) {
            System.out.println("---------------------------------");
            System.out.println("Você selecionou Produtos");
            System.out.println("1. Slack");
            System.out.println("2. Customer 360");
            System.out.println("3. CRM");
            System.out.println("4. Formulário");
            System.out.println("5. Voltar ao Menu Inicial");
            System.out.println("Selecione uma opção: ");
            
            String selectProduto = scanner.nextLine();
            
            produto.processarOpcao(selectProduto);
            
            if (selectProduto.equals("5")) {
                executarServicos = false;
            }
        }
    }
    
    /**
     * Exibe as opções de categorias e processa a seleção do usuário.
     * Mantém o usuário no loop de categorias até que a opção de voltar seja selecionada.
     */

    public void exibirOpcoesCategoria() {
        boolean executarServicos = true;
        Categoria categoria = new Categoria(scanner);
        
        while (executarServicos) {
            System.out.println("---------------------------------");
            System.out.println("Você selecionou categorias, o que deseja saber ?");
            System.out.println("1. Níveis de empresa");
            System.out.println("2. Indústrias");
            System.out.println("3. Voltar ao Menu Inicial");
            System.out.println("Selecione uma opção: ");
            String selectCategoria = scanner.nextLine();
            
            
            categoria.processarOpcao(selectCategoria);
            
            if (selectCategoria.equals("3")) {
                executarServicos = false;
            }
        }
    }
    
 // Métodos similares para exibirOpcoesSuporte, exibirOpcoesEmpresa, etc., foram omitidos para brevidade.

    public void exibirOpcoesSuporte() {
        boolean executarServicos = true;
        Suporte suporte = new Suporte(scanner, cadastroUsuario);
        
        while (executarServicos) {
            System.out.println("---------------------------------");
            System.out.println("Você selecionou Suporte: ");
            System.out.println("1. Suporte técnico");
            System.out.println("2. Contato Salesforce");
            System.out.println("3. Voltar ao Menu Inicial");
            System.out.println("Selecione uma opção: ");
            String selectSuporte = scanner.nextLine();
            
            
            suporte.processarOpcao(selectSuporte);
            
            if (selectSuporte.equals("4")) {
                executarServicos = false;
            }
        }
    }
    
    public void exibirOpcoesEmpresa() {
    	boolean executarServicos = true;
    	Empresa empresa = new Empresa(scanner);
    	
    	while (executarServicos) {
    		System.out.println("---------------------------------");
    		System.out.println("Você selecionou Empresa: ");
    		System.out.println("1. Informações Salesforce");
    		System.out.println("2. Cases de sucesso");
    		System.out.println("3. Voltar ao Menu Inicial");
    		System.out.println("Selecione uma opção: ");
    		String selectEmpresa = scanner.nextLine();
    		
    		
    		empresa.processarOpcao(selectEmpresa);
        
    		if(selectEmpresa.equals("3")) {
    			executarServicos = false;
    		}
    	}
    }
    
    public void exibirOpcoesSolucoes() {
    	boolean executarServicos = true;
    	Solucoes solucoes = new Solucoes(scanner);
    	
    	while(executarServicos) {
    		System.out.println("---------------------------------");
    		System.out.println("Você selecionou Solucoes: ");
    		System.out.println("1. Pacotes pré personalizados");
    		System.out.println("2. Formulário de personalização de ferramentas");
    		System.out.println("3. Voltar ao Menu Inicial");
    		System.out.println("Selecione uma opção: ");
    		String selectSolucoes = scanner.nextLine();
        
    		
    		solucoes.processarOpcao(selectSolucoes);
        
    		if(selectSolucoes.equals("3")) {
    			executarServicos = false;
    		}
    	}
    }
    
    /**
     * Exibe as opções de cadastro e processa a seleção do usuário.
     * Mantém o usuário no loop de cadastro até que a opção de voltar seja selecionada.
     */
    
    public void exibirOpcoesUsuario() {
        boolean executarServicos = true;
        
        while (executarServicos) {
            System.out.println("---------------------------------");
            System.out.println("Você selecionou Usuário: ");
            System.out.println("1. Dúvidas sobre cadastro");
            System.out.println("2. Login");
            System.out.println("3. Esqueci minha senha");
            System.out.println("4. Menu Acessibilidade");
            System.out.println("5. Voltar ao Menu Inicial");
            System.out.println("Selecione uma opção: ");
            String selectUsuario = scanner.nextLine();
            
            usuario.processarOpcao(selectUsuario, cadastroUsuario);
            
            if (selectUsuario.equals("5")) {
                executarServicos = false;
            }
        }
    }
    
    /**
     * Exibe as opções de cadastro e processa a seleção do usuário.
     * Mantém o usuário no loop de cadastro até que a opção de voltar seja selecionada.
     */
    
    public void exibirOpcoesCadastro() {
        boolean executarServicos = true;

        while (executarServicos) {
            System.out.println("---------------------------------");
            System.out.println("Você selecionou cadastro de Usuário");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Todos os Usuários");
            System.out.println("3. Voltar ao Menu Principal");
            System.out.println("Selecione uma opção: ");
            String selectCadastro = scanner.nextLine();

            cadastro.processarOpcao(selectCadastro);

            if (selectCadastro.equals("3")) {
                executarServicos = false;
            }
        }
    }
}
