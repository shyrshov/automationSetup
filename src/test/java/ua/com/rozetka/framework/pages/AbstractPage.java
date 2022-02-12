package ua.com.rozetka.framework.pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.CartModal;
import ua.com.rozetka.framework.modules.CatalogModal;
import ua.com.rozetka.framework.modules.LeftMenu;
import ua.com.rozetka.framework.modules.ProductsCompareModal;

public abstract class AbstractPage {

	public static final Condition VISIBLE_AND_CLICKABLE = Condition.and("visible and clickable", Condition.visible, Condition.enabled);

	private static final By LEFT_MENU_ICON = By.cssSelector("button[aria-label='Открыть меню']");

	private static final By CATEGORY_LINK_FORMAT = By.cssSelector(".menu-categories__link");

	private static final By SEARCH_BAR = By.cssSelector("div.header-search input");

	private static final By HEADER_CART_ICON = By.cssSelector("rz-cart button");

	private static final By HEADER_COMPARE_PRODUCTS_BUTTON = By.cssSelector("rz-comparison button");

	private static final By CATALOG = By.cssSelector("#fat-menu");

	public abstract <T extends AbstractPage> T contentLoaded();

	@Step ("Click Left menu icon")
	public LeftMenu openLeftMenu() {
		Selenide.$(LEFT_MENU_ICON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new LeftMenu().contentLoaded();
	}


	@Step ("Click on category from Category List on left page side")
	public TopLevelCategoryPage selectCategoryFromList(final String categoryName) {
		Selenide.$$(CATEGORY_LINK_FORMAT)
				.findBy(Condition.text(categoryName))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new TopLevelCategoryPage().contentLoaded();
	}

	@Step ("Search for product")
	public SearchResultsPage searchForProduct(final String productName) {
		Selenide.$(SEARCH_BAR)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.setValue(productName)
				.pressEnter();
		return new SearchResultsPage().contentLoaded();
	}

	@Step ("Click on header Cart button")
	public CartModal clickHeaderCartButton() {
		Selenide.$(HEADER_CART_ICON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new CartModal().contentLoaded();
	}

	@Step ("Open product Catalog")
	public CatalogModal openCatalog() {
		Selenide.$(CATALOG)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new CatalogModal().contentLoaded();
	}

	@Step ("Open Products compare page")
	public ProductsCompareModal openProductsCompare() {
		Selenide.$(HEADER_COMPARE_PRODUCTS_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new ProductsCompareModal().contentLoaded();
	}

}
