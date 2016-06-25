package utils.users;

import java.util.ArrayList;
import java.util.List;

import model.users.buyers.BuyerCategory;

public class BuyerCategoryCreator {

	public static List<BuyerCategory> createCategories() {
		String[] categoryNames =
			{
				"Bronzani kupac",
				"Srebrni kupac",
				"Zlatni kupac"
			};
		List<BuyerCategory> categories = new ArrayList<BuyerCategory>();
		for (int i = 0; i < categoryNames.length; i++) {
			BuyerCategory category = new BuyerCategory();
			category.setName(categoryNames[i]);
			// TODO: set payment bonuses
			categories.add(category);
		}
		return categories;
	}
}
