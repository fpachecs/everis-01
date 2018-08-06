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
import capadatos.GestionIngresarExtraer;

@SuppressWarnings("serial")
@WebServlet("/IngresarExtraer")
public class IngresarExtraer extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Definimos variables
		int cantidad = Integer.parseInt(request.getParameter("cant"));
		int contador = 0;
		String tipoOperacion;
		
		//Obtenemos la sesión y los atributos que necesitamos de ella
		HttpSession sesion = request.getSession();
		Object id = sesion.getAttribute("idCuentaMovimiento");
		Integer idCuenta = (Integer) id;
		@SuppressWarnings("unchecked")
		ArrayList<Cuenta> listaCuentas = (ArrayList<Cuenta>) sesion.getAttribute("listaCuentas");

		synchronized (sesion) {
			
			if (cantidad > 0) {
				tipoOperacion = "ingresar";
			} else {
				tipoOperacion = "extraer";
			}
			
			GestionIngresarExtraer gie = new GestionIngresarExtraer();
			float saldo = gie.IngresoExtraccion(idCuenta, cantidad, tipoOperacion);
			sesion.setAttribute("saldo", saldo);
			
			while(listaCuentas.get(contador).getId() != idCuenta) {
				contador++;
			}
			
			listaCuentas.get(contador).setSaldo(saldo);
			sesion.setAttribute("listaCuentas", listaCuentas);
			
			response.sendRedirect("operacionExito.jsp");
		}
	}

}
