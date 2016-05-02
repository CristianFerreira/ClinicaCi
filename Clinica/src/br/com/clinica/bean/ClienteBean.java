package br.com.clinica.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.clinica.DAO.ClienteDAO;
import br.com.clinica.domain.Cliente;

@ManagedBean(name = "MBCliente")
@ViewScoped
public class ClienteBean {
	private ListDataModel<Cliente> itens;

	public ListDataModel<Cliente> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Cliente> itens) {
		this.itens = itens;
	}

	@PostConstruct //depois mostra na tela.
	public void prepararPesquisa() {
		try {
			ClienteDAO cDAO = new ClienteDAO();
			ArrayList<Cliente> lista;
			lista = cDAO.listar();
			// convertendo arraylist para listDataModel para ser exibido na tela
			itens = new ListDataModel<Cliente>(lista);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // rastreia o erro.
		}

	}

}
