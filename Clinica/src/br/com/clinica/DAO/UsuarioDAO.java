package br.com.clinica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Usuario;
import br.com.clinica.factory.ConexaoFactory;

public class UsuarioDAO {
	public void salvar(Usuario u) throws SQLException {
		StringBuilder sql = new StringBuilder();
		// INSERT INTO USUARIO

		sql.append("INSERT INTO usuario ");
		sql.append("(tipo_usuario, nome, telefone, rg, endereco, login, senha, especialidades) ");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?) ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());

			comando.setInt(1, u.getTipoUsuario());
			comando.setString(2, u.getNome());
			comando.setString(3, u.getTelefone());
			comando.setString(4, u.getRg());
			comando.setString(5, u.getEndereco());
			comando.setString(6, u.getLogin());
			comando.setString(7, u.getSenha());
			comando.setString(8, u.getEspecialidade());

			comando.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Não foi possivel inserir!" +e.getMessage());
		}
			

	}

	// PESQUISA_LISTA
	public List<Usuario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario ORDER BY nome ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		List<Usuario> lista = new ArrayList<Usuario>();

		while (resultado.next()) {
			Usuario c = new Usuario();
			c.setIdUsuario(new Long(resultado.getInt("usuario_id")));
			c.setTipoUsuario(resultado.getInt("tipo_usuario"));
			c.setNome(resultado.getString("nome"));
			c.setTelefone(resultado.getString("telefone"));
			c.setRg(resultado.getString("rg"));
			c.setEndereco(resultado.getString("endereco"));
			c.setLogin(resultado.getString("login"));
			c.setSenha(resultado.getString("senha"));
			c.setEspecialidade(resultado.getString("especialidades"));

			lista.add(c);
		}

		return lista;
	}

	
	public void editar(Usuario c) throws SQLException {
		StringBuilder sql = new StringBuilder();

		//sql.append("UPDATE pacientes");
		sql.append("UPDATE usuario SET tipo_usuario = ?, nome = ?, telefone = ?, rg = ?, endereco= ?, login = ?, especialidades = ? WHERE usuario_id = ? ");
		//sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setInt(1, c.getTipoUsuario());
		comando.setString(2, c.getNome());
		comando.setString(3, c.getTelefone());
		comando.setString(4, c.getRg());
		comando.setString(5, c.getEndereco());
		comando.setString(6, c.getLogin());
		comando.setString(7, c.getEspecialidade());
		comando.setLong(8, c.getIdUsuario());

		comando.executeUpdate();

	}
	
	
	public Usuario buscarPorTipo(Usuario c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT tipo_usuario");
		sql.append("FROM usuario ");
		sql.append("WHERE = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getTipoUsuario());

		ResultSet resultado = comando.executeQuery();

		Usuario retorno = null;

		while (resultado.next()) {
			retorno = new Usuario();
			retorno.setNome(resultado.getString("nome"));
			retorno.setTipoUsuario(resultado.getInt("tipo_usuario"));
			
			
		}

		return retorno;

	}
	
	
	
	public void excluir(Usuario c) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM usuario ");
		sql.append("WHERE usuario_id = ? ");

		Connection conexao = ConexaoFactory.conectar();

		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getIdUsuario());

		comando.executeUpdate();

	}
	
	

	public static void main(String[] args)
	{
		Usuario user = new Usuario();
		user.setIdUsuario(6L);
		user.setTipoUsuario(10);
		user.setNome("manoela");
		user.setLogin("manu");
		user.setSenha("123");
		
		UsuarioDAO dao = new UsuarioDAO();
		
		try{
			dao.editar(user);
			System.out.println("Secretaria editado com sucesso");
		}catch(SQLException ex){
			System.out.println("não foi possivel editar a Secretaria "+ex.getMessage());
		}
	}
	
		

}
