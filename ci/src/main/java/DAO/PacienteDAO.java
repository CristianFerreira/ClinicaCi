package main.java.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import main.java.domain.Paciente;
import main.java.domain.PlanoDeSaude;

public class PacienteDAO extends GenericDAO<Long, Paciente> {
	
	public PacienteDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
	
//
//	public void salvar(Paciente c) throws SQLException {
//		StringBuilder sql = new StringBuilder();
//		// INSERT INTO CLIENTE(NOME, TELEFONE, RG, ENDERECO) VALUES(?,?,?,?);
//		sql.append(
//				"INSERT INTO pacientes(nome, telefone, data_nascimento, endereco, observacoes) VALUES(?, ?, ?, ?, ?)");
//
//		try {
//			Connection conexao = ConexaoFactory.conectar();
//			java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
//			comando.setString(1, c.getNome());
//			comando.setString(2, c.getTelefone());
//			comando.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));
//			comando.setString(4, c.getEndereco());
//			comando.setString(5, c.getObservacao());
//
//			comando.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println("N�o foi possivel inserir!");
//		}
//
//	}
//
//	public void excluir(Paciente c) throws SQLException {
//		StringBuilder sql = new StringBuilder();
//
//		sql.append("DELETE FROM pacientes ");
//		sql.append("WHERE id_paciente = ? ");
//
//		Connection conexao = ConexaoFactory.conectar();
//
//		java.sql.PreparedStatement comando = conexao.prepareStatement(sql.toString());
//		comando.setLong(1, c.getCodigo());
//
//		comando.executeUpdate();
//
//	}
//
//	public void editar(Paciente c) throws SQLException {
//		StringBuilder sql = new StringBuilder();
//
//		// sql.append("UPDATE pacientes");
//		sql.append(
//				"UPDATE pacientes SET nome = ?, telefone = ?, data_nascimento = ?, endereco = ?, observacoes = ? WHERE id_paciente = ? ");
//		// sql.append("WHERE codigo = ?");
//
//		Connection conexao = ConexaoFactory.conectar();
//
//		PreparedStatement comando = conexao.prepareStatement(sql.toString());
//		comando.setString(1, c.getNome());
//		comando.setString(2, c.getTelefone());
//		comando.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));
//		comando.setString(4, c.getEndereco());
//		comando.setString(5, c.getObservacao());
//		comando.setLong(6, c.getCodigo());
//
//		comando.executeUpdate();
//
//	}
//
//	// PESQUISA
//	public Paciente buscarPorCodigo(Paciente c) throws SQLException {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT id_paciente, nome");
//		sql.append("FROM pacientes ");
//		sql.append("WHERE = ? ");
//
//		Connection conexao = ConexaoFactory.conectar();
//
//		PreparedStatement comando = conexao.prepareStatement(sql.toString());
//		comando.setLong(1, c.getCodigo());
//
//		ResultSet resultado = comando.executeQuery();
//
//		Paciente retorno = null;
//
//		// if porque sabemos que somente tem um que e o proximo, senao usaria
//		// while
//		while (resultado.next()) {
//			retorno = new Paciente();
//			retorno.setCodigo(resultado.getLong("id_paciente"));
//			retorno.setNome(resultado.getString("nome"));
//			// retorno.setTelefone(resultado.getString("telefone"));
//			// retorno.setRg(resultado.getString("rg"));
//			// retorno.setEndereco(resultado.getString("endereco"));
//		}
//
//		return retorno;
//
//	}
//
//	// PESQUISA_LISTA
//	public List<Paciente> listar() throws SQLException {
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM pacientes ORDER BY nome ASC");
//
//		Connection conexao = ConexaoFactory.conectar();
//
//		PreparedStatement comando = conexao.prepareStatement(sql.toString());
//
//		ResultSet resultado = comando.executeQuery();
//
//		List<Paciente> lista = new ArrayList<Paciente>();
//
//		while (resultado.next()) {
//			Paciente c = new Paciente();
//			c.setCodigo(new Long(resultado.getInt("id_paciente")));
//			c.setNome(resultado.getString("nome"));
//			c.setDataNasc(resultado.getTimestamp("data_nascimento"));
//			c.setTelefone(resultado.getString("telefone"));
//			c.setEndereco(resultado.getString("endereco"));
//			c.setObservacao(resultado.getString("observacoes"));
//
//			lista.add(c);
//		}
//
//		return lista;
//	}

	// PESQUISA_LISTA_DESCRICAO

	/*
	 * public ArrayList<Paciente> buscarPorDescricao(Paciente c) throws
	 * SQLException { StringBuilder sql = new StringBuilder(); sql.append(
	 * "SELECT id_paciente, nome"); sql.append("FROM pacientes "); sql.append(
	 * "WHERE nome LIKE ? "); sql.append("ORDER BY nome ASC ");
	 * 
	 * Connection conexao = ConexaoFactory.conectar();
	 * 
	 * PreparedStatement comando = conexao.prepareStatement(sql.toString());
	 * comando.setString(1, "%" + c.getNome() + "%");
	 * 
	 * ResultSet resultado = comando.executeQuery();
	 * 
	 * ArrayList<Paciente> lista = new ArrayList<Paciente>();
	 * 
	 * while (resultado.next()) { Paciente item = new Paciente();
	 * item.setCodigo(resultado.getLong("codigo"));
	 * item.setNome(resultado.getString("nome"));
	 * //item.setTelefone(resultado.getString("telefone"));
	 * //item.setRg(resultado.getString("rg"));
	 * //item.setEndereco(resultado.getString("endereco"));
	 * 
	 * lista.add(item); }
	 * 
	 * return lista; }
	 */

	/*
	 * public static void main(String[] args) { // INSERIR Paciente f1 = new
	 * Paciente(); f1.setNome("Simone Santos Ferreira");
	 * f1.setTelefone("(51)96953571");
	 * 
	 * 
	 * Paciente f2 = new Paciente(); f2.setNome("Thais da Rosa Lima");
	 * f2.setTelefone("95950209"); f2.setEndereco("Av Souza mello, 937");
	 * 
	 * 
	 * PacienteDAO cDAO = new PacienteDAO();
	 * 
	 * try { cDAO.salvar(f1); // cDAO.salvar(f2);
	 * 
	 * System.out.println("Clientes Salvos"); } catch (SQLException e) {
	 * e.printStackTrace(); System.out.println(
	 * "Ocorreu erro para salvar Clientes"); } }
	 */

	/*
	 * public static void main(String[] args) { Paciente f1 = new Paciente();
	 * f1.setCodigo(1L);
	 * 
	 * Paciente f2 = new Paciente(); f2.setCodigo(2L);
	 * 
	 * PacienteDAO fdao = new PacienteDAO();
	 * 
	 * try { Paciente f3 = fdao.buscarPorCodigo(f1); Paciente f4 =
	 * fdao.buscarPorCodigo(f2);
	 * 
	 * System.out.println("Resultado 1: " + f3); System.out.println(
	 * "Resultado 2: " + f4); } catch (SQLException e) { System.out.println(
	 * "Ocorreu um erro ao tentar pesquisar um dos fabricantes"); } }
	 */
}
