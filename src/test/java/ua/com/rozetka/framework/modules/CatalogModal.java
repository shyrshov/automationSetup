package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.CategoryPage;

public class CatalogModal  extends AbstractModule{

	public static final By TOP_CATEGORY_ITEM = By.cssSelector(".menu-categories__item");

	public static final By CATEGORY_LINK = By.cssSelector("a.menu__link");

	@Step ("Hover mouse on Top Category from list")
	public CatalogModal hoverOnTopCategory(String categoryName) {
		Selenide.$$(TOP_CATEGORY_ITEM)
				.findBy(Condition.text(categoryName))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.hover();
		return this;
	}

	@Step ("Select Category From Catalog")
	public CategoryPage selectCategoryFromCatalog(String categoryName) {
		Selenide.$$(CATEGORY_LINK)
				.findBy(Condition.text(categoryName))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new CategoryPage().contentLoaded();
	}

	@Override
	public CatalogModal contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
