package main.java.DAO;


import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.java.domain.Usuario;


public class GenericDAO<PK, T> {

    private EntityManager entityManager;

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
    
    
    public List<T> find10() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()) + " WHERE tipo_usuario=10").getResultList();
    }

    
    
    public List<T> find30() {
        return entityManager.createQuery("FROM " + getTypeClass().getName()+" WHERE tipo_usuario=30").getResultList();
    }
    

    private Class<?> getTypeClass() {
        Class<?> c = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return c;
    }

}
