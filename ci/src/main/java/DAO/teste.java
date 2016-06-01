package main.java.DAO;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.domain.Usuario;

public class teste {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

//		Usuario f1 = new Usuario();
//		f1.setTipoUsuario(1);
//		f1.setNome("Simone Santos Ferreira");
//		f1.setTelefone("(51)96953571");
//		f1.setLogin("ana");
//		f1.setSenha("123456");
//
//		UsuarioDAO aDAO = new UsuarioDAO();
//
//		try {
//			aDAO.salvar(f1); // cDAO.salvar(f2);
//
//			System.out.println("Clientes Salvos");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("oi" + e.getMessage());
//		}
		
		Usuario usuario = new Usuario();
		usuario.setTipoUsuario(1);
		usuario.setNome("Teste");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}

}
