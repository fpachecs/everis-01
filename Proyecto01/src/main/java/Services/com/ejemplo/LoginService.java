package Services.com.ejemplo;

import model.com.ejemplo.Login;

public interface LoginService {
	
	public Login get(int id);
	
	public Login get(String user);
	
	public Login get1(String pass);
}