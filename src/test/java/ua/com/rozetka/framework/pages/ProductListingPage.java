package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;

import java.util.List;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.ProductFilter;

public abstract class ProductListingPage extends AbstractPage {

	private By
			h1 = cssSelector("h1.catalog-heading"),
			sortingPanel = cssSelector("rz-sort select"),
			selectedFilters = cssSelector("rz-selected-filters");

	@Step ("Select Filter value by choosing filter block and value in it")
	public ProductListingPage selectFilterValue(String filterBlock, String filterValue) {
		new ProductFilter().findBlock(filterBlock).$$(".checkbox-filter__link").findBy(text(filterValue)).click();
		return this;
	}

	@Step ("Get Product titles list")
	public List<String> getProductTitlesList() {
		List<String> productTitleList;
		productTitleList = $$("span.goods-tile__title").texts();
		return productTitleList;
	}

	@Step ("Get product Titles Selenide Elements Collection")
	public ElementsCollection getProductTitlesElements() {
		return $$("span.goods-tile__title");
	}

	@Step ("Check if filter value is set (displayed in Page Header)")
	public boolean checkIfFilterValueSet(String filterValue) {
		return $(selectedFilters).getText().contains(filterValue);
	}

	@Step ("Get Page Heading Text")
	public String getPageHeadingText() {
		return $(h1).getText();
	}

	@Step ("Select Sorting Type")
	public ProductListingPage selectSortingType(String sortingType) {
		$(sortingPanel).click();
		$(sortingPanel).$$("option").findBy(text(sortingType)).click();
		return this;
	}

	@Step ("Add Product to cart by Product Position")
	public ProductListingPage addProductToCartByProductPosition(int productNumber) {
		$$(".content_type_catalog li").shouldBe();
		$$(".content_type_catalog li").get(productNumber).$("button.buy-button").click();
		return this;
	}

	@Step ("Add Product to cart by Product position")
	public ProductListingPage addProductToCompareByProductPosition(int productNumber) {
		$$("div.goods-tile").get(productNumber).$("img").shouldBe(visible);
		$$("div.goods-tile").get(productNumber).$("button.compare-button").click();
		return this;
	}

}
