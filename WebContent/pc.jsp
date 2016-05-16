<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos PC</title>
</head>
<body>

	<h4>Datos PC</h4>
	
	<!--formulario struts-->
	<s:form action="accionDatosPc">
		
		Elija la micro:
		<s:radio id="rb" name="micro" list="#{'0':'Intel'}" />
		<s:radio id="rb" name="micro" list="#{'1':'Amd'}"/>
		
		<s:combobox label="Seleccione una opcion" name="pantalla" list="#{'0':'19', '1':'21', '2':'23'}" />
	
		<s:submit value="Enviar" />
	
	</s:form>
	
	<a href="<s:url action='accionVolver'/>">Volver</a>

</body>
</html>