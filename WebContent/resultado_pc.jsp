<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos - Pc</title>
</head>
<body>

	Codigo: <s:property value="codigoPc"/>
	<br>
	Micro: <s:property value="nombreMicro"/>
	<br>
	Pantalla: <s:property value="sizePantalla"/>
	<br>
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>