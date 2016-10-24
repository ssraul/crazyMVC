<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Cliente</title>
</head>
<body>

<a href="lista"><input type="button" value="Listado Clientes"/></a>

	<h1>Nuevo Cliente</h1>
	<fieldset>
	<legend>Datos Cliente</legend>
	<c:if test="${(totalErrores >0)}">
		<ul>
		
		<c:forEach var="error" items="${listaErrores}">
		<li>
		Error: ${error.objectName} ${error.defaultMessage}
		</li>
		
		
		</c:forEach>
		</ul>
	
	
	</c:if>
		<form action="saveclient" method="post">
			<label>Nombre</label><input type="text" name="name" value=${nombre}>${pruebas}<br>
			<label>Apellido</label><input type="text" name="surname" value=${apellido}><br>
			<label>Email</label><input type="text" name="email"value=${email}><br>
			<input type="submit" value ="Enviar">
			<input type="reset" value ="Borrar">			
		</form>
		<div>${misDatos.nombre}</div>
	</fieldset>
	<h1>${validacion}</h1>
</body>
</html>