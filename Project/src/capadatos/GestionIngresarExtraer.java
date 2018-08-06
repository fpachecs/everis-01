package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bean.Usuario;

public class GestionIngresarExtraer implements IGestion<Usuario, Integer> {
	
	private Connection conexion;
	int nuevaId;
	float sal;
	
	public GestionIngresarExtraer() {
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
	
	public float IngresoExtraccion (Integer idCuenta, Integer cantidad, String tipoOperacion) {
		
		try {
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now(); 

			PreparedStatement ps = conexion.prepareStatement("select max(id) from movimiento");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				nuevaId = rs.getInt("MAX(id)");
			}
			
			nuevaId += 1;
		
			PreparedStatement ps2 = conexion.prepareStatement("insert into movimiento values (" + nuevaId + ", " + idCuenta + ", '" + dtf.format(now) + "', " + cantidad + ", '" + tipoOperacion + "')");
			ps2.executeUpdate();
		
			PreparedStatement ps3 = conexion.prepareStatement("update cuenta set saldo = saldo + " + cantidad + " where id = " + idCuenta + ";");
			ps3.executeUpdate();
	
			PreparedStatement ps4 = conexion.prepareStatement("select saldo from cuenta where id = " + idCuenta);
			ResultSet rs2 = ps4.executeQuery();
			
			while (rs2.next()) {
				sal = (float) rs2.getInt("saldo");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sal;
		
	}

}
