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

@ManagedBean(name = "MBCliente")
@ViewScoped
public class PacienteBean {
	private ListDataModel<Paciente> itens;

	public ListDataModel<Paciente> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Paciente> itens) {
		this.itens = itens;
	}

	@PostConstruct //depois mostra na tela.
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
		}

	}

}
