<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form action="saveclient" method="post">
			<label>Nombre</label><input type="text" name="name" ><br>
			<label>Apellido</label><input type="text" name="surname" ><br>
			<label>Email</label><input type="text" name="email"><br>
			<input type="submit" value ="Enviar">
			<input type="reset" value ="Borrar">			
		</form>
		<div>${misDatos.nombre}</div>
	</fieldset>
</body>
</html>