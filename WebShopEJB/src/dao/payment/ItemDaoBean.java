package dao.payment;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.payment.Item;
import dao.GenericDaoBean;

@Stateless
@Local(ItemDaoLocal.class)
public class ItemDaoBean extends GenericDaoBean<Item, Integer> implements ItemDaoLocal {
	
}
