package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

import io.qameta.allure.Step;
import ua.com.rozetka.framework.pages.CategoryPage;

public class CatalogModal {

	@Step ("Hover mouse on Top Category from list")
	public CatalogModal hoverOnTopCategory(String categoryName) {
		$$(".menu-categories__item").findBy(text(categoryName)).hover();
		return this;
	}

	@Step ("Select Category From Catalog")
	public CategoryPage selectCategoryFromCatalog(String categoryName) {
		$$("a.menu__link").findBy(text(categoryName)).click();
		return new CategoryPage();
	}


}
