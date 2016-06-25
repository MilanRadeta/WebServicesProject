package dao.users;

import model.users.User;
import dao.GenericDaoLocal;

public interface UserDaoLocal extends GenericDaoLocal<User, String> {
	
	public User findByUsername(String username);
	
}
