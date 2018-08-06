package capadatos;

import java.io.Serializable;

import bean.IEntity;

public interface IGestion<E extends IEntity<K>, K extends Serializable> {
	
	E getBeanById(K id);

}
