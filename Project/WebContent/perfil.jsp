<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    session = "true" pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="ISO-8859-1">
	<title>Perfil</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<header>
		
		<div style="position:relative;bottom:20px;left:30px;" >
   			<img src="C:\Users\odepazch\git\everis-01\Project\images\logo_inversis.png" align="left">
		</div>
		
		<% HttpSession sesion = request.getSession();
		
		sesion.getAttribute("usuario");
		sesion.getAttribute("usuarioLogin");
		sesion.getAttribute("listaCuentas");%>

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
   			<input class="botonMedio" type="button" value="Salir >" 
			onClick="window.location.href='index.html'"/>
		</div>
	</header>
		
	<div class="main">
		<p>Tus datos:</p>	
			<form action="ModificarPerfil" method="post">
			<div class="opcionesRadio otraClase">
				<div class="tablaTitulo">
					<p>Nombre:</p>
				</div>
				<div class="tablaDato">
					<b><input type="text" name="nombre" value="${sessionScope.usuario.nombre}" pattern="[A-Za-zÁÉÍÓÚáéíóú ]*" oninvalid="setCustomValidity('Este campo no acepta números ni caracteres especiales')" onchange="try{setCustomValidity('')}catch(e){}" required></b>
				</div>
				<div class="tablaTitulo">
					<p>Apellido:</p>
				</div>
				<div class="tablaDato">
					<b><input type="text" name="apellido" value="${sessionScope.usuario.apellido}" pattern="[A-Za-zÁÉÍÓÚáéíóú ]*" oninvalid="setCustomValidity('Este campo no acepta números ni caracteres especiales')" onchange="try{setCustomValidity('')}catch(e){}" required></b>
				</div>
				<div class="tablaTitulo">
					<p>DNI:</p>
				</div>
				<div class="tablaDato">
				<b><input type="text" name="dni" value="${sessionScope.usuario.dni}" pattern="[0-9]{8}[A-Z]{1}" oninvalid="setCustomValidity('Este campo debe ser de la forma 00000000X')" onchange="try{setCustomValidity('')}catch(e){}" required></b>
				</div>
				<div class="tablaTitulo">
					<p>Último acceso:</p>
				</div>
				<div class="tablaDato">
					<b><c:out value="${sessionScope.usuarioLogin.fecha}"/></b>
				</div>
				<div class="tablaTitulo">
					<p>Cuentas asociadas:</p>
				</div>
				<div class="tablaDato">
					<select name="combolista">
						<c:forEach var="item" items="${sessionScope.listaCuentas}">
            	  		  	<option>${item.numCuenta}</option>
           				</c:forEach>
          	  		</select>
				</div>	

			<div>
			
				<input class="botonMedio" name= "boton_modificar" type="submit" value="Modificar" />
			
				<input class="botonMedio" type="button" value="Volver" 
				onClick="window.location.href='gestionCuenta.jsp'"/>
			</div>
		</div>
		</form>
	</div>
	
	<script src="js/functions.js"></script>	

</body>
</html>