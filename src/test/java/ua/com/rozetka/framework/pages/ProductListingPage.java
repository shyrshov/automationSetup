package ua.com.rozetka.framework.pages;

import java.time.Duration;
import java.util.List;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.ProductFilter;

public abstract class ProductListingPage extends AbstractPage {

	private static final By H1 = By.cssSelector("h1.catalog-heading");

	private static final By SORTING_PANEL = By.cssSelector("rz-sort select");

	private static final By SELECTED_FILTERS = By.cssSelector("rz-selected-filters");

	private static final By CHECKBOX_FILTER_LINK = By.cssSelector(".checkbox-filter__link");

	private static final By PRODUCT_TITLE = By.cssSelector("span.goods-tile__title");

	private static final By OPTION = By.cssSelector("option");

	private static final By CATALOG_LIST = By.cssSelector(".content_type_catalog .catalog-grid__cell");

	private static final By BUY_BUTTON = By.cssSelector("button.buy-button");

	private static final By PRODUCTS = By.cssSelector("div.goods-tile");

	private static final By PRODUCT_IMAGE = By.cssSelector("img");

	private static final By COMPARE_BUTTON = By.cssSelector("button.compare-button");

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Step ("Select Filter value by choosing filter block and value in it")
	public ProductListingPage selectFilterValue(String filterBlock, String filterValue) {
		new ProductFilter().findBlock(filterBlock)
						   .$$(CHECKBOX_FILTER_LINK)
						   .findBy(Condition.text(filterValue))
						   .waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
						   .scrollIntoView(false)
						   .click();
		return this.contentLoaded();
	}

	@Step ("Get Product titles list")
	public List<String> getProductTitlesList() {
		List<String> productTitleList;
		productTitleList = Selenide.$$(PRODUCT_TITLE)
								   .texts();
		return productTitleList;
	}

	@Step ("Get product Titles Selenide Elements Collection")
	public ElementsCollection getProductTitlesElements() {
		return Selenide.$$(PRODUCT_TITLE);
	}

	@Step ("Check if filter value is set (displayed in Page Header)")
	public boolean isFilterValueSet(String filterValue) {
		return Selenide.$(SELECTED_FILTERS)
					   .getText()
					   .contains(filterValue);
	}

	@Step ("Get Page Heading Text")
	public String getPageHeadingText() {
		return Selenide.$(H1)
					   .getText();
	}

	@Step ("Select Sorting Type")
	public ProductListingPage selectSortingType(String sortingType) {
		Selenide.$(SORTING_PANEL)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		Selenide.$(SORTING_PANEL)
				.$$(OPTION)
				.findBy(Condition.text(sortingType))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this.contentLoaded();
	}

	@Step ("Add Product to cart by Product Position")
	public ProductListingPage addProductToCartByProductPosition(int productNumber) {
		Selenide.$$(CATALOG_LIST)
				.get(productNumber)
				.$(BUY_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this.contentLoaded();
	}

	@Step ("Add Product to cart by Product position")
	public ProductListingPage addProductToCompareByProductPosition(int productNumber) {
		Selenide.$$(PRODUCTS)
				.get(productNumber)
				.$(PRODUCT_IMAGE)
				.shouldBe(Condition.visible);
		Selenide.$$(PRODUCTS)
				.get(productNumber)
				.$(COMPARE_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this.contentLoaded();
	}

	@Override
	public ProductListingPage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
