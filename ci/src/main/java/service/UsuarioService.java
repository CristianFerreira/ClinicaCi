package main.java.service;

import java.sql.SQLException;
import java.util.List;

import main.java.DAO.UsuarioDAO;
import main.java.domain.PlanoDeSaude;
import main.java.domain.Usuario;
import main.java.util.ClinicaEntityManager;


public class UsuarioService {

	private UsuarioDAO usuarioDAO;
    private ClinicaEntityManager cem;

    public UsuarioService(ClinicaEntityManager cem) {
        this.cem = cem;
        usuarioDAO = new UsuarioDAO(this.cem.getEntityManager());
    }

    
    
    public List<Usuario> findAll() throws SQLException
	{
		try 
		{
			
			List<Usuario> lista = usuarioDAO.findAll();
			return lista;
		} catch (Exception e)
		{
			System.out.println("Não foi possivel buscar todos!");
			return null;
		}
	}
    
    public List<Usuario> find10() throws SQLException
   	{
   		try 
   		{
   			
   			List<Usuario> lista = usuarioDAO.find10();
   			return lista;
   		} catch (Exception e)
   		{
   			System.out.println("Não foi possivel buscar todos!");
   			return null;
   		}
   	}
    
    
    public List<Usuario> find30() throws SQLException
   	{
   		try 
   		{
   			
   			List<Usuario> lista = usuarioDAO.find30();
   			return lista;
   		} catch (Exception e)
   		{
   			System.out.println("Não foi possivel buscar todos!" + e.getMessage());
   			return null;
   		}
   	}
    
    
    public void saveSecretaria(Usuario usuario) {
        try {
        	usuario.setTipoUsuario(10);
            cem.beginTransaction();
            usuarioDAO.save(usuario);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } 
    }
    
    public void saveMedico(Usuario usuario) {
        try {
        	usuario.setTipoUsuario(30);
            cem.beginTransaction();
            usuarioDAO.save(usuario);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } 
    }

    public void edit(Usuario usuario) {
        try {
            cem.beginTransaction();
            usuarioDAO.update(usuario);
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } 
        
    }

    public void remove(Usuario usuario) {
        try {
            cem.beginTransaction();
            usuarioDAO.delete(usuarioDAO.getById(usuario.getIdUsuario()));
            cem.commit();
        } catch (Exception e) {
            cem.rollBack();
        } 
    }

    
}