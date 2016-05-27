package br.com.clinica.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.clinica.DAO.PacienteDAO;
import br.com.clinica.domain.Paciente;
import br.com.clinica.util.JSFUtil;

@ManagedBean(name = "MBPaciente")
@ViewScoped
public class PacienteBean {
	
	private Paciente paciente;
	private ArrayList<Paciente> itens;
	private ArrayList<Paciente> itensFiltrados;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ArrayList<Paciente> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Paciente> itens) {
		this.itens = itens;
	}

	public ArrayList<Paciente> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Paciente> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct // depois mostra na tela.
	public void prepararPesquisa() {
		try {
			PacienteDAO cDAO = new PacienteDAO();
			// List<Paciente> lista;
			itens = (ArrayList<Paciente>) cDAO.listar();
			// convertendo arraylist para listDataModel para ser exibido na tela

		} catch (SQLException e) {

			e.printStackTrace(); // rastreia o erro.
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovoPaciente() {
		paciente = new Paciente();
	}

	public void novoPaciente() {
		try {

			PacienteDAO dao = new PacienteDAO();
			dao.salvar(paciente);

			itens = (ArrayList<Paciente>) dao.listar();

			JSFUtil.adicionarMensagemSucesso("Paciente salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	// public void prepararExcluir() {
	// paciente = itens.getRowData(); // ja traz o paciente clicado
	// }

	public void excluir() {

		try {
			PacienteDAO dao = new PacienteDAO();
			dao.excluir(paciente);

			itens = (ArrayList<Paciente>) dao.listar();
			// itens = new ListDataModel<Paciente>(lista);

			JSFUtil.adicionarMensagemSucesso("Paciente removido com sucesso.");
		} catch (SQLException ex) {

			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

	// public void prepararEditar() {
	// paciente = itens.getRowData(); // ja traz o paciente clicado
	// }

	public void editar() {

		try {
			
			
			PacienteDAO dao = new PacienteDAO();
			dao.editar(paciente);

			itens = (ArrayList<Paciente>) dao.listar();
			// itens = new ListDataModel<Paciente>(lista);

			JSFUtil.adicionarMensagemSucesso("Paciente editado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
}
