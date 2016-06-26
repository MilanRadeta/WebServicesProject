package dao.users;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import model.users.User;
import dao.GenericDaoBean;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<User, Integer> implements UserDaoLocal {

	@Override
	public User findByUsername(String username) {
		Query query = em.createNamedQuery("findUserByUsername");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<User> results = query.getResultList();
		if (results != null && results.size() == 1) {
			return results.get(0);
		}
		return null;
	}
	
	
	
}
