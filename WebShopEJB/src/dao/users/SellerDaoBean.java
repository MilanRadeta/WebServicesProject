package dao.users;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.Seller;
import dao.GenericDaoBean;

@Stateless
@Local(SellerDaoLocal.class)
public class SellerDaoBean extends GenericDaoBean<Seller, Integer> implements SellerDaoLocal {
	
}
