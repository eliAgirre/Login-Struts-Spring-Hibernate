<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos personales</title>
</head>
<body>

	<h4>Datos personales</h4>
	
	<!--formulario struts-->
	<s:form action="accionDatosPersonales">
	
		<s:textfield name="dni" id="dniID" key="Dni" />
		<s:textfield name="apellido" id="apellidoID" key="Apellido" />
	
		<s:submit value="Enviar" />
	
	</s:form>
	
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>