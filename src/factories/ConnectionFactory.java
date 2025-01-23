package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//metodo para cirar uma conexão com o banco de dados
	//do PostGreSQL e retorna conexão
	
	public static Connection getConnection() {
		
		try {
			
			//parâmetro para conexao com o banco de dados
			var host = "jdbc:postgresql://localhost:1304/bd_aula03";
			var user = "postgres";
			var pass = "22188287";
			
			//criando e retornando a conexão para com o banco de dados
			return DriverManager.getConnection(host, user, pass);
		}
		catch(Exception e){
			System.out.println("\nFALHA AO CONECTAR COM POSTGRESQL");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
