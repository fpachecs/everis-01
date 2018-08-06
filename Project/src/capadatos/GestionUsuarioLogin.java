package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UsuarioLogin;

public class GestionUsuarioLogin implements IGestion<UsuarioLogin, Integer>{
	
	private Connection conexion;

	public GestionUsuarioLogin() {
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
	
	public UsuarioLogin getUsuarioLoginByCredenciales(String user, String pass) {
		UsuarioLogin usuariologin = null;

		try {

			PreparedStatement ps = conexion.prepareStatement("select * from usuariologin where user=? and pass=?");
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				usuariologin = new UsuarioLogin(
						rs.getInt("id"), 
						rs.getString("user"), 
						rs.getString("pass"),
						rs.getInt("idUser"),
						rs.getString("ultimoAcceso"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuariologin;
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
