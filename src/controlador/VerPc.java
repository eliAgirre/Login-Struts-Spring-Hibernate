package controlador;

import java.util.Map;

import modelo.Usuario;
import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerPc extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String codigoPc;
	private String micro;
	private String pantalla;
	
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
			
			codigoPc=usuario.getCodigoPc();
			micro=usuario.getMicro();
			pantalla=usuario.getPantalla();
			
			return "SUCCESS";
		}
	
	}
	
	// getters
	public String getCodigoPc(){
		return codigoPc;
	}
	public String getResultado() {
		return resultado;
	}
	public String getMicro() {
		return micro;
	}
	public String getPantalla() {
		return pantalla;
	}
	public String getNombreMicro(){
		
		String nombreMicro="";
		
		if(micro.equals("0")) nombreMicro="Intel";
		else if(micro.equals("1"))nombreMicro="Amd";
		
		return nombreMicro;
		
	}
	public String getSizePantalla(){
		
		String size="";
		
		if(pantalla.equals("0"))size="19'";
		else if(pantalla.equals("1"))size="21'";
		else if(pantalla.equals("2"))size="23'";
		
		return size;
	}

}