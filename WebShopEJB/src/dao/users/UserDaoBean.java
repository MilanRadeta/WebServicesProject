package dao.users;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.User;
import dao.GenericDaoBean;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<User, Integer> implements UserDaoLocal {
	
}
