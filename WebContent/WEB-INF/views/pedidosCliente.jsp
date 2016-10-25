<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedidos Cliente</title>
</head>
<body>
<h1>Pedidos Clientes</h1>

<h1>Cliente</h1>

<ul>
<li>${datoscliente.name}</li>
<li>${datoscliente.surname}</li>
<li>${datoscliente.email}</li>
</ul>
<!-- base href="${pageContext.request.contextPath}" 
<a href="${helpPath}" target="_blank">name</a>
-->


<h1>Listado de pedidos</h1> 
<a href="addOrders"><input type="button" value="Anadir Pedido +"/></a>

<table>
<tr>
<th>Codigo: </th>
<th>Nombre: </th>
<th>Email: </th>
<th>Fecha</th>

</tr>

<c:forEach var="listado" items="${listadopedidos}" >
<tr>

<td>${listado.id}</td>
<td>${listado.name}</td>
<td>${listado.email}</td>
<td>${listado.fecha}</td>
	
</tr>
</c:forEach>

</table>

</body>
</html>