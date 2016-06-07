package main.java.service;

import java.util.List;

import main.java.DAO.UsuarioDAO;
import main.java.domain.Usuario;
import main.java.util.ClinicaEntityManager;


public class UsuarioService {

	private UsuarioDAO dao;
    private ClinicaEntityManager cem;

    public UsuarioService(ClinicaEntityManager cem) {
        this.cem = cem;
        dao = new UsuarioDAO(this.cem.getEntityManager());
    }

    public void save(Usuario usuario) {
        try {
            cem.beginTransaction();
            dao.save(usuario);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void edit(Usuario medico) {
        try {
            cem.beginTransaction();
            dao.update(medico);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public void remove(Usuario usuario) {
        try {
            cem.beginTransaction();
            dao.delete(dao.getById(usuario.getIdUsuario()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } finally {
            if (cem != null) {
                cem.close();
            }
        }
    }

    public List<Usuario> findAll() {
        return dao.findAll();
    }
}