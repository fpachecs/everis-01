package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bean.UsuarioLogin;

public class GestionUsuarioRegistro implements IGestion<UsuarioLogin, Integer> {

	private Connection conexion;
	private int nuevaId;
	int comprobar;

	public GestionUsuarioRegistro() {
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
	
	public int setUsuarioRegistro(String user, String pass, String dni, String nombre, String apellido) {

		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 

			PreparedStatement ps = conexion.prepareStatement("select max(id) from usuariologin");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nuevaId = rs.getInt("MAX(id)");
			}
			
			nuevaId += 1;
			
			PreparedStatement ps2 = conexion.prepareStatement("insert into usuario values (" + nuevaId + ", '" + nombre + "', '" + apellido + "', '" + dni + "')");
			ps2.executeUpdate();
			
			PreparedStatement ps3 = conexion.prepareStatement("insert into usuariologin values (" + nuevaId + ", '" + user + "', '" + pass + "', " + nuevaId + ", '" + dtf.format(now) + "')");
			ps3.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 1;
	}

	@Override
	public UsuarioLogin getBeanById(Integer id) {
		UsuarioLogin usuario = null;

		try {

			PreparedStatement ps = conexion.prepareStatement("select * from usuariologin where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuario = new UsuarioLogin(
						rs.getInt("id"), 
						rs.getString("user"), 
						rs.getString("pass"),
						rs.getInt("idUser"),
						rs.getString("ultimoAcceso"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
}
