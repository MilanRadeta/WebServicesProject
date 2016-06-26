package dao.users;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.Manager;
import dao.GenericDaoBean;

@Stateless
@Local(ManagerDaoLocal.class)
public class ManagerDaoBean extends GenericDaoBean<Manager, Integer> implements ManagerDaoLocal {
	
}
