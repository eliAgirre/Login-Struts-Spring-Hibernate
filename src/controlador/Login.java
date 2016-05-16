package controlador;

import java.util.Map;

import negocio.OperarImp;

import org.springframework.web.context.WebApplicationContext;

import utilidades.SpringUtil;
import modelo.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String usernameLogin;
	private String passwordLogin;
	
	private String resultado;	
	
	// business logic
	@SuppressWarnings("unchecked")
	public String execute() {
		
		WebApplicationContext context=SpringUtil.getWebApplicationContext();
		
		Map<String,String> session=(Map<String,String>)ActionContext.getContext().getSession();
		
		OperarImp operar=(OperarImp) context.getBean("operarImpID");
		Usuario usuario=(Usuario) context.getBean("usuarioID");
		usuario=operar.buscarUno(getUsernameLogin());
		
		if(usuario==null){
			
			resultado="Usuario no existe";
			return "SUCCESS_MAL";	
		}
		else{
			if(getUsernameLogin().equalsIgnoreCase(usuario.getUsername()) && getPasswordLogin().equalsIgnoreCase(usuario.getPassword())){
				
				session.put("username", usuario.getUsername());
				resultado="Bienvenido "+session.get("username");
				return "SUCCESS_BIEN";		
			}
			else{
				resultado="Usuario no autorizado";
				return "SUCCESS_MAL";	
			}
		}
	}

	// simple validation
	public void validate(){
		
		if(getUsernameLogin().length()==0){
			addFieldError("error_user", getText("login.user.requerido"));
		}
		if(getUsernameLogin().length()>10){
			addFieldError("error_user_maximo", getText("<font color='green'>El usuario debe ser menor de 10 caracteres</font>"));
		}
		if(getPasswordLogin().length()==0){
			addFieldError("errorpassword", getText("login.password.requerido"));
		}
		
	}
	
	// getters
	public String getUsernameLogin() {
		return usernameLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}	
	public String getResultado() {
		return resultado;
	}

	// setters
	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
}