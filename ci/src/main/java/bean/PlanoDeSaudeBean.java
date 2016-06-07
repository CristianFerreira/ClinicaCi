package main.java.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import main.java.DAO.PlanoDeSaudeDAO;
import main.java.domain.PlanoDeSaude;
import main.java.service.PlanoDeSaudeService;
import main.java.util.ClinicaEntityManager;
import main.java.util.JSFUtil;

@ManagedBean(name = "MBPlano")
@ViewScoped
public class PlanoDeSaudeBean {
	private ArrayList<PlanoDeSaude> itens;
	private PlanoDeSaude planoDeSaude;
	private ArrayList<PlanoDeSaude> itensFiltrados;

	private PlanoDeSaudeService planoService = new PlanoDeSaudeService(new ClinicaEntityManager("ClinicaPU"));
	
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
			itens = (ArrayList<PlanoDeSaude>) planoService.findAll();

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
			planoService.save(planoDeSaude);

			itens = (ArrayList<PlanoDeSaude>) planoService.findAll();

			JSFUtil.adicionarMensagemSucesso("Plano de Saude salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			planoService.remove(planoDeSaude);

			itens = (ArrayList<PlanoDeSaude>) planoService.findAll();

			JSFUtil.adicionarMensagemSucesso("Plano de Saude ecluido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			planoService.edit(planoDeSaude);

			itens = (ArrayList<PlanoDeSaude>) planoService.findAll();

			JSFUtil.adicionarMensagemSucesso("Plano de Saude editado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
