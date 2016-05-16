package controlador;

import modelo.Usuario;
import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import utilidades.SpringUtil;

public class BorrarPc extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String codigoPc;
	private String resultado;
	
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario)context.getBean("usuarioID");
		
		usuario=operar.buscaPc(getCodigoPc());
		
		if(usuario==null){
			
			resultado="No existe el Pc con ese codigo";
			return "NOSUCCESS";
		}
		else{
			
			usuario.setUsername(usuario.getUsername());
			usuario.setCodigoPc(usuario.getCodigoPc());
			usuario.setPassword(usuario.getPassword());
			usuario.setNombre(usuario.getNombre());
			usuario.setEmail(usuario.getEmail());
			usuario.setDni(usuario.getDni());
			usuario.setApellido(usuario.getApellido());
			usuario.setMicro("NULL");
			usuario.setPantalla("NULL");
			
			if(operar.borrarUnoPc(usuario)){
				
				resultado="Pc borrado";
				return "SUCCESS";
			}
			else{
				resultado="Pc no borrado";
				return "SUCCESS";
			}
		}
		
		
	}

	// gettres
	public String getCodigoPc() {
		return codigoPc;
	}
	public String getResultado() {
		return resultado;
	}
	
	// setters
	public void setCodigoPc(String codigoPc) {
		this.codigoPc = codigoPc;
	}
	
}