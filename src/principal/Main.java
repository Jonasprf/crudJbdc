package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("\nSistema de gerenciamento de pessoas:\n");
		System.out.println("(1) CADASTRAR PESSOA");
		System.out.println("(2) ATUALIZAR PESSOA");
		System.out.println("(3) EXCLUIR PESSOA ");
		System.out.println("(4) consultar pessoa");
		
		System.out.print("\nINFORME A OPCAO DESEJADA:");
		var opcao = scanner.nextLine();
	
		var pessoaController = new PessoaController();
		
		switch(opcao) {
		case "1":
			pessoaController.cadastarPessoa();
			break;
		case "2":
			pessoaController.atualizarPessoa();
			break;
		case "3":
			pessoaController.excluirPessoa();
			break;
		case "4":
			pessoaController.consultarPessoas();
			break;
		default:
			System.out.println("\nOPCAO INVALIDA");
			break;
		}
		System.out.print("\nDESEJA CONTINUAR? (S,N)"); 
		var continuar = scanner.nextLine();
		
		if(continuar.equalsIgnoreCase("s")) {
			main(args);//recursividade
		}
		else {
			System.out.println("\nFim do programa");
		}
	}

}
