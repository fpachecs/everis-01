package dao.com.ejemplo;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.com.ejemplo.Login;

public class LoginDAOImpl implements LoginDAO {


	@Autowired
	private SessionFactory sessionFactory;

	public LoginDAOImpl() {
		
	}
	
	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public Login get(int id) {
		//recordar en el from poner la clase
		id = 5;
				String hql = "from Super where id=" + id;
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
	return null;
	}
	
	
		
	
	@Override
	public Login get(String user) {
		user= "mdiazfer";
		String hql = "from Super where user=" + user;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return null;
	}

	@Override
	public Login get1(String pass) {
		pass= "mdiazfer";
		String hql = "from Super where pass=" + pass;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return null;
	}
}
