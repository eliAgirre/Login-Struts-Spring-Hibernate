package negocio;

import modelo.Usuario;

public interface OperarService {

	public boolean grabarUno(Usuario u);
	public Usuario buscarUno(String clave);
	public boolean actualizarUno(Usuario u);
	public Usuario buscaPc(String codigoPc);
	public boolean borrarUnoPc(Usuario usuario);
	public Usuario buscaMaxPc();
	
}