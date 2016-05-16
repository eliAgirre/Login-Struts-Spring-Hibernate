package utilidades;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	    
    private static final SessionFactory sessionFactory;
    
    static {
    	
        try {

        	sessionFactory = new Configuration().configure("/conf/hibernate.cfg.xml").buildSessionFactory();
        } 
        //sessionFactory necesita para terminar de inicilizarse lanzar la excepcion
        catch (Throwable ex){ //Super clase de cualquier excepcion lanzable 
        
            System.err.println("Fallo de inicializacion" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}