package br.com.clinica.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.msv.driver.textui.Driver;

import br.com.clinica.factory.ConexaoFactory;

public class ConexaoFactory {
	private static final String USUARIO = "dev";
	private static final String SENHA = "pass@word1";
	private static final String URL = "jdbc:sqlserver://citfs:1433;databaseName=ClinicaCI";

	// Quem chamar a conexao vai ter que fazer tratamento, por isso usamos
	// throws
	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
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
