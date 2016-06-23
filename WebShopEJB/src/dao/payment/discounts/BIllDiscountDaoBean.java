package dao.payment.discounts;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.payment.discounts.BillDiscount;
import dao.GenericDaoBean;

@Stateless
@Local(BillDiscountDaoLocal.class)
public class BIllDiscountDaoBean extends GenericDaoBean<BillDiscount, Integer> implements BillDiscountDaoLocal {
	
}
