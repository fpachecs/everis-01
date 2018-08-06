package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Usuario;

public class GestionModificarPerfil implements IGestion<Usuario, Integer> {
	
	private Connection conexion;

	public GestionModificarPerfil() {
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
	
	public void setNuevosDatosPerfil (Integer id, String nombre, String apellido, String dni) {
		
		try {

			PreparedStatement ps = conexion.prepareStatement("update usuario set nombre ='" + nombre + "', apellido = '" + apellido + "', dni = '" + dni + "' where id = " + id + ";");

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
