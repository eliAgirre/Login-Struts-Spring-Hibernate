<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="index.titulo"/></title>
<style>
	.clase1 { background-color:white;font-size:10pt; }
</style>
<s:head/><%--Para que funcionen los estilos de cabecera--%>
</head>
<body onload="document.forms[0].userLoginID.focus();">

	<h4><s:text name="index.titulo"/></h4>

	<!--formulario struts-->
	<s:form action="accionLogin">
		
		<s:textfield name="usernameLogin" id="userLoginID" key="login.user" />
		<s:password name="passwordLogin" key="login.password" />
		
		
		<s:submit key="login.boton.submit" cssClass="clase1"/>
	
	</s:form>
	
	<!--<s:form action="accionSignin">
		
		<s:textfield name="username" key="login.user" />
		<s:password name="password" key="login.password" />
		<s:textfield name="nombre" key="signin.nombre" />
		<s:textfield name="email" key="signin.email" />
		
		<s:submit key="signin.boton.submit" />
		<s:reset key="signin.boton.reset" cssStyle="background-color:white;"/>
	
	</s:form>-->
	
	<%--Salida de errores--%>
	<s:fielderror>
		<s:param value="%{'error_user_maximo'}" />
		<s:param value="%{'error_user'}" />	
	</s:fielderror>
	
	<s:fielderror cssStyle="color:blue">
		<s:param>errorpassword</s:param>
	</s:fielderror>
	
	<s:fielderror cssStyle="color:purple">
		<s:param>errornombre</s:param>
	</s:fielderror>
	
	<s:fielderror cssStyle="color:orange">
		<s:param>erroremail</s:param>
	</s:fielderror>
	
</body>
</html>