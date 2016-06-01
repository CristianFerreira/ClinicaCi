package main.java.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.DAO.UsuarioDAO;
import main.java.domain.Usuario;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensMedico;
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

	public ArrayList<Usuario> getItensMedico() {
		return itensMedico;
	}

	public void setItensMedico(ArrayList<Usuario> itensMedico) {
		this.itensMedico = itensMedico;
	}

	@PostConstruct // depois mostra na tela.
	public void prepararPesquisa() {
		try {

			UsuarioDAO cDAO = new UsuarioDAO();
			itens = (ArrayList<Usuario>) cDAO.listar();
			itensMedico = (ArrayList<Usuario>) cDAO.listarTipo30();

		} catch (SQLException e) {

			e.printStackTrace(); // rastreia o erro.
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovoUsuario() {
		usuario = new Usuario();
	}

	public void Secretaria() {

		try {
			usuario.setTipoUsuario(10);
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itens = (ArrayList<Usuario>) dao.listar();

			JSFUtil.adicionarMensagemSucesso("Secretario salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void Medico() {

		try {
			usuario.setTipoUsuario(30);
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itensMedico = (ArrayList<Usuario>) dao.listarTipo30();

			JSFUtil.adicionarMensagemSucesso("Medico salvo com sucesso.");

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

			JSFUtil.adicionarMensagemSucesso("Secretario salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void novoUsuarioMedico() {
		try {

			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);

			itensMedico = (ArrayList<Usuario>) dao.listarTipo30();

			JSFUtil.adicionarMensagemSucesso("Medico salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void excluir() {

		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.excluir(usuario);

			itens = (ArrayList<Usuario>) dao.listar();
			itensMedico = (ArrayList<Usuario>) dao.listarTipo30();
			// itens = new ListDataModel<Paciente>(lista);

			JSFUtil.adicionarMensagemSucesso("Secretario removido com sucesso.");
		} catch (SQLException ex) {

			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void editar() {

		try {
			usuario.setTipoUsuario(10);

			UsuarioDAO dao = new UsuarioDAO();

			dao.editar(usuario);

			itens = (ArrayList<Usuario>) dao.listar();

			JSFUtil.adicionarMensagemSucesso("Secretario editado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	public void editarMedico() {

		try {
			usuario.setTipoUsuario(30);

			UsuarioDAO dao = new UsuarioDAO();

			dao.editar(usuario);

			itensMedico = (ArrayList<Usuario>) dao.listarTipo30();

			JSFUtil.adicionarMensagemSucesso("Medico editado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

}
