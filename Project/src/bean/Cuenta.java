package bean;

public class Cuenta implements IEntity<Integer> {
	
	private Integer id;
	private Integer idUser;
	private String numCuenta;
	private String nomBanco;
	private Float saldo;
	private String fechaDeAlta;

	public Cuenta(Integer id, Integer idUser, String numCuenta, String nomBanco, Float saldo, String fechaDeAlta) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.numCuenta = numCuenta;
		this.nomBanco = nomBanco;
		this.saldo = saldo;
		this.fechaDeAlta = fechaDeAlta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getNomBanco() {
		return nomBanco;
	}

	public void setNomBanco(String nomBanco) {
		this.nomBanco = nomBanco;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public String getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(String fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cuenta [id=");
		builder.append(id);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", numCuenta=");
		builder.append(numCuenta);
		builder.append(", nomBanco=");
		builder.append(nomBanco);
		builder.append(", saldo=");
		builder.append(saldo);
		builder.append(", fechaDeAlta=");
		builder.append(fechaDeAlta);
		builder.append("]");
		return builder.toString();
	}
	
	

}
