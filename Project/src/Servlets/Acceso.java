package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cuenta;
import bean.Usuario;
import bean.UsuarioLogin;
import capadatos.GestionUsuario;
import capadatos.GestionUsuarioLogin;

/**
 * Servlet que inicializa dos variables a nivel de aplicaci�n y las actualiza.
 * Por otro lado, el cont�o de los votos se hace mediante el env�o de un
 * atributo de petici�n, el cu�l puede contener un voto u otro.
 * <p>
 * Enviamos respuesta a cliente para evitarnos el configurar el navegador. Si no
 * enviamos respuesta al cliente, puede que los resultado no se actualicen.
 * 
 * @author fips
 * 
 */
@SuppressWarnings("serial")
@WebServlet("/Acceso")
public class Acceso extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Obtenemos nombre de usuario y contraseña de index.html
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		//Obtenemos la sesión
		HttpSession sesion = request.getSession();

		synchronized (sesion) {
			
			GestionUsuarioLogin gul = new GestionUsuarioLogin();
			UsuarioLogin uslog = gul.getUsuarioLoginByCredenciales(username, password);
			ArrayList<Cuenta> cuentasUsuario = new ArrayList<>();
			
			
			if (uslog != null) { //Si los datos del login coinciden con alguno en BBDD
				
				GestionUsuario gu = new GestionUsuario();
				Usuario us = gu.getBeanById(uslog.getIdUser());
				
				cuentasUsuario = gu.getCuentasUsuario(uslog.getIdUser());
				
				sesion.setAttribute("usuarioLogin", uslog);
				sesion.setAttribute("usuario", us);
				sesion.setAttribute("listaCuentas", cuentasUsuario);
				
				response.sendRedirect("pantallaPrincipal.jsp");	
			
			} else { //Si no coinciden
				response.sendRedirect("error.html");
			}
		}
	}
}
