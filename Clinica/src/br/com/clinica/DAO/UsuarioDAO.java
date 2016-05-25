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
			c.setEspecialidade(resultado.getString("especialidades"));

			lista.add(c);
		}

		return lista;
	}

	
	public void editar(Paciente c) throws SQLException {
		StringBuilder sql = new StringBuilder();

		//sql.append("UPDATE pacientes");
		sql.append("UPDATE pacientes SET nome = ?, telefone = ?, data_nascimento = ?, endereco = ?, observacoes = ? WHERE id_paciente = ? ");
		//sql.append("WHERE codigo = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTelefone());
		comando.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));
		comando.setString(4, c.getEndereco());
		comando.setString(5, c.getObservacao());
		comando.setLong(6, c.getCodigo());

		comando.executeUpdate();

	}

	
		

}
