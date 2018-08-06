package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Usuario;
import bean.UsuarioLogin;
import capadatos.GestionModificarPerfil;


@SuppressWarnings("serial")
@WebServlet("/ModificarPerfil")
public class ModificarPerfil extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Obtenemos los parámetros de perfil.jsp
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		
		//Obtenemos la sesión y los atributos que necesitamos de ella
		HttpSession sesion = request.getSession();
		UsuarioLogin uslog = (UsuarioLogin) sesion.getAttribute("usuarioLogin");
		Usuario us = (Usuario) sesion.getAttribute("usuario");

		synchronized (sesion) {
			
			GestionModificarPerfil gmp = new GestionModificarPerfil();
			gmp.setNuevosDatosPerfil(uslog.getId(), nombre, apellido, dni);
			
			us = new Usuario (us.getId(), nombre, apellido, dni);
			
			sesion.setAttribute("usuario", us);
			
			response.sendRedirect("perfil.jsp");
			
		}
	}

}
