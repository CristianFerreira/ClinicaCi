package br.com.clinica.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.clinica.DAO.PlanoDeSaudeDAO;
import br.com.clinica.domain.PlanoDeSaude;
import br.com.clinica.util.JSFUtil;

@ManagedBean(name = "MBPlano")
@ViewScoped
public class PlanoDeSaudeBean {
	private ListDataModel<PlanoDeSaude> itens;
	private PlanoDeSaude planoDeSaude;
	
	public ListDataModel<PlanoDeSaude> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<PlanoDeSaude> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void prepararPesquisa(){
		try {
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			List<PlanoDeSaude> lista;
			lista = planoDAO.listar();
			
			itens = new ListDataModel<PlanoDeSaude>(lista);
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
	
	public void prepararNovo()
	{
		planoDeSaude = new PlanoDeSaude();
	}
	
	public void novo()
	{
		try {
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			planoDAO.salvar(planoDeSaude);
			
			List<PlanoDeSaude> lista = planoDAO.listar();
			itens = new ListDataModel<PlanoDeSaude>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Plano de Saude salvo com sucesso!");
		} catch (Exception e) { 
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararExcluir()
	{
		planoDeSaude = itens.getRowData();
	}
	
	public void excluir()
	{
		try
		{
			PlanoDeSaudeDAO planoDAO = new PlanoDeSaudeDAO();
			planoDAO.excluir(planoDeSaude);
			
			List<PlanoDeSaude> lista = planoDAO.listar();
			itens = new ListDataModel<PlanoDeSaude>(lista);
			
			JSFUtil.adicionarMensagemSucesso("Plano de Saude ecluido com sucesso!");
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
}
