package utils.articles;

import java.util.ArrayList;
import java.util.List;

import model.articles.ArticleCategory;

public class ArticleCategoryCreator {

	public List<ArticleCategory> createCategories() {
		String[] categoryNames =
			{
				"Roba široke potrošnje",
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
		List<ArticleCategory> categories = new ArrayList<ArticleCategory>();
		for (int i = 0; i < categoryNames.length; i++) {
			ArticleCategory category = new ArticleCategory();
			category.setId(i);
			category.setName(categoryNames[i]);
			if (i > 0 && i < 5) {
				category.setParentCategory(categories.get(0));
			}
			categories.add(category);
		}
		return categories;
	}
	
}
