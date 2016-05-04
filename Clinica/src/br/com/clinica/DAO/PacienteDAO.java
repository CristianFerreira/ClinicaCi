package br.com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.clinica.domain.Paciente;
import br.com.clinica.factory.ConexaoFactory;

public class PacienteDAO {

	public void salvar(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		//INSERT INTO CLIENTE(NOME, TELEFONE, RG, ENDERECO) VALUES(?,?,?,?);
		sql.append("INSERT INTO cliente(nome, telefone, rg, endereco) ");
		sql.append("VALUES(?, ?, ?, ?) ");

		Connection conexao = ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTelefone());
		comando.setString(3, c.getRg());
		comando.setString(4, c.getEndereco());

		comando.executeUpdate();
	}

	public void excluir(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM cliente ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());

		comando.executeUpdate();

	}

	public void editar(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE cliente ");
		sql.append("SET nome = ? ");
		sql.append("SET telefone = ? ");
		sql.append("SET rg = ? ");
		sql.append("SET endereco = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTelefone());
		comando.setString(3, c.getRg());
		comando.setString(4, c.getEndereco());
		comando.setLong(2, c.getCodigo());

		comando.executeUpdate();

	}

	// PESQUISA
	public Paciente buscarPorCodigo(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome");
		sql.append("FROM cliente ");
		sql.append("WHERE = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Paciente retorno = null;

		// if porque sabemos que somente tem um que e o proximo, senao usaria
		// while
		while (resultado.next()) {
			retorno = new Paciente();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setTelefone(resultado.getString("telefone"));
			retorno.setRg(resultado.getString("rg"));
			retorno.setEndereco(resultado.getString("endereco"));
		}

		return retorno;

	}

	// PESQUISA_LISTA
	public List<Paciente> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome");
		sql.append("FROM cliente ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		List<Paciente> lista = new ArrayList<Paciente>();

		while (resultado.next()) {
			Paciente c = new Paciente();
			c.setCodigo(resultado.getLong("codigo"));
			c.setNome(resultado.getString("nome"));
			c.setTelefone(resultado.getString("telefone"));
			c.setRg(resultado.getString("rg"));
			c.setEndereco(resultado.getString("endereco"));

			lista.add(c);
		}

		return lista;
	}

	// PESQUISA_LISTA_DESCRICAO

	public ArrayList<Paciente> buscarPorDescricao(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome");
		sql.append("FROM cliente ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + c.getNome() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Paciente> lista = new ArrayList<Paciente>();

		while (resultado.next()) {
			Paciente item = new Paciente();
			item.setCodigo(resultado.getLong("codigo"));
			item.setNome(resultado.getString("nome"));
			item.setTelefone(resultado.getString("telefone"));
			item.setRg(resultado.getString("rg"));
			item.setEndereco(resultado.getString("endereco"));

			lista.add(item);
		}

		return lista;
	}

	public static void main(String[] args) {
		// INSERIR
		Paciente f1 = new Paciente();
		f1.setNome("Cristian");
		f1.setTelefone("31231");
		f1.setRg("31231");
		f1.setEndereco("312313");

		/*
		 * Cliente f2 = new Cliente (); f2.setNome("Thais da Rosa Lima");
		 * f2.setTelefone("95950209"); f2.setRg("312312312"); f2.setEndereco(
		 * "Av Souza mello, 937");
		 */

		PacienteDAO cDAO = new PacienteDAO();

		try {
			cDAO.salvar(f1);
			// cDAO.salvar(f2);

			System.out.println("Clientes Salvos");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ocorreu erro para salvar Clientes");
		}
	}

}

