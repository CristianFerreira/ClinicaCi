package main.java.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.DAO.PlanoDeSaudeDAO;
import main.java.domain.PlanoDeSaude;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBPlano")
@ViewScoped
public class PlanoDeSaudeBean {
	private ArrayList<PlanoDeSaude> itens;
	private PlanoDeSaude planoDeSaude;
	private ArrayList<PlanoDeSaude> itensFiltrados;

	public ArrayList<PlanoDeSaude> getItens() {
		return itens;
	}

	public void setItens(ArrayList<PlanoDeSaude> itens) {
		this.itens = itens;
	}
	
	public ArrayList<PlanoDeSaude> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<PlanoDeSaude> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			
			itens = new ArrayList<PlanoDeSaude>(planoDAO.listar());
			
		} catch (Exception e) {
			e.printStackTrace(); // rastreia o erro.
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public PlanoDeSaude getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public void prepararNovo() {
		planoDeSaude = new PlanoDeSaude();
	}

	public void novo() {
		try {
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			planoDAO.salvar(planoDeSaude);

			itens = new ArrayList<PlanoDeSaude>(planoDAO.listar());

			JSFUtil.adicionarMensagemSucesso("Plano de Saude salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			planoDAO.excluir(planoDeSaude);

			itens = new ArrayList<PlanoDeSaude>(planoDAO.listar());

			JSFUtil.adicionarMensagemSucesso("Plano de Saude ecluido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editar()
	{
		PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
		try
		{
			planoDAO.editar(planoDeSaude);
			
			itens = new ArrayList<PlanoDeSaude>(planoDAO.listar());
			
			JSFUtil.adicionarMensagemSucesso("Plano de Saude editado com sucesso!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
