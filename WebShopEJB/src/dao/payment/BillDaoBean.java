package dao.payment;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import model.payment.Bill;
import model.payment.Item;
import model.payment.discounts.BillDiscount;
import model.payment.discounts.ItemDiscount;
import dao.GenericDaoBean;
import dao.payment.discounts.BillDiscountDaoLocal;
import dao.payment.discounts.ItemDiscountDaoLocal;
import dao.users.BuyerDaoLocal;

@Stateless
@Local(BillDaoLocal.class)
public class BillDaoBean extends GenericDaoBean<Bill, Integer> implements BillDaoLocal {

	@EJB
	private ItemDaoLocal itemDao;
	
	@EJB
	private ItemDiscountDaoLocal itemDiscountDao;
	
	@EJB
	private BillDiscountDaoLocal billDiscountDao;
	
	@EJB
	private BuyerDaoLocal buyerDao;
	
	@Override
	public List<Bill> findOrderedBills() {
		Query query = em.createNamedQuery("findOrderedBills");
		@SuppressWarnings("unchecked")
		List<Bill> bills = query.getResultList();
		return bills;
	}

	@Override
	public Bill persistBillWithReferences(Bill bill) {
		for (Item item : bill.getItems()) {
			itemDao.persist(item);
			for (ItemDiscount discount : item.getDiscounts()) {
				itemDiscountDao.persist(discount);
			}
		}
		persist(bill);
		for (Item item : bill.getItems()) {
			itemDao.persist(item);
			for (ItemDiscount discount : item.getDiscounts()) {
				itemDiscountDao.persist(discount);
			}
		}
		for (BillDiscount discount : bill.getDiscounts()) {
			billDiscountDao.persist(discount);
		}
		buyerDao.merge(bill.getBuyer());
		return bill;
	}
	
	
	
}
