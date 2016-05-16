package controlador;

import modelo.Usuario;
import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class BuscarPc extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String codigoPc;
	private String micro;
	private String pantalla;
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
			
			resultado="Pc encontrado";
			codigoPc=usuario.getCodigoPc();
			micro=usuario.getMicro();
			pantalla=usuario.getPantalla();
			
		}
		
		return "SUCCESS";
	}

	// gettres
	
	public String getMicro(){
		return micro;
	}
	public String getCodigoPc() {
		return codigoPc;
	}
	public String getPantalla(){
		return pantalla;
	}
	public String getResultado() {
		return resultado;
	}

	public void setCodigoPc(String codigoPc) {
		this.codigoPc = codigoPc;
	}
	public String getNombreMicro(){
		
		String nombreMicro="";
		
		if(micro.equals("0")) nombreMicro="Intel";
		else nombreMicro="Amd";
		
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