package com.everis.servicios.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.everis.servicios.bean.cfg.IEntityBanco;

@Table(name = "Movimiento")
@SuppressWarnings("serial")
@Entity
public class Movimiento implements IEntityBanco<Integer> {

	private Integer id;
	// TO DO fk
	private Integer idCuenta;
	private Date fechaOperacion;
	private Float cantidad;
	private String tipoOperacion;

	@Column(name = "idCuenta")
	// TO DO fk
	public Integer getIdCuenta() {
		return idCuenta;
	}

	// TO DO fk
	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	@Column(name = "fechaOperacion")
	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	@Column(name = "cantidad")
	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "tipoOperacion")
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

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

}
