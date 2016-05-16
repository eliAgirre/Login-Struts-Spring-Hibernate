<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar - Pc</title>
</head>
<body>

	<s:form action="accionBuscarPc">
	     
		<s:textfield name="codigoPc" key="Codigo a buscar"/>
		<s:submit value="Aceptar"/>
	</s:form>
	
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>