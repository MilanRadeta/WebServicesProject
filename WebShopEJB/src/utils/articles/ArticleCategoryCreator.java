package utils.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.articles.ArticleCategory;

public class ArticleCategoryCreator {

	public static List<ArticleCategory> createCategories() {
		String[] categoryNames =
			{
				"Prehrambeni proizvodi",
				"Kozmetika",
				"Kućna hemija",
				"Mali kućni aparati",
				"Novogodišnji ukrasi i jelke",
				"Čestitke",
				"Oprema za kampovanje",
				"Oprema za roštilj",
				"Televizori",
				"Audio i video oprema",
				"Računari",
				"Laptopovi",
				"Računarske periferije",
				"Bela tehnika",
				"Baštenski pribor",
				"Baštenski nameštaj",
				"Domaća alkoholna pića",
				"Uvozna alkoholna pića"
			};
		String[] categoryCodes = 
			{
				"PP",
				"KZM",
				"KHEM",
				"MKAP",
				"NGUJ",
				"CEST",
				"KAMPOPR",
				"ROSTOPR",
				"TV",
				"AUDVIDOPR",
				"RAC",
				"LAPTOP",
				"RACPER",
				"BELTEH",
				"BASTPRIB",
				"BASTNAM",
				"DOMALK",
				"UVOZALK"
			};
		List<ArticleCategory> categories = new ArrayList<ArticleCategory>();
		Random random = new Random();
		for (int i = 0; i < categoryNames.length; i++) {
			ArticleCategory category = new ArticleCategory();
			category.setName(categoryNames[i]);
			category.setCode(categoryCodes[i]);
			if (i >= 0 && i < 4) {
				category.setConsumerArticle(true);
			}
			category.setMaxDiscount(random.nextInt(70));
			categories.add(category);
		}
		return categories;
	}
	
}
