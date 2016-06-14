package main.java.DAO;

import javax.persistence.EntityManager;

import main.java.domain.Consulta;

public class ConsultaDAO extends GenericDAO<Long, Consulta>{
	
	public ConsultaDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
