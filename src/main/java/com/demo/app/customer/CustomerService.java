package com.demo.app.customer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.app.usuario.Usuario;

import util.HibernateUtils;


@Service
public class CustomerService {
	
	private static Session session;
	
	
	public List<Usuario> listAll(){
		session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Usuario>usuarios= session.createQuery("FROM Usuario").getResultList();
		tx.commit();
		session.close();
		return usuarios;
		
	}

	
	public void save(Usuario usuario) {
		session = HibernateUtils.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Usuario>usuarios= session.createQuery("FROM Usuario").getResultList();
		
		if(usuarios.isEmpty()) {
			usuario.setIdUsuario(1);
			session.save(usuario);
		}else {
				int largo =usuarios.size();
				usuario.setIdUsuario(largo+1);
				
				session.save(usuario);
		}


		tx.commit();
		session.close();
	}
	
	public boolean duplicado(String email,List<Usuario>usuarios) {
		
		session = HibernateUtils.getSessionFactory().openSession();
		
		for (Usuario us:usuarios) {
			if(us.getCorreo().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public static Usuario validar(String usuario, String contrasenia) {
		session = HibernateUtils.getSessionFactory().openSession();
			
			@SuppressWarnings("unchecked")
			List<Usuario>usuarios= session.createQuery("FROM Usuario").getResultList();
			
			for (Usuario us:usuarios) {
				if(us.getNombreUsuario().equals(usuario)) {
					if(us.getContrasenia().equals(contrasenia))
					return us;
				}
			}
			return null;
	}
	
	
}
