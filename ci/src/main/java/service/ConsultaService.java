package main.java.service;

import java.sql.SQLException;
import java.util.List;

import main.java.DAO.ConsultaDAO;
import main.java.domain.Consulta;
import main.java.domain.Paciente;
import main.java.util.ClinicaEntityManager;

public class ConsultaService {
	ClinicaEntityManager cem;
	ConsultaDAO consultaDAO;
	
	public ConsultaService(ClinicaEntityManager cem){
		this.cem = cem;
		consultaDAO = new ConsultaDAO(this.cem.getEntityManager());
	}
	
	public List<Consulta> findAll() throws SQLException
	{
		try 
		{
			List<Consulta> lista = consultaDAO.findAll();
			return lista;
		} catch (Exception e)
		{
			System.out.println("Não foi possivel buscar todos!");
			return null;
		}
	}
	
	public void save(Consulta consulta) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			consultaDAO.save(consulta);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel inserir!");
			cem.rollBack();
		}
	}
	
	public void edit(Consulta consulta) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			consultaDAO.update(consulta);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel alterar!");
			cem.rollBack();
		}
	}
	
	public void remove(Consulta consulta) throws SQLException
	{
		try 
		{
			cem.beginTransaction();
			consultaDAO.delete(consulta);
			cem.commit();
		} catch (Exception e)
		{
			System.out.println("Não foi possivel excluir!");
			cem.rollBack();
		}
	}
}
