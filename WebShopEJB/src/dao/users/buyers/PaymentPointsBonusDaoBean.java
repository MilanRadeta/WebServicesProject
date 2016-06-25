package dao.users.buyers;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;
import dao.GenericDaoBean;

@Stateless
@Local(PaymentPointsBonusDaoLocal.class)
public class PaymentPointsBonusDaoBean extends GenericDaoBean<PaymentPointsBonus, Integer> implements PaymentPointsBonusDaoLocal {

	@Override
	public List<PaymentPointsBonus> findByBuyerCategory(
			BuyerCategory buyerCategory) {
		return findByBuyerCategory(buyerCategory.getId());
	}

	@Override
	public List<PaymentPointsBonus> findByBuyerCategory(int id) {
		Query query = em.createNamedQuery("findBonusByBuyerCategory");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<PaymentPointsBonus> results = query.getResultList();
		return results;
	}
	
	
	
}
