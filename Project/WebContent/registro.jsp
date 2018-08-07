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
		<img alt="icono" src="C:\Users\odepazch\git\everis-01\Project\images\logo_inversis.png" align="middle">
	</header>
	
	<div class="main">
		<p>Introduce tus datos para el registro:</p>	
		
		<form action="Registro" method="post">
			<div class="opcionesRadio otraClase">
	
				<span class="edit">Nombre</span>
				<input type="text"	name="nombre" pattern="[A-Za-zÁÉÍÓÚáéíóú ]*" required/>
					
				<br/><br/>
				<span class="edit">Apellido</span>
				<input type="text"	name="apellido" pattern="[A-Za-zÁÉÍÓÚáéíóú ]*" required/>
					
				<br/><br/>
				<span class="edit">DNI</span>
				<input type="text"	name="dni" pattern="[0-9]{8}[A-Z]{1}" required/>
					
				<br/><br/>
				<span class="edit">User</span>
				<input type="text" name="uname" pattern="[A-Za-z0-9]*" required/>
					
				<br/><br/>
				<span class="edit">Pass</span>
				<input type="password"	name="pass" required/>	
			</div>
			
			<div class="formFooter">
				<input class="botonLargo" name= "boton_registro" type="submit" value="Registrar"/>
				
				<input class="botonLargo" name = "boton_volver" type="button" value="Volver"
				onClick="window.location.href='index.html'"/>
			</div>
		</form>
	</div>
	
	<script src="js/functions.js"></script>

</body>
</html>