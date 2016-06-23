package dao.payment;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.payment.Bill;
import dao.GenericDaoBean;

@Stateless
@Local(BillDaoLocal.class)
public class BillDaoBean extends GenericDaoBean<Bill, Integer> implements BillDaoLocal {
	
}
