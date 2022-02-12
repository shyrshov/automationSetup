package ua.com.rozetka.framework.pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductComparePage extends AbstractPage {

	private static final By COMPARE_CHARACTERISTIC_BLOCK = By.cssSelector("li.comparison-characteristic");

	private static final By COMPARE_CHARACTERISTIC_VALUE = By.cssSelector("dd.comparison-characteristic__value");

	private static final By PRODUCT_POSITION_CELL = By.cssSelector("li.products-grid__cell");

	private static final By PRODUCT_HEADER_TEXT = By.cssSelector("a.product__heading");

	private static final By PRODUCT_PRICE = By.cssSelector("div.product__price");

	private static final By PRODUCT_BUY_BUTTON = By.cssSelector("button.buy-button");

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Step ("Compare two products and return position of product with lower compared value")
	public int getProductPositionWithLowerValue(String compareBlock) {
		String firstProductValue[] = Selenide.$$(COMPARE_CHARACTERISTIC_BLOCK)
										   .findBy(Condition.text(compareBlock))
										   .$$(COMPARE_CHARACTERISTIC_VALUE)
										   .get(0)
										   .text()
										   .split(" ");
		String secondProductValue[] = Selenide.$$(COMPARE_CHARACTERISTIC_BLOCK)
											.findBy(Condition.text(compareBlock))
											.$$(COMPARE_CHARACTERISTIC_VALUE)
											.get(1)
											.text()
											.split(" ");
		if (Double.parseDouble(firstProductValue[0]) > Double.parseDouble(secondProductValue[0])) {
			return 0;
		} else {
			return 1;
		}
	}

	@Step ("Get Product Name by product position")
	public String getProductNameByProductPosition(int position) {
		return Selenide.$$(PRODUCT_POSITION_CELL)
					   .get(position)
					   .$(PRODUCT_HEADER_TEXT)
					   .text();
	}

	@Step ("Get Product Price by product position")
	public String getProductPriceByProductPosition(int position) {
		return Selenide.$$(PRODUCT_POSITION_CELL)
					   .get(position)
					   .$(PRODUCT_PRICE)
					   .text();
	}

	@Step ("Add product to cart by product position number")
	public ProductComparePage addProductToCartByProductPosition(int position) {
		Selenide.$$(PRODUCT_POSITION_CELL)
				.get(position)
				.$(PRODUCT_BUY_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this.contentLoaded();
	}
	@Override
	public ProductComparePage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
