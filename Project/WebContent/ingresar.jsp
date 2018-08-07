<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    session = "true" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="ISO-8859-1">
	<title>Movimientos</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
	<header>
		
		<div style="position:relative;bottom:20px;left:30px;" >
   			<img src="C:\Users\odepazch\git\everis-01\Project\images\logo_inversis.png" align="left">
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
	
	<div class="main">
		<p>Movimientos de la cuenta:</p>
		
		<form action="IngresarExtraer" method="post">
			<div class="opcionesRadio otraClase">
			
				<div class="tablaTitulo">
					<b><%= sesion.getAttribute("numCuenta") %></b>&nbsp; | &nbsp;<b><%= sesion.getAttribute("saldo") %></b> Euros
				</div>
				<br></br>
				<div class="TablaDato">
					Cantidad: <input type="number" name= "cant" value="1" min="1" required>
				</div>
				<br></br>
				
				<input class="botonMedio" name = "boton_ingreso" type="submit" value="Ingresar"/>
				
				<input class="botonMedio" type="button" value="Volver" 
				onClick="window.location.href='gestionCuenta.jsp'"/>
			</div>
		</form>
	</div>
	
</body>
</html>