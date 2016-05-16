package modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String codigoPc;
	private String password;
	private String nombre;
	private String email;
	private String dni;
	private String apellido;
	private String micro;
	private String pantalla;
	
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
	public String getDni() {
		return dni;
	}
	public String getApellido() {
		return apellido;
	}
	public String getMicro() {
		return micro;
	}
	public String getPantalla() {
		return pantalla;
	}
	// setters
	public void setUsername(String username) {
		this.username = username;
	}
	public void setCodigoPc(String codigo){
		this.codigoPc = codigo;
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
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setMicro(String micro) {
		this.micro = micro;
	}
	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	@Override
	public String toString() {
		
		return "Usuario => username: "+username+", password: "+password+", nombre: "+nombre+", email: "+email+", dni: "+dni
				+", apellido: "+apellido+", micro: "+micro+", pantalla: "+pantalla+", codigoPc: "+codigoPc;
	}

}
