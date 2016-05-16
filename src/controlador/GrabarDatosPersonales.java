package controlador;

import java.util.Map;

import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import modelo.Usuario;
import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GrabarDatosPersonales extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String dni;
	private String apellido;
	
	private String resultado;	
	
	// business logic
	@SuppressWarnings({ "unchecked" })
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		Map<String,String> session=(Map<String,String>)ActionContext.getContext().getSession();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario)context.getBean("usuarioID");
		
		String username=session.get("username");
		
		usuario=operar.buscarUno(session.get("username"));
		
		if(usuario.getUsername().equals(username)){
			
			usuario.setUsername(username);
			usuario.setPassword(usuario.getPassword());
			usuario.setNombre(usuario.getNombre());
			usuario.setEmail(usuario.getEmail());
			usuario.setDni(getDni());
			usuario.setApellido(getApellido());
			
			if(operar.actualizarUno(usuario)){
				resultado="Registro actualizado";
			}
			else{
				resultado="Registro no se ha actualizado";
			}

		}
		else{
			resultado="El usuario no coincide";
		}
		
		return "SUCCESS";
	}
	
	// getters
	public String getDni() {
		return dni;
	}
	public String getApellido() {
		return apellido;
	}
	public String getResultado() {
		return resultado;
	}

	// setters
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
		
}