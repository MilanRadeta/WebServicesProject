package dao.users.buyers;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.buyers.BuyerCategory;
import dao.GenericDaoBean;

@Stateless
@Local(BuyerCategoryDaoLocal.class)
public class BuyerCategoryDaoBean extends GenericDaoBean<BuyerCategory, Integer> implements BuyerCategoryDaoLocal {
	
}
