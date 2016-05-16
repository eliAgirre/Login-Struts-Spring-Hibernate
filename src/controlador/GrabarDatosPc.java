package controlador;

import java.util.List;
import java.util.Map;

import modelo.Usuario;
import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GrabarDatosPc extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private List<String> micro;
	private String pantalla;
	
	private String resultado;
	
	@SuppressWarnings("unchecked")
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		Map<String,String> session=(Map<String,String>)ActionContext.getContext().getSession();
		Map<String,String> tmpSession=(Map<String,String>)ActionContext.getContext().getSession();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario)context.getBean("usuarioID");
		Usuario usuarioBusq=(Usuario)context.getBean("usuarioID");
		
		String username=session.get("username");
		usuario=operar.buscarUno(username);
		
		String sMicro=getMicro().get(0); // se obtiene si es 0 o 1
		
		int iContador=0;
		usuarioBusq=operar.buscaMaxPc();
		if(usuario!=null){
			tmpSession.put("contador", usuarioBusq.getCodigoPc());
			iContador=Integer.parseInt(tmpSession.get("contador"));
		}
		else{
			iContador=0;
		}
		
		if(usuario.getUsername().equals(username)){
			
			iContador++;
			
			usuario.setUsername(usuario.getUsername());
			usuario.setCodigoPc(String.valueOf(iContador));
			usuario.setPassword(usuario.getPassword());
			usuario.setNombre(usuario.getNombre());
			usuario.setEmail(usuario.getEmail());
			usuario.setDni(usuario.getDni());
			usuario.setApellido(usuario.getApellido());
			usuario.setMicro(sMicro);
			usuario.setPantalla(getPantalla());
			
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
	public List<String> getMicro() {
		return micro;
	}
	public String getPantalla(){
		return pantalla;
	}
	public String getResultado() {
		return resultado;
	}
	
	// setters
	public void setMicro(List<String> micro) {
		this.micro = micro;
	}
	public void setPantalla(String pantalla){
		this.pantalla=pantalla;
	}

}
