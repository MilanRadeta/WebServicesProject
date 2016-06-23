package dao.users.buyers;

import javax.ejb.Local;
import javax.ejb.Stateless;

import model.users.buyers.PaymentPointsBonus;
import dao.GenericDaoBean;

@Stateless
@Local(PaymentPointsBonusDaoLocal.class)
public class PaymentPointsBonusDaoBean extends GenericDaoBean<PaymentPointsBonus, Integer> implements PaymentPointsBonusDaoLocal {
	
}
