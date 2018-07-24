package com.everis.servicios.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.everis.servicios.bean.cfg.IEntityBanco;

@Table(name = "Cuenta")
@SuppressWarnings("serial")
@Entity
public class Cuenta implements IEntityBanco<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	// TO DO fk
	private Integer idUser;
	private String numCuenta;
	private String nomBanco;
	private Float saldo;
	private Date fechaDeAlta;

	@Column(name = "id")
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	@Column(name = "idUser")
	// TO DO fk
	public Integer getIdUser() {
		return idUser;
	}

	// TO DO fk
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "numCuenta")
	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	@Column(name = "nomBanco")
	public String getNomBanco() {
		return nomBanco;
	}

	public void setNomBanco(String nomBanco) {
		this.nomBanco = nomBanco;
	}

	@Column(name = "saldo")
	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	@Column(name = "fechaDeAlta")
	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
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
