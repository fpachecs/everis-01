package Services.com.ejemplo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.com.ejemplo.LoginDAO;
import model.com.ejemplo.Login;





@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO LoginDAO;
	@Override
	public Login get(int id) {
		// TODO Auto-generated method stub
		return LoginDAO.get(id);
	}

	@Override
	public Login get(String user) {
		// TODO Auto-generated method stub
		return LoginDAO.get(user);
	}

	@Override
	public Login get1(String pass) {
		// TODO Auto-generated method stub
		return LoginDAO.get(pass);
	}

}
