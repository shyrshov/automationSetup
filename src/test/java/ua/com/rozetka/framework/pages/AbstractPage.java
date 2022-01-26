package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.CartModal;
import ua.com.rozetka.framework.modules.CatalogModal;
import ua.com.rozetka.framework.modules.LeftMenu;
import ua.com.rozetka.framework.modules.ProductsCompareModal;

public abstract class AbstractPage {

	private By
			leftMenuIcon = cssSelector("button[aria-label='Открыть меню']"),
			searchBar = cssSelector("div.header-search input"),
			headerCartIcon = cssSelector("rz-cart button"),
			headerCompareProductsButton = cssSelector("rz-comparison button"),
			catalog = cssSelector("#fat-menu");


	@Step ("Click Left menu icon")
	public LeftMenu openLeftMenu() {
		$(leftMenuIcon).click();
		return new LeftMenu();
	}

	@Step ("Click on category from Category List on left page side")
	public TopLevelCategoryPage selectCategoryFromList(String categoryName) {
		$$(".menu-categories__link").findBy(text(categoryName)).click();
		return new TopLevelCategoryPage();
	}

	@Step ("Search for product")
	public SearchResultsPage searchForProduct(String productName) {
		$(searchBar).setValue(productName).pressEnter();
		return new SearchResultsPage();
	}

	@Step ("Click on header Cart button")
	public CartModal clickHeaderCartButton() {
		$(headerCartIcon).click();
		return new CartModal();
	}

	@Step ("Open product Catalog")
	public CatalogModal openCatalog() {
		$(catalog).click();
		return new CatalogModal();
	}

	@Step ("Open Products compare page")
	public ProductsCompareModal openProductsCompare() {
		$(headerCompareProductsButton).click();
		return new ProductsCompareModal();
	}

	public abstract void openPage();
}
