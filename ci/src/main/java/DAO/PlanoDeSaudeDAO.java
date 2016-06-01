package main.java.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.domain.PlanoDeSaude;
import main.java.factory.ConexaoFactory;

public class PlanoDeSaudeDAO {

	public void salvar(PlanoDeSaude plano) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO planos_de_saude (nome) VALUES(?)");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, plano.getNome());

			comando.executeQuery();
		} catch (Exception e) {
			System.out.println("N�o foi possivel inserir!");
		}
	}

	public List<PlanoDeSaude> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM planos_de_saude ORDER BY nome ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		List<PlanoDeSaude> lista = new ArrayList<PlanoDeSaude>();

		while (resultado.next()) {
			PlanoDeSaude plano = new PlanoDeSaude();
			plano.setIdPlano(new Long(resultado.getInt("id_plano")));
			plano.setNome(resultado.getString("nome"));

			lista.add(plano);
		}

		return lista;
	}

	public void excluir(PlanoDeSaude plano) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM planos_de_saude WHERE id_plano = ? ");

		Connection conexao = ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, plano.getIdPlano());

		comando.executeUpdate();
	}

}
