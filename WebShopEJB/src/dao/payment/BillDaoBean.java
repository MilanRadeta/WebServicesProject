package dao.payment;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import model.payment.Bill;
import dao.GenericDaoBean;

@Stateless
@Local(BillDaoLocal.class)
public class BillDaoBean extends GenericDaoBean<Bill, Integer> implements BillDaoLocal {

	@Override
	public List<Bill> findOrderedBills() {
		Query query = em.createNamedQuery("findOrderedBills");
		@SuppressWarnings("unchecked")
		List<Bill> bills = query.getResultList();
		return bills;
	}
	
}
