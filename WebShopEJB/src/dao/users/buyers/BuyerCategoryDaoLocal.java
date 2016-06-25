package dao.users.buyers;

import model.users.buyers.BuyerCategory;
import dao.GenericDaoLocal;

public interface BuyerCategoryDaoLocal extends GenericDaoLocal<BuyerCategory, Integer> {
	
	public BuyerCategory saveBuyerCategory(BuyerCategory buyerCategory);
	
}
