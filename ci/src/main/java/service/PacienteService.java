package main.java.service;

import java.sql.SQLException;
import java.util.List;

import main.java.DAO.PacienteDAO;
import main.java.domain.Paciente;
import main.java.domain.PlanoDeSaude;
import main.java.util.ClinicaEntityManager;

public class PacienteService {
	ClinicaEntityManager cem;
	PacienteDAO pacienteDAO;
	
	public PacienteService(ClinicaEntityManager cem) {
		this.cem = cem;
		pacienteDAO = new PacienteDAO(this.cem.getEntityManager());
	}
	
	public List<Paciente> findAll() throws SQLException
	{
		try 
		{
			List<Paciente> lista = pacienteDAO.findAll();
			return lista;
		} catch (Exception e)
		{
			System.out.println("Não foi possivel buscar todos!");
			return null;
		}
	}
	
	public void save(Paciente paciente) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			pacienteDAO.save(paciente);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel inserir!");
			cem.rollBack();
		}
	}
	
	public void edit(Paciente paciente) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			pacienteDAO.update(paciente);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel alterar!");
			cem.rollBack();
		}
	}
	
	public void remove(Paciente paciente) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			pacienteDAO.delete(paciente);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel excluir!");
			cem.rollBack();
		}
	}

}
