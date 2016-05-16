<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="sigin.bien.titulo"/></title>
</head>
<body>

	<h4><s:property value="resultado"/></h4>
	
	<a href="<s:url action='Salir'/>"><s:text name="sigin.bien.volver"/></a>
	
</body>
</html>