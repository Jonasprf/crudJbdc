package controllers;

import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

// classe de controle para prompt de açoes com pessoas

public class PessoaController {

	// atributo para criar um objeto da classe Scanner

	private Scanner scanner = new Scanner(System.in);

	// metodo para realizar cadastro de pessoa

	public void cadastarPessoa() {
		System.out.println("\nCadastro de pessoa:\n");

		var pessoa = new Pessoa();

		System.out.print("informe o nome da pessoa.....:");
		pessoa.setNome(scanner.nextLine());

		System.out.print("informe o email da pessoa...:");
		pessoa.setEmail(scanner.nextLine());
		
		var pessoaRepository = new PessoaRepository();
		pessoaRepository.create(pessoa);

	}

	public void atualizarPessoa() {
		System.out.println("\nATUALIZAR PESSOA:\n");
		
		var pessoa = new Pessoa();
		
		System.out.println("INFORME O ID DA PESSOA....:");
		pessoa.setId(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("informe o nome da pessoa.....:");
		pessoa.setNome(scanner.nextLine());

		System.out.print("informe o email da pessoa...:");
		pessoa.setEmail(scanner.nextLine());
		
		var pessoaRepository = new PessoaRepository();
		pessoaRepository.update(pessoa);

	}

	public void excluirPessoa() {
		
	System.out.println("\nEXCLUSAO DE  PESSOA:\n");
		
		
		
		System.out.println("INFORME O ID DA PESSOA....:");
		var id = Integer.parseInt(scanner.nextLine());
		
		var pessoaRepository = new PessoaRepository();
		pessoaRepository.delete(id);

	}

	public void consultarPessoas() {

		System.out.println("\nCONSULTA  DE  PESSOA:");
		
		var pessoaRepository = new PessoaRepository();
		var lista = pessoaRepository.findAll();
		
		for(var pessoa : lista) {
			 System.out.println("ID......" + pessoa.getId());
			 System.out.println("NOME...." + pessoa.getNome());
			 System.out.println("EMAIL...." + pessoa.getEmail());
			 System.out.println("......");
		} 

	}
}
