package br.com.clinica.DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.clinica.domain.Paciente;
import br.com.clinica.domain.Usuario;

public class teste {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Usuario f1 = new Usuario();
		f1.setTipoUsuario(1);
		f1.setNome("Simone Santos Ferreira");
		f1.setTelefone("(51)96953571");
		f1.setLogin("ana");
		f1.setSenha("123456");

		UsuarioDAO aDAO = new UsuarioDAO();

		try {
			aDAO.salvar(f1); // cDAO.salvar(f2);

			System.out.println("Clientes Salvos");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("oi"+e.getMessage());
		}
	}
		  
		 
		
		  
		  

	

}
