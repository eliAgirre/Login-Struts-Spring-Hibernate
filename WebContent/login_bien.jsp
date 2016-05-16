<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Perfil-<s:property value="#session.username"/></title>
</head>
<body>

	<h4><s:property value="resultado"/></h4>
	
	<ul>

		<!--se llama a struts.xml-->
		<li><a href="<s:url action='cargar_form_datosPersonales'/>">Agregar datos personales</a></li>
		<li><a href="<s:url action='editar_form_datosPersonales'/>">Modificar datos personales</a></li>
		<li><a href="<s:url action='ver_datosPersonales'/>">Ver datos personales</a></li>
		<li><a href="<s:url action='cargar_form_pc'/>">Agregar pc</a></li>
		<li><a href="<s:url action='buscar_form_pc'/>">Buscar pc</a></li>
		<li><a href="<s:url action='borrar_form_pc'/>">Borrar pc</a></li>
		<li><a href="<s:url action='ver_pc'/>">Ver pc</a></li>
			
  	</ul>

	<a href="<s:url action='Salir'/>"><s:text name="login.bien.salir"/></a>

</body>
</html>