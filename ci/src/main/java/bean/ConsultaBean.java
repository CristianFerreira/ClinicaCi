package main.java.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Table;

import main.java.domain.Consulta;
import main.java.domain.Paciente;
import main.java.domain.PlanoDeSaude;
import main.java.domain.Usuario;
import main.java.service.ConsultaService;
import main.java.service.PacienteService;
import main.java.service.PlanoDeSaudeService;
import main.java.service.UsuarioService;
import main.java.util.ClinicaEntityManager;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBConsulta")
@ViewScoped
public class ConsultaBean {
	
	private Consulta consulta;
	private ArrayList<Consulta> itens;
	private ArrayList<Consulta> itensFiltrados;
	private List<Paciente> listaPacientes;
	public List<Paciente> getListaPacientes() {
		return listaPacientes;
	}
	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	public List<PlanoDeSaude> getListaPlanos() {
		return listaPlanos;
	}
	public void setListaPlanos(List<PlanoDeSaude> listaPlanos) {
		this.listaPlanos = listaPlanos;
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public PacienteService getPacienteService() {
		return pacienteService;
	}
	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public PlanoDeSaudeService getPlanoService() {
		return planoService;
	}
	public void setPlanoService(PlanoDeSaudeService planoService) {
		this.planoService = planoService;
	}

	private List<PlanoDeSaude> listaPlanos;
	private List<Usuario> listaUsuarios;
	private ConsultaService consultaService = new ConsultaService(new ClinicaEntityManager("ClinicaPU"));
	private PacienteService pacienteService = new PacienteService(new ClinicaEntityManager("ClinicaPU"));
	private UsuarioService usuarioService = new UsuarioService(new ClinicaEntityManager("ClinicaPU"));
	private PlanoDeSaudeService planoService = new PlanoDeSaudeService(new ClinicaEntityManager("ClinicaPU"));
	
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
		
		try {
			listaPacientes = pacienteService.findAll();
			listaUsuarios = usuarioService.find30();
			listaPlanos = planoService.findAll();

		} catch (SQLException e) {

			e.printStackTrace(); 
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}

	
	public void novaConsulta() {
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
	
	public void prepararPaciente(){
		
		try {
			listaPacientes = pacienteService.findAll();
			listaUsuarios = usuarioService.findAll();
			listaPlanos = planoService.findAll();

		} catch (SQLException e) {

			e.printStackTrace(); 
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
		
	}
	

}
