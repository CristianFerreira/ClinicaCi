package br.com.clinica.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.clinica.factory.ConexaoFactory;

public class ConexaoFactory {
	static final String USUARIO = "root";
	static final String SENHA = "022010";
	static final String URL = "jdbc:sqljdbc://localhost:3306/clinica";

	// Quem chamar a conexao vai ter que fazer tratamento, por isso usamos
	// throws
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	// teste conexao

	public static void main(String[] args) {
		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException ex) {
			ex.printStackTrace(); // rastrear os erros
			System.out.println("Não foi possivel realizar a conexão!");
		}
	}
}
