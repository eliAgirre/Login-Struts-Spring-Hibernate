<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar datos</title>
</head>
<body>

	<h4>Modificar datos</h4>
	
	<!--formulario struts-->
	<s:form action="accionEditarDatos">

		<s:textfield name="dni" key="Dni" value="%{#session.dni}"/>
		<s:textfield name="nombre" key="Nombre" value="%{#session.nombre}"/>
		<s:textfield name="apellido" key="Apellido" value="%{#session.apellido}"/>
		<s:textfield name="email" key="Email" value="%{#session.email}"/>
	
		<s:submit value="Enviar" />
	
	</s:form>
	
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>