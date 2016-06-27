package dao.payment;

import java.util.List;

import model.payment.Bill;
import model.users.Buyer;
import dao.GenericDaoLocal;

public interface BillDaoLocal extends GenericDaoLocal<Bill, Integer> {
	public List<Bill> findOrderedBills();
	public Bill persistBillWithReferences(Bill bill);
	public List<Bill> findByBuyer(Buyer buyer);
}
