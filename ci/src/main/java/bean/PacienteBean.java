package main.java.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.DAO.PacienteDAO;
import main.java.domain.Paciente;
import main.java.service.PacienteService;
import main.java.service.PlanoDeSaudeService;
import main.java.util.ClinicaEntityManager;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBPaciente")
@ViewScoped
public class PacienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Paciente paciente;
	private ArrayList<Paciente> itens;
	private ArrayList<Paciente> itensFiltrados;
	private PacienteService pacienteService = new PacienteService(new ClinicaEntityManager("ClinicaPU"));
	

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
			itens = (ArrayList<Paciente>) pacienteService.findAll();

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

			pacienteService.save(paciente);

			itens = (ArrayList<Paciente>) pacienteService.findAll();

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
			pacienteService.remove(paciente);

			itens = (ArrayList<Paciente>) pacienteService.findAll();
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

			pacienteService.edit(paciente);

			itens = (ArrayList<Paciente>) pacienteService.findAll();
			// itens = new ListDataModel<Paciente>(lista);

			JSFUtil.adicionarMensagemSucesso("Paciente editado com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
}
