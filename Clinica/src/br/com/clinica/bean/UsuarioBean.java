package br.com.clinica.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.clinica.DAO.UsuarioDAO;

import br.com.clinica.domain.Usuario;
import br.com.clinica.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensFiltrados;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}

	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct // depois mostra na tela.
	public void prepararPesquisa() {
		try {

			UsuarioDAO cDAO = new UsuarioDAO();
			itens = (ArrayList<Usuario>) cDAO.listar();

		} catch (SQLException e) {

			e.printStackTrace(); // rastreia o erro.
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovoUsuario() {
		usuario = new Usuario();
	}
	
	public void Secretaria()
	{	
		
		
		try {
			usuario.setTipoUsuario(10);
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itens = (ArrayList<Usuario>) dao.listar();

			JSFUtil.adicionarMensagemSucesso("Paciente salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	
	

	public void novoUsuario() {
		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itens = (ArrayList<Usuario>) dao.listar();

			JSFUtil.adicionarMensagemSucesso("Paciente salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	/*
	 * public void excluir() {
	 * 
	 * try { PacienteDAO dao = new PacienteDAO(); dao.excluir(paciente);
	 * 
	 * itens = (ArrayList<Paciente>) dao.listar(); // itens = new
	 * ListDataModel<Paciente>(lista);
	 * 
	 * JSFUtil.adicionarMensagemSucesso("Paciente removido com sucesso."); }
	 * catch (SQLException ex) {
	 * 
	 * ex.printStackTrace(); JSFUtil.adicionarMensagemErro(ex.getMessage()); }
	 * 
	 * }
	 * 
	 * public void editar() {
	 * 
	 * try { UsuarioDAO dao = new UsuarioDAO(); dao.editar(usuario);
	 * 
	 * itens = (ArrayList<Usuario>) dao.listar();
	 * JSFUtil.adicionarMensagemSucesso("Paciente editado com sucesso.");
	 * 
	 * } catch (SQLException ex) { ex.printStackTrace();
	 * JSFUtil.adicionarMensagemErro(ex.getMessage()); }
	 * 
	 * }
	 */

}
