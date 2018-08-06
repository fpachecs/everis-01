package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Cuenta;
import bean.Usuario;

public class GestionUsuario implements IGestion<Usuario, Integer> {

	private Connection conexion;

	public GestionUsuario() {
		conexion = getConexion();
	}

	public Connection getConexion() {
		Connection conexion = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/banco?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "admin");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}

	@Override
	public Usuario getBeanById(Integer id) {
		Usuario usuario = null;

		try {

			PreparedStatement ps = conexion.prepareStatement("select * from usuario where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new Usuario(
						rs.getInt("id"), 
						rs.getString("nombre"), 
						rs.getString("apellido"),
						rs.getString("dni"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public ArrayList<Cuenta> getCuentasUsuario (Integer id) {

		Cuenta cuenta = null;
		ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
		
		try {

			PreparedStatement ps = conexion.prepareStatement("select * from cuenta where idUser=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				cuenta = new Cuenta(
						rs.getInt("id"), 
						rs.getInt("idUser"), 
						rs.getString("numCuenta"),
						rs.getString("nomBanco"),
						rs.getFloat("saldo"),
						rs.getString("fechaDeAlta"));
				listaCuentas.add(cuenta);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCuentas;
		
	}

}
