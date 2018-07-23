<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	<link href="css/bootstrap.css" rel="stylesheet" />
	<link href="css/estilos.css" rel="stylesheet" />
</head>
<body>
<SCRIPT  language=JavaScript> 
function validar(){
if (document.form.password.value=='mdiazfer' && document.form.login.value=='mdiazfer'){ 
	alert("Nombre de usuario y contraseña correctos.");
	window.location.href='Principal'; 
    } 
    else{ 
         alert("Porfavor ingrese, nombre de usuario y contraseña correctos."); 
    } 
} 
</SCRIPT> 
<div id="logear" name="logear">

<img id="logo" name="logo" alt="" src="https://www.comparativadebancos.com/wp-content/uploads/2012/04/banco-inversis.png">
<FORM name=form action="TU_PAGINA_WEB.HTML">

<INPUT type=text name="login" id="login" placeholder="Usuario"> <br>
<INPUT type=password name="password" id="password" placeholder="Password"> <br>
<INPUT onclick=validar() type=button value=Entrar name="entrar" id="entrar">

</FORM>

</div>
</body>
</html>
