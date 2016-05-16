package controlador;

import java.util.Map;

import modelo.Usuario;
import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerDatosPersonales extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	
	private String resultado;
	
	// business logic
	@SuppressWarnings("unchecked")
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		Map<String,String> session=(Map<String,String>)ActionContext.getContext().getSession();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario)context.getBean("usuarioID");
		
		String username=session.get("username");
		
		usuario=operar.buscarUno(username);
		
		if(usuario==null){ // Si el usuario no existe
			
			resultado="No existe la persona";
			return "NOSUCCESS";
		}
		else{
			
			resultado="Registro encontrado";
			
			dni=usuario.getDni();
			nombre=usuario.getNombre();
			apellido=usuario.getApellido();
			email=usuario.getEmail();
			
			session.put("dni", dni);
			session.put("nombre", nombre);
			session.put("apellido", apellido);
			session.put("email", email);
			
			return "SUCCESS";
		}
	
	}
	
	// getters
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getEmail() {
		return email;
	}
	public String getResultado() {
		return resultado;
	}

}