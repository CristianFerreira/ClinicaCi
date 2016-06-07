package main.java.service;

import java.sql.SQLException;
import java.util.List;

import main.java.DAO.PlanoDeSaudeDAO;
import main.java.domain.PlanoDeSaude;
import main.java.util.ClinicaEntityManager;

public class PlanoDeSaudeService {
	ClinicaEntityManager cem;
	PlanoDeSaudeDAO planoDAO;
	
	public PlanoDeSaudeService(ClinicaEntityManager cem) {
		this.cem = cem;
		planoDAO = new PlanoDeSaudeDAO(this.cem.getEntityManager());
	}
	
	public List<PlanoDeSaude> findAll() throws SQLException
	{
		try 
		{
			List<PlanoDeSaude> lista = planoDAO.findAll();
			return lista;
		} catch (Exception e)
		{
			System.out.println("Não foi possivel buscar todos!");
			return null;
		}
	}
	
	public void save(PlanoDeSaude plano) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			planoDAO.save(plano);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel inserir!");
			cem.rollBack();
		}
	}
	
	public void edit(PlanoDeSaude plano) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			planoDAO.update(plano);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel alterar!");
			cem.rollBack();
		}
	}
	
	public void remove(PlanoDeSaude plano) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			planoDAO.delete(plano);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel excluir!");
			cem.rollBack();
		}
	}
	
}
