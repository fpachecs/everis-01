package capadatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Movimiento;
import bean.Usuario;

public class GestionMovimientos implements IGestion<Usuario, Integer> {
	
	private Connection conexion;

	public GestionMovimientos() {
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
	
	public ArrayList<Movimiento> getMovimientosCuenta(Integer id) {
		
		Movimiento movimiento = null;
		ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
		
		try {

			PreparedStatement ps = conexion.prepareStatement("select * from movimiento where idCuenta=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				movimiento = new Movimiento(
						rs.getInt("id"),
						rs.getInt("idCuenta"),
						rs.getString("fechaOperacion"), 
						rs.getFloat("cantidad"),
						rs.getString("tipoOperacion"));
				listaMovimientos.add(movimiento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaMovimientos;
		
	}
	

}
