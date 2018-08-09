<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    session = "true" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.ArrayList" %>
<%@page import="bean.Cuenta" %>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="ISO-8859-1">
	<title>Pantalla Principal</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
	<header>
		
		<div style="position:relative;bottom:20px;left:30px;" >
   			<a href="pantallaPrincipal.jsp"><img src="C:\Users\odepazch\git\everis-01\Project\images\logo_inversis.png" align="left"></a>
		</div>
		
		<% HttpSession sesion = request.getSession();
		
		sesion.getAttribute("usuario"); %>

		<span style="font-size: 12px; line-height: 18px;">
  		Bienvenido, <b><c:out value="${sessionScope.usuario.nombre}"/></b><b>
  		<c:out value="${sessionScope.usuario.apellido}"/></b><br></span>

		<div style="position:relative;bottom:0px;top:10px;">
   			<input class="botonMedio" type="button" value="Salir >" 
			onClick="window.location.href='index.html'"/>
		</div>
		
	</header>
	
	<div class="main">
		<p>Tus cuentas:</p>	
	
		<div class="opcionesRadio otraClase">
		
			<% 	@SuppressWarnings("unchecked")
				ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>)sesion.getAttribute("listaCuentas"); 
			
				for (int i = 0; i < listaCuentas.size(); i++) {
						
					String aux = listaCuentas.get(i).getNumCuenta();
					String aux2 = "numCuenta" + aux;
					String aux3 = "saldo" + aux;
					String aux4 = "idCuentaMovimiento" + aux;
					sesion.setAttribute(aux2, listaCuentas.get(i).getNumCuenta());
					sesion.setAttribute(aux3, listaCuentas.get(i).getSaldo());
					sesion.setAttribute(aux4, listaCuentas.get(i).getId());
				}
			
			%>
				
				<c:forEach var="item" items="${sessionScope.listaCuentas}">

					<div class="tablaTitulo">
						<a href = "gestionCuenta.jsp?nc=${item.numCuenta}"> <b>${item.numCuenta}</b></a>&nbsp; | &nbsp;<b>${item.saldo}</b> Euros
					</div>
					<br></br>
				</c:forEach>
		</div>	
	</div>
</body>
</html>