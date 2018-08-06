package bean;

import java.io.Serializable;

public interface IEntity<K extends Serializable> {
	
	K getId();
	void setId(K id);

}
