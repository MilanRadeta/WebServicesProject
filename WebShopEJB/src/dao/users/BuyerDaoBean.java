package dao.users;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.Buyer;
import dao.GenericDaoBean;

@Stateless
@Local(BuyerDaoLocal.class)
public class BuyerDaoBean extends GenericDaoBean<Buyer, String> implements BuyerDaoLocal {
	
}
