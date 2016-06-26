package utils.users;

import java.util.ArrayList;
import java.util.List;

import model.users.buyers.BuyerCategory;
import model.users.buyers.PaymentPointsBonus;

public class BuyerCategoryCreator {

	public static List<BuyerCategory> createCategories() {
		String[] categoryNames = { "Bronzani kupac", "Srebrni kupac",
				"Zlatni kupac" };
		List<BuyerCategory> categories = new ArrayList<BuyerCategory>();

		List<PaymentPointsBonus> bonuses;
		PaymentPointsBonus bonus;
		for (int i = 0; i < categoryNames.length; i++) {
			BuyerCategory category = new BuyerCategory();
			category.setName(categoryNames[i]);
			categories.add(category);
			bonuses = category.getPaymentPointsBonuses();
			switch (i) {
			case 0:
				bonus = new PaymentPointsBonus();
				bonus.setMin(0);
				bonus.setMax(5000);
				bonus.setPercent(2);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(5000);
				bonus.setMax(10000);
				bonus.setPercent(4);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(10000);
				bonus.setMax(20000);
				bonus.setPercent(6);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(20000);
				bonus.setMax(50000);
				bonus.setPercent(8);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(50000);
				bonus.setMax(100000);
				bonus.setPercent(10);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(100000);
				bonus.setMax(1000000);
				bonus.setPercent(15);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				break;
			case 1:
				bonus = new PaymentPointsBonus();
				bonus.setMin(0);
				bonus.setMax(5000);
				bonus.setPercent(5);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(5000);
				bonus.setMax(10000);
				bonus.setPercent(8);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(10000);
				bonus.setMax(20000);
				bonus.setPercent(10);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(20000);
				bonus.setMax(50000);
				bonus.setPercent(15);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(50000);
				bonus.setMax(100000);
				bonus.setPercent(18);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(100000);
				bonus.setMax(1000000);
				bonus.setPercent(20);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				break;
			case 2:
				bonus = new PaymentPointsBonus();
				bonus.setMin(0);
				bonus.setMax(5000);
				bonus.setPercent(10);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(5000);
				bonus.setMax(10000);
				bonus.setPercent(13);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(10000);
				bonus.setMax(20000);
				bonus.setPercent(16);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(20000);
				bonus.setMax(50000);
				bonus.setPercent(19);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(50000);
				bonus.setMax(100000);
				bonus.setPercent(22);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				bonus = new PaymentPointsBonus();
				bonus.setMin(100000);
				bonus.setMax(1000000);
				bonus.setPercent(25);
				bonus.setBuyerCategory(category);
				bonuses.add(bonus);
				break;
			}
		}
		return categories;
	}
}
