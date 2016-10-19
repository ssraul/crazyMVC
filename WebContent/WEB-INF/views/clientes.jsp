<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listado de clientes</h1>


<a href="nuevoCliente"><input type="button" value="Nuevo+"/></a>


<table>
<tr>
<th>Nombre: </th>
<th>Apellido: </th>
<th>Email: </th>
<th>Eliminar</th>
</tr>

<c:forEach var="cliente" items="${listadoClientes}" >
<tr>

	<td><a href="client/${cliente.email}/">${cliente.name}</a></td><!-- paso como path variable -->
	<td><a href="client?email=${cliente.email}">${cliente.surname}</a></td>
	<td><a href="client?email=${cliente.email}">${cliente.email}</a></td>
	<td><a href="borrarcliente?email=${cliente.email}">X</a></td>
	
	
</tr>
</c:forEach>
</table>

</body>
</html>