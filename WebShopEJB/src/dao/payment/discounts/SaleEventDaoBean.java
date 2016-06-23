package dao.payment.discounts;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.payment.discounts.SaleEvent;
import dao.GenericDaoBean;

@Stateless
@Local(SaleEventDaoLocal.class)
public class SaleEventDaoBean extends GenericDaoBean<SaleEvent, Integer> implements SaleEventDaoLocal {
	
}
