package dao.users.buyers;

import java.util.List;

import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;
import dao.GenericDaoLocal;

public interface PaymentPointsBonusDaoLocal extends GenericDaoLocal<PaymentPointsBonus, Integer> {

	public List<PaymentPointsBonus> findByBuyerCategory(BuyerCategory buyerCategory);
	public List<PaymentPointsBonus> findByBuyerCategory(int id);
	
}
