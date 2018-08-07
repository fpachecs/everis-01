<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    session = "true" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="ISO-8859-1">
	<title>Gestion Cuentas</title>
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
			<form action="OperacionesCuenta" method="post">
				<select name="item" onchange="this.form.submit()">
						<option>Operaciones</option>
						<option value="VerMovimientos">Ver Movimientos</option>	
            			<option value="Ingresar">Ingresar</option>
           				<option value="Extraer">Extraer</option>
        		</select>
       	 	</form>
		</div>
		
		<div style="position:relative;bottom:0px;top:10px;">
			<input class="botonMedio" type="button" value="Ver Perfil" 
			onClick="window.location.href='perfil.jsp'"/>
				
   			<input class="botonMedio" type="button" value="Salir >" 
			onClick="window.location.href='index.html'"/>
		</div>
		
	</header>
	
	<%	sesion.getAttribute("numCuenta");
		sesion.getAttribute("saldo"); %>
	
	<div class="main">
		<p>Información de cuenta:</p>	
		
		<div class="tablaTitulo">
			<p>Cuenta:</p>
		</div>
		<div class="tablaDato">
			<b>${numCuenta}</b>
		</div>
		<div class="tablaTitulo">
			<p>Saldo:</p>
		</div>
		<div class="tablaDato">
			<b>${saldo}</b>
		</div>
		<div>
			<input class="botonMedio" type="submit" value="Volver" 
			onClick="window.location.href='pantallaPrincipal.jsp'"/>
		</div>
	</div>

</body>
</html>