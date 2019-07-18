package com.demo.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.app.usuario.Usuario;

import util.HibernateUtils;


public class UsuarioDAO {
	
	private static SessionFactory sessionFactory;
	
	private static Session session;
	
	public static void crearUsuario(Usuario us) {
		session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Usuario>usuarios= session.createQuery("FROM Usuario").getResultList();
		int largo =usuarios.size();
		System.out.println(largo);
		us.setIdUsuario(largo+1);
		session.save(us);
		tx.commit();
		session.close();
	}
	public static void editar(Usuario usuario) {
		Transaction tx = session.beginTransaction();
		Usuario u = session.find(Usuario.class, usuario.getIdUsuario());
		u.setApellido(usuario.getApellido());
		u.setNombre(usuario.getNombre());
		u.setCorreo(usuario.getCorreo());
		u.setContrasenia(usuario.getContrasenia());
		u.setNombreUsuario(usuario.getNombreUsuario());
		
		tx.commit();
		session.close();
	
	}
	
	public static void eliminar(int id) {
		Usuario u = session.find(Usuario.class, id);
		Transaction tx = session.beginTransaction();
		session.remove(u);
		tx.commit();
		session.close();	
	}
	
	public static boolean validar(String usuario, String contrasenia) {
		session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Usuario>usuarios= session.createQuery("FROM Usuario").getResultList();
			
			for (Usuario us:usuarios) {
				if(us.getNombreUsuario().equals(usuario)) {
					if(us.getContrasenia().equals(contrasenia))
					return true;
				}
			}
			return false;
	}
	
}
