package dao.users.buyers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;
import dao.GenericDaoBean;

@Stateless
@Local(BuyerCategoryDaoLocal.class)
public class BuyerCategoryDaoBean extends GenericDaoBean<BuyerCategory, Integer> implements BuyerCategoryDaoLocal {

	@EJB
	private PaymentPointsBonusDaoLocal pointsDao;
	
	@Override
	public BuyerCategory saveBuyerCategory(BuyerCategory category) {
		BuyerCategory dbCategory = findById(category.getId());
		if (dbCategory != null) {
			List<PaymentPointsBonus> dbBonuses = pointsDao.findByBuyerCategory(dbCategory);
			for (PaymentPointsBonus bonus : category.getPaymentPointsBonuses()) {
				bonus.setBuyerCategory(dbCategory);
				if (!dbBonuses.contains(bonus)) {
					dbCategory.getPaymentPointsBonuses().add(bonus);
					pointsDao.persist(bonus);
				}
				else {
					pointsDao.merge(bonus);
				}
			}
			for (PaymentPointsBonus bonus : dbBonuses) {
				if (!category.getPaymentPointsBonuses().contains(bonus)) {
					dbCategory.getPaymentPointsBonuses().remove(bonus);
					pointsDao.remove(bonus);
				}
			}
			return merge(dbCategory);
		}
		return null;
	}
	
}
