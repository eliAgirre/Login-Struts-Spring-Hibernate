package datos;

import utilidades.HibernateUtil;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Usuario;

public class DatosHibernate {
	
	private SessionFactory sessionFactory=null;
	
	private void abrirSessionFactory(){

		 try { 
			  sessionFactory=HibernateUtil.getSessionFactory();
		 }
		 catch (HibernateException e){
			 
		     System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + e); 		     
		 } 
	} // abrirSessionFactory
	
	private void cerrarSessionFactory(){
		sessionFactory.close();
	} // cerrarSessionFactory
	
	public boolean grabarUno(Usuario usuario){
		
		abrirSessionFactory();
		
		boolean resultado = false;
		
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		
		try{
			
			session.save(usuario);
			ts.commit(); 
			resultado=true;			
		}
		catch(HibernateException he) {
			ts.rollback();
			resultado=false;
		}
		finally{
			session.close();			
		}
		
		return resultado;
		
	}
	
	public Usuario buscaUnoClave(String clave) {
	
		abrirSessionFactory();
	
		Session session=sessionFactory.openSession();
		
		Usuario usuario=null;
		
		Query query=session.createQuery("from Usuario u where u.username = :username");
		query.setParameter("username", clave);
		
		// si la lista contiene más de 1
		if(query.list().size()>0){
			
			// devuelve el primer usuario que encuentre
			usuario=(Usuario) query.uniqueResult();
		}
	
		cerrarSessionFactory();
		
		return usuario;       

	} // buscarUnoClave
	
	public boolean actualizaUno(Usuario usuario) {
		
		abrirSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		boolean resultado=false;
		
		String username=usuario.getUsername();
		String codigoPc=usuario.getCodigoPc();
		String password=usuario.getPassword();
		String nombre=usuario.getNombre();
		String email=usuario.getEmail();
		String dni=usuario.getDni();
		String apellido=usuario.getApellido();
		String micro=usuario.getMicro();
		String pantalla=usuario.getPantalla();
		
		try{
	    	//session.update(usuario);
			Query query=session.createQuery("update Usuario u set u.codigoPc = :codigoPc, u.password = :password, u.nombre = :nombre, u.email = :email, u.dni = :dni, u.apellido = :apellido, u.micro = :micro, pantalla = :pantalla where u.username = :username");
			query.setParameter("username", username);
			query.setParameter("codigoPc", codigoPc);
			query.setParameter("password", password);
			query.setParameter("nombre", nombre);
			query.setParameter("email", email);
			query.setParameter("dni", dni);
			query.setParameter("apellido", apellido);
			query.setParameter("micro", micro);
			query.setParameter("pantalla", pantalla);
			int result=query.executeUpdate();
			
			if(result>0){
				ts.commit(); 
		        resultado=true;
			}
			else{
				resultado=false;
			}
			
	    }
	    catch (HibernateException he){ 
	    	ts.rollback();
	    	resultado=false;
	    }
	    finally { 
	        session.close(); 
	    }
		
		return resultado;
		
	} // actualizaUno
	
	public boolean borrarUnoPc(Usuario usuario) {
	
		abrirSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		boolean resultado=false;
		
		String username=usuario.getUsername();
		String codigoPc=usuario.getCodigoPc();
		String micro=usuario.getMicro();
		String pantalla=usuario.getPantalla();
		
		try{

			//session.update(usuario);
			Query query=session.createQuery("Update Usuario u set u.codigoPc = :codigoPc, u.micro = :micro, u.pantalla = :pantalla where u.username = :username");
			query.setParameter("username", username);
			query.setParameter("codigoPc", codigoPc);
			query.setParameter("micro", micro);
			query.setParameter("pantalla", pantalla);
			
			int result=query.executeUpdate();
			
			if(result>0){
				ts.commit(); 
		        resultado=true;
			}
			else{
				resultado=false;
			}
	    }
	    catch (HibernateException he){ 
	    	ts.rollback();
	    	resultado=false;
	    }
	    finally { 
	        session.close(); 
	    }
		
		return resultado;
		
	} // actualizaUno
	
	public Usuario buscaUnoPc(String codigoPc) { 
		
		abrirSessionFactory();

		Session session=sessionFactory.openSession();
		
		Usuario usuario=null;	
		
		Query query=session.createQuery("from Usuario u where u.codigoPc = :codigoPc");
		query.setParameter("codigoPc", codigoPc);	
		
		// si la lista contiene más de 1
		if(query.list().size()>0){
			
			// devuelve el primer usuario que encuentre
			usuario=(Usuario) query.uniqueResult();
		}
 
        session.close(); 
        return usuario;
        
	} // buscarUnoPc
	
	public Usuario buscaMaxPc() { 
		
		abrirSessionFactory();

		Session session=sessionFactory.openSession();
		
		Usuario usuario=null;
		
		Query query=session.createQuery("from Usuario u order by u.codigoPc desc");
		
		// si la lista contiene más de 1
		if(query.list().size()>0){
			
			// devuelve el primer usuario que encuentre
			usuario=(Usuario) query.setMaxResults(1).uniqueResult();
			
		}
 
        session.close(); 
        return usuario;
        
	} // buscarUnoPc
	
}
