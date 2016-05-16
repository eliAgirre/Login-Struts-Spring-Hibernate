package utilidades;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringUtil {
	
	private static WebApplicationContext context;
	 
	private static void iniciar(){
		
		try {
			
			context=WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
	    } 
	    catch (Throwable ex){ //Super clase de cualquier excepcion lanzable 
	    
            System.err.println("Fallo de inicializacion "+ex);
            throw new ExceptionInInitializerError(ex);
	    }
	 }

	 public static WebApplicationContext getWebApplicationContext() {
	 
	    iniciar();
        return context;
	 }
}