package main.java.DAO;

import javax.persistence.EntityManager;

import main.java.domain.PlanoDeSaude;

public class PlanoDeSaudeDAO extends GenericDAO<Long, PlanoDeSaude> {
	
	public PlanoDeSaudeDAO(EntityManager entityManager)
	{
		super(entityManager);
	}
}
