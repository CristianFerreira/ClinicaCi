package main.java.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.domain.Usuario;
import main.java.service.UsuarioService;
import main.java.util.ClinicaEntityManager;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

	private Usuario usuario;
	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensMedico;
	private ArrayList<Usuario> itensFiltrados;

	private UsuarioService usuarioService = new UsuarioService(new ClinicaEntityManager("ClinicaPU"));

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

			itens = (ArrayList<Usuario>) usuarioService.find10();
			itensMedico = (ArrayList<Usuario>) usuarioService.find30();
		} catch (Exception e) {
			e.printStackTrace(); // rastreia o erro.
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovoUsuario() {
		usuario = new Usuario();
	}

	// secretaria
	public void Secretaria() {

		try {
			
			usuario.setTipoUsuario(10);
			usuarioService.saveSecretaria(usuario);

			itens = (ArrayList<Usuario>) usuarioService.find10();

			JSFUtil.adicionarMensagemSucesso("Secretario salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	// medico
	public void Medico() {
		try {
			
			usuario.setTipoUsuario(30);
			usuarioService.saveMedico(usuario);

			itensMedico = (ArrayList<Usuario>) usuarioService.find30();

			JSFUtil.adicionarMensagemSucesso("Medico salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	// Secretaria
	public void novoUsuario() {

		try {
			usuarioService.saveSecretaria(usuario);

			itens = (ArrayList<Usuario>) usuarioService.find10();

			JSFUtil.adicionarMensagemSucesso("Secretario salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	// medico
	public void novoUsuarioMedico() {

		try {
			usuarioService.saveMedico(usuario);

			itensMedico = (ArrayList<Usuario>) usuarioService.find30();

			JSFUtil.adicionarMensagemSucesso("Medico salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
	
	//excluir secretaria
	public void excluir() {

		try {
			usuarioService.remove(usuario);

			itens = (ArrayList<Usuario>) usuarioService.find10();
			itensMedico = (ArrayList<Usuario>) usuarioService.find30();

			JSFUtil.adicionarMensagemSucesso(" Excluido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	//editar secretaria
	public void editar() {

		try {

			usuarioService.edit(usuario);

			itens = (ArrayList<Usuario>) usuarioService.find10();

			JSFUtil.adicionarMensagemSucesso(" Editado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void editarMedico() {
		try {
			usuario.setTipoUsuario(30);
			usuarioService.edit(usuario);
			itensMedico = (ArrayList<Usuario>) usuarioService.find30();

			JSFUtil.adicionarMensagemSucesso("Medico editado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

}
