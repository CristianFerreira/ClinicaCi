package br.com.clinica.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.clinica.DAO.PacienteDAO;
import br.com.clinica.domain.Paciente;
import br.com.clinica.util.JSFUtil;

@ManagedBean(name = "MBPaciente")
@ViewScoped
public class PacienteBean {
	private ListDataModel<Paciente> itens;
	private Paciente paciente;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ListDataModel<Paciente> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Paciente> itens) {
		this.itens = itens;
	}

	@PostConstruct // depois mostra na tela.
	public void prepararPesquisa() {
		try {
			PacienteDAO cDAO = new PacienteDAO();
			List<Paciente> lista;
			lista = cDAO.listar();
			// convertendo arraylist para listDataModel para ser exibido na tela
			itens = new ListDataModel<Paciente>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			
			ArrayList<Paciente> lista = (ArrayList<Paciente>) dao.listar();
			itens = new ListDataModel<Paciente>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Paciente Salvo com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}

}
