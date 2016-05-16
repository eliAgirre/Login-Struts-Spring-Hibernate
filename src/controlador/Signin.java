package controlador;

import java.util.Map;

import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import modelo.Usuario;
import utilidades.SpringUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Signin extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String codigoPc;
	private String password;
	private String nombre;
	private String email;
	
	private String resultado;	
	
	// business logic
	@SuppressWarnings({ "unchecked" })
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		Map<String,String> tmpSession=(Map<String,String>)ActionContext.getContext().getSession();
		
		Map<String,Usuario> usuarioSession=(Map<String,Usuario>)ActionContext.getContext().getSession();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario)context.getBean("usuarioID");
		Usuario usuarioBusq=(Usuario)context.getBean("usuarioID");
		
		tmpSession.put("user", getUsername());
		tmpSession.put("pass", getPassword());
		
		int iContador=0;
		usuarioBusq=operar.buscaMaxPc();
		if(usuario!=null){
			tmpSession.put("contador", usuarioBusq.getCodigoPc());
			iContador=Integer.parseInt(tmpSession.get("contador"));
		}
		else{
			iContador=0;
		}
		
		if(getUsername().equalsIgnoreCase(tmpSession.get("user")) && getPassword().equalsIgnoreCase(tmpSession.get("pass"))){
			
			iContador++;
			
			usuario.setUsername(getUsername());
			usuario.setCodigoPc(String.valueOf(iContador));
			usuario.setPassword(getPassword());
			usuario.setNombre(getNombre());
			usuario.setEmail(getEmail());
			
			usuarioSession.put("usuario", usuario); // se guarda en la sesion
			
			if(operar.grabarUno(usuario)){
				resultado="Usuario registrado";
				return "SUCCESS_BIEN";
			}
			else{
				resultado="Usuario no registrado";
				return "SUCCESS_MAL";
			}
					
		}
		else{
			
			resultado="No coinciden el usuario y la contraseña";
			return "SUCCESS_MAL";	
		}
	}

	// simple validation
	public void validate(){
		
		if(getUsername().length()==0){
			addFieldError("error_user", getText("login.user.requerido"));
		}
		if(getUsername().length()>10){
			addFieldError("error_user_maximo", getText("<font color='green'>El usuario debe ser menor de 10 caracteres</font>"));
		}
		if(getPassword().length()==0){
			addFieldError("errorpassword", getText("login.password.requerido"));
		}
		if(getNombre().length()==0){
			addFieldError("errornombre", getText("signin.nombre.requerido"));
		}
		if(getEmail().length()==0){
			addFieldError("erroremail", getText("signin.email.requerido"));
		}
		
	}

	// getters
	public String getUsername() {
		return username;
	}
	public String getCodigoPc(){
		return codigoPc;
	}
	public String getPassword() {
		return password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}
	public String getResultado() {
		return resultado;
	}

	// setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCodigoPc(String codigoPc){
		this.codigoPc = codigoPc;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}