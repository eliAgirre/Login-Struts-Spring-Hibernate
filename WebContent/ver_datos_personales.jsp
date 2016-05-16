<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos personales</title>
</head>
<body>

	Dni: <s:property value="dni"/>
	<br>
	Nombre: <s:property value="nombre"/>
	<br>
	Apellido: <s:property value="apellido"/>
	<br>
	Email: <s:property value="email"/>
	<br>
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>