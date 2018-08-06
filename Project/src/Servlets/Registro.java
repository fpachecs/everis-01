package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import capadatos.GestionUsuarioRegistro;

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
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Obtenemos los datos de registro.jsp
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String dni = request.getParameter("dni");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		//Obtenemos la sesión
		HttpSession sesion = request.getSession();

		synchronized (sesion) {
		
			GestionUsuarioRegistro gul = new GestionUsuarioRegistro();
			int comprobacion = gul.setUsuarioRegistro(username, password, dni, nombre, apellido);
				
			if (comprobacion == 1) {
				response.sendRedirect("registroExito.html");
			} else {
				response.sendRedirect("error.html");
			}
			
		}
	}

}