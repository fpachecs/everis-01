package com.everis.servicios.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.everis.servicios.bean.cfg.IEntityBanco;

@Table(name = "UsuarioLogin")
@SuppressWarnings("serial")
@Entity
public class UsuarioLogin implements IEntityBanco<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String user;
	private String pass;
	// TO DO fk
	private Integer idUser;
	private Date ultimoAcceso;

	@Column(name = "id")
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	@Column(name = "user")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "pass")
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	@Column(name = "ultimoAcceso")
	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}

	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioLogin [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", ultimoAcceso=");
		builder.append(ultimoAcceso);
		builder.append("]");
		return builder.toString();
	}
}
