package dao.payment.discounts;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.payment.discounts.ItemDiscount;
import dao.GenericDaoBean;

@Stateless
@Local(ItemDiscountDaoLocal.class)
public class ItemDiscountDaoBean extends GenericDaoBean<ItemDiscount, Integer> implements ItemDiscountDaoLocal {
	
}
