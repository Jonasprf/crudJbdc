package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {

	// metodo para gravar um registro de pessoa na tabela do banco de dados
	public void create(Pessoa pessoa) {

		// abri conexao com o banco de dados atraves da factory
		var connection = ConnectionFactory.getConnection();

		try {

			// ESCREVER O COMANDO / SCRIPT SQL QUE SERÁ EXECUTADO NO BANCO DE DADOS
			var query = "INSERT INTO pessoa(nome,email) VALUES(?,?)";

			// executando a query no banco
			var statement = connection.prepareStatement(query);
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			var result = statement.executeUpdate();

			if (result==1) {
				System.out.println("\nPESSOA CADASTRADO COM SUCESSO");
			} else {
				System.out.println("\nNENHUM RESGISTRO FOI ADICIONADO NO BANCO DE DADOS");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR PESSOA");
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	public void update(Pessoa pessoa) {

		var connection = ConnectionFactory.getConnection();

		try {
			var query = "UPDATE pessoa SET nome = ?, email = ? WHERE id = ?";

			var statement = connection.prepareStatement(query);
			statement.setString(1, pessoa.getNome());
			statement.setString(2, pessoa.getEmail());
			statement.setInt(3, pessoa.getId());
			var result = statement.executeUpdate();

			if (result == 1) {
				System.out.println("\nPESSOA  ATUALIZADA COM SUCESSO");

			} else {
				System.out.println("\nNENHUM RESGISTRO FOI Atualizado NO BANCO DE DADOS. VERIFIQUE O ID INFORMADO");
			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR PESSOA");
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	
	public void delete (Integer id) {

		var connection = ConnectionFactory.getConnection();

		try {
			var query = "DELETE FROM pessoa WHERE id = ?";

			var statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			var result = statement.executeUpdate();

			if (result == 1) {
				System.out.println("\nPESSOA  EXCLUIDA COM SUCESSO");

			} else {
				System.out.println("\nNENHUM RESGISTRO FOI EXCLUIDO NO BANCO DE DADOS. VERIFIQUE O ID INFORMADO");
			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIDO PESSOA");
			System.out.println(e.getMessage());

		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	
	public List<Pessoa> findAll(){
		
		var connection = ConnectionFactory.getConnection();

		
		try {
			var query = "SELECT * FROM pessoa ORDER BY id";
			var statement = connection.prepareStatement(query);
			var result = statement.executeQuery();
			
			//criando uma lista para armazenar dos dados de cada pessoa obtido do banco
			var lista = new ArrayList<Pessoa>();
			
			//percorrer cada registro obtido do banco de dados
			while(result.next()) {
				
				var pessoa = new Pessoa();
				
				pessoa.setId(result.getInt("id"));//ler o id da pessoa
				pessoa.setNome(result.getString("nome"));// ler o nome da pessoa
				pessoa.setEmail(result.getString("email"));//ler o email da ´pessoa
				
				lista.add(pessoa);
			}
			
			return lista;
		}
		catch(Exception e){
			System.out.println("\nFALHA AO CONSULTAR PESSOA");
			System.out.println(e.getMessage());
			return null;

		}
		finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
	

}
