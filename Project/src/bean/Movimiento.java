package bean;

public class Movimiento implements IEntity<Integer> {
	
	private Integer id;
	private Integer idCuenta;
	private String fechaOperacion;
	private Float cantidad;
	private String tipoOperacion;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movimiento [id=");
		builder.append(id);
		builder.append(", idCuenta=");
		builder.append(idCuenta);
		builder.append(", fechaOperacion=");
		builder.append(fechaOperacion);
		builder.append(", cantidad=");
		builder.append(cantidad);
		builder.append(", tipoOperacion=");
		builder.append(tipoOperacion);
		builder.append("]");
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Movimiento(Integer id, Integer idCuenta, String fechaOperacion, Float cantidad, String tipoOperacion) {
		super();
		this.id = id;
		this.idCuenta = idCuenta;
		this.fechaOperacion = fechaOperacion;
		this.cantidad = cantidad;
		this.tipoOperacion = tipoOperacion;
	}

}
