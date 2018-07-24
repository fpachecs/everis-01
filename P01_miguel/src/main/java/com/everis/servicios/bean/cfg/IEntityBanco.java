package com.everis.servicios.bean.cfg;

import java.io.Serializable;

public interface IEntityBanco<K extends Serializable> extends Serializable, Cloneable {
	K getId();

	void setId(K K);
}
