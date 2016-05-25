package br.com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import br.com.clinica.domain.PlanoDeSaude;
import br.com.clinica.factory.ConexaoFactory;

public class PlanoDeSaudeDAO {
	
	public void salvar(PlanoDeSaude plano) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO planos_de_saude (nome) VALUES(?)");
		
		try 
		{
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, plano.getNome());
			
			comando.executeQuery();
		} catch (Exception e) {
			System.out.println("Não foi possivel inserir!");
		}
	}
	
	
	public List<PlanoDeSaude> listar() throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM planos_de_saude ORDER BY nome ASC");
		
		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();
		
		List<PlanoDeSaude> lista = new ArrayList<PlanoDeSaude>();
		
		while(resultado.next()){
			PlanoDeSaude plano = new PlanoDeSaude();
			plano.setIdPlano(new Long(resultado.getInt("id_plano")));
			plano.setNome(resultado.getString("nome"));
			
			lista.add(plano);
		}
		
		return lista;
	}
}
