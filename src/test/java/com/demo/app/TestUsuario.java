package com.demo.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.app.dao.UsuarioDAO;
import com.demo.app.usuario.Usuario;

import util.HibernateUtils;


public class TestUsuario {
	
	//private static SessionFactory sessionFactory;
	
	private static Session session;
	
	public static void main(String[]args) 
	{
		//sessionFactory= HibernateUtils.getSessionFactory();
		session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		//Usuario us = new Usuario("Alberto", "gratis", "morfina666@gmail.com", "paloma",
				//"Gutierrez");

		//UsuarioDAO.crearUsuario(us);
		
		//System.out.println(us.getNombreUsuario());
		
		

		
		
		//Usuario u =manager.find(Usuario.class, 26);
		//u.setNombreUsuario("elmasPija");

			Usuario u = session.find(Usuario.class, 27);
			session.remove(u);



		
		//imprimirTodo();
		
		//System.out.println(UsuarioDAO.validar("Rupuerto", "cacona"));
		
		tx.commit();
		session.close();
		System.exit(0);
	
	}
	public static void crearUsuario(int id,String nombreusuario, String contrasenia, String correo, String nombre,
			String apellido) {
		Usuario us = new Usuario(id,nombreusuario, contrasenia, correo, nombre,
				apellido);
		session.save(us);
		
	}
}
