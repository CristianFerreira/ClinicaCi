package main.java.DAO;

import javax.persistence.EntityManager;

import main.java.domain.Usuario;

public class UsuarioDAO extends GenericDAO<Long, Usuario>{

	public UsuarioDAO(EntityManager entityManager) {
        super(entityManager);
    }

}