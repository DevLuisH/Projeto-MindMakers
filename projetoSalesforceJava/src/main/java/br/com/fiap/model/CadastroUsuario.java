package br.com.fiap.model;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Classe responsável pelo cadastro e gerenciamento de usuários.
 * Armazena uma lista de usuários e oferece funcionalidades para adicionar novos usuários, validar CPF/CNPJ, recuperar senha e listar todos os usuários cadastrados.
 */

public class CadastroUsuario {
    private ArrayList<UsuarioDados> listaUsuarios;
    
    /**
     * Construtor que inicializa a lista de usuários.
     */

    public CadastroUsuario() {
        this.listaUsuarios = new ArrayList<>();
    }
    
    /**
     * Cadastra um novo usuário pedindo dados como nome, empresa, email, senha, CPF e CNPJ através do console.
     * Realiza a validação do CPF e CNPJ antes de adicionar o usuário à lista.
     *
     * @param scanner Scanner utilizado para ler a entrada do usuário no console.
     */

    public void cadastrarUsuario(Scanner scanner) {
        System.out.println("Cadastro de Novo Usuário");
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o nome da empresa (opcional): ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o e-mail: ");
        String email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        
        System.out.print("Digite o ID do Cargo (0 para nenhum): ");
        int fk_Cargo_id_cargo = Integer.parseInt(scanner.nextLine()); // Conversão da entrada para inteiro

        String cpf;
        boolean cpfValido = false;
        do {
            System.out.print("Digite o CPF (somente números): ");
            cpf = scanner.nextLine();
            if (!cpf.matches("\\d+")) {
                System.out.println("CPF inválido. Por favor, digite apenas números.");
                continue;
            }
            cpfValido = validarCPF(cpf);
            if (!cpfValido) {
                System.out.println("CPF inválido. Por favor, digite um CPF válido.");
            }
        } while (!cpfValido);
        
        String cnpj;
        boolean cnpjValido = false;
        do {
            System.out.print("Digite o CNPJ (somente números): ");
            cnpj = scanner.nextLine();
            if (!cnpj.matches("\\d+")) {
                System.out.println("CNPJ inválido. Por favor, digite apenas números.");
                continue;
            }
            cnpjValido = validarCNPJ(cnpj);
            if (!cnpjValido) {
                System.out.println("CNPJ inválido. Por favor, digite um CNPJ válido.");
            }
        } while (!cnpjValido);

        // Criação e adição do novo usuário com todos os dados coletados, incluindo o ID do cargo
        UsuarioDados novoUsuario = new UsuarioDados(nome, empresa, email, senha, cpf, cnpj, fk_Cargo_id_cargo);
        listaUsuarios.add(novoUsuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }
    
    /**
     * Valida o formato e a veracidade de um número de CPF.
     *
     * @param cpf O CPF a ser validado.
     * @return true se o CPF for válido, false caso contrário.
     */

    private boolean validarCPF(String cpf) {
        // Implementação da validação do CPF
        return true;
    }
    
    /**
     * Valida o formato e a veracidade de um número de CNPJ.
     *
     * @param cnpj O CNPJ a ser validado.
     * @return true se o CNPJ for válido, false caso contrário.
     */

    private boolean validarCNPJ(String cnpj) {
        // Implementação da validação do CNPJ
        return true;
    }
    
    /**
     * Permite a um usuário recuperar sua senha fornecendo o CPF e o email associados à sua conta.
     *
     * @param cpf O CPF do usuário que deseja recuperar a senha.
     * @param email O email do usuário que deseja recuperar a senha.
     */

    public void recuperarSenha(String cpf, String email) {
        System.out.println("Recuperação de Senha");
        boolean encontrado = false;
        for (UsuarioDados usuario : listaUsuarios) {
            if (usuario.getCpf().equals(cpf) && usuario.getEmail_user().equals(email)) {
                System.out.println("Sua senha é: " + usuario.getSenha());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Usuário não encontrado. Verifique as informações fornecidas.");
        }
    }
    
    /**
     * Lista todos os usuários cadastrados, imprimindo suas informações no console.
     */

    public void listarTodosUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado ainda.");
        } else {
            System.out.println("Lista de Usuários:");
            for (UsuarioDados usuario : listaUsuarios) {
                System.out.println(usuario.toString());
            }
        }
    }
    
    /**
     * Verifica se existe um usuário cadastrado com o email e senha fornecidos.
     *
     * @param email O email do usuário a ser verificado.
     * @param senha A senha do usuário a ser verificada.
     * @return true se um usuário correspondente for encontrado, false caso contrário.
     */

    public boolean verificarCliente(String email, String senha) {
        for (UsuarioDados usuario : listaUsuarios) {
            if (usuario.getEmail_user().equals(email) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
