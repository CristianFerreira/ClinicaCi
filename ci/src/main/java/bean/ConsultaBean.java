package main.java.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Table;

import main.java.domain.Consulta;
import main.java.domain.Paciente;
import main.java.service.ConsultaService;
import main.java.service.PacienteService;
import main.java.util.ClinicaEntityManager;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBConsulta")
@ViewScoped
public class ConsultaBean {
	
	private Consulta consulta;
	private ArrayList<Consulta> itens;
	private ArrayList<Consulta> itensFiltrados;
	private ConsultaService consultaService = new ConsultaService(new ClinicaEntityManager("ClinicaPU"));
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public ArrayList<Consulta> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Consulta> itens) {
		this.itens = itens;
	}
	public ArrayList<Consulta> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Consulta> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public ConsultaService getConsultaService() {
		return consultaService;
	}
	public void setConsultaService(ConsultaService consultaService) {
		this.consultaService = consultaService;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			itens = (ArrayList<Consulta>) consultaService.findAll();

		} catch (SQLException e) {

			e.printStackTrace(); 
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}

	}
	
	public void prepararNovaConsulta() {
		consulta = new Consulta();
	}
	
	public void novoPaciente() {
		try {

			consultaService.save(consulta);

			itens = (ArrayList<Consulta>) consultaService.findAll();

			JSFUtil.adicionarMensagemSucesso("Consulta salva com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	
	public void excluir() {

		try {
			consultaService.remove(consulta);

			itens = (ArrayList<Consulta>) consultaService.findAll();
			

			JSFUtil.adicionarMensagemSucesso("Consulta removida com sucesso.");
		} catch (SQLException ex) {

			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	
	
	
	public void editar() {

		try {

			consultaService.edit(consulta);

			itens = (ArrayList<Consulta>) consultaService.findAll();
		

			JSFUtil.adicionarMensagemSucesso("Consulta editada com sucesso.");

		} catch (SQLException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}

	}
	

}
