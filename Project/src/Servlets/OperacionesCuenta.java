package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Movimiento;
import capadatos.GestionMovimientos;


@SuppressWarnings("serial")
@WebServlet("/OperacionesCuenta")
public class OperacionesCuenta extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Obtenemos el parámetro del combobox
		String opcion = request.getParameter("item");

		//Obtenemos la sesión y los datos que necesitamos de ella
		HttpSession sesion = request.getSession();
		Object idCuenta = sesion.getAttribute("idCuentaMovimiento");
		Integer idC = (Integer) idCuenta;

		synchronized (sesion) {
			
			ArrayList<Movimiento> listaMovimientos = new ArrayList<>();
			GestionMovimientos gm = new GestionMovimientos();
			listaMovimientos = gm.getMovimientosCuenta(idC);
			
			sesion.setAttribute("listaMovimientos", listaMovimientos);
			
			if (opcion.equals("VerMovimientos") && listaMovimientos.isEmpty()) {
				
				response.sendRedirect("noHayMovimientos.jsp");
				
			} else if (opcion.equals("Ingresar")) {
				
				response.sendRedirect("ingresar.jsp");
				
			} else if (opcion.equals("Extraer")) {
				
				response.sendRedirect("extraer.jsp");
				
			} else {
				
				response.sendRedirect("verMovimientos.jsp");
				
			}
			
		}
	}

}
