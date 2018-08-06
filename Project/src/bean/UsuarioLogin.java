package bean;

public class UsuarioLogin implements IEntity<Integer>{
	
	private Integer id;
	private String usuario;
	private String contraseña;
	private Integer idUser;
	private String fecha;
	
	
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public UsuarioLogin(Integer id, String usuario, String contraseña, Integer idUser, String fecha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.idUser = idUser;
		this.fecha = fecha;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public UsuarioLogin(Integer id, String usuario, String contraseña) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioLogin [id=");
		builder.append(id);
		builder.append(", usuario=");
		builder.append(usuario);
		builder.append(", contraseña=");
		builder.append(contraseña);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append("]");
		return builder.toString();
	}
	
}
