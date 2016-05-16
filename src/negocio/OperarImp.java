package negocio;

import datos.DatosHibernate;
import modelo.Usuario;

public class OperarImp implements OperarService {
	
	private DatosHibernate datosHibernate;
	
	public DatosHibernate getDatosHibernate() {
		return datosHibernate;
	}

	public void setDatosHibernate(DatosHibernate datosHibernate) {
		this.datosHibernate = datosHibernate;
	}
	
	public OperarImp(){}

	@Override
	public boolean grabarUno(Usuario u) {
		return datosHibernate.grabarUno(u);
	}

	@Override
	public Usuario buscarUno(String clave) {
		
		Usuario usuario=datosHibernate.buscaUnoClave(clave);
		
		return usuario;
	}
	
	@Override
	public boolean actualizarUno(Usuario u) {
		return datosHibernate.actualizaUno(u);
	}

	@Override
	public Usuario buscaPc(String codigoPc) {
		return datosHibernate.buscaUnoPc(codigoPc);
	}

	@Override
	public boolean borrarUnoPc(Usuario usuario) {
		return datosHibernate.borrarUnoPc(usuario);
	}

	@Override
	public Usuario buscaMaxPc() {
		return datosHibernate.buscaMaxPc();
	}

}
