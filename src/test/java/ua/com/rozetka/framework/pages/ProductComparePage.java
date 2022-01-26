package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

import io.qameta.allure.Step;

public class ProductComparePage extends AbstractPage {

	@Step ("Compare two products and return position of product with lower compared value")
	public int getProductPositionWithLowerValue(String compareBlock) {
		String firstProductValue = $$("li.comparison-characteristic").findBy(text(compareBlock)).$$("dd.comparison-characteristic__value").get(0).text().substring(0, 2);
		String secondProductValue = $$("li.comparison-characteristic").findBy(text(compareBlock)).$$("dd.comparison-characteristic__value").get(1).text().substring(0, 2);
		if (Integer.parseInt(firstProductValue) < Integer.parseInt(secondProductValue)) {
			return 0;
		} else {
			return 1;
		}
	}

	@Step ("Get Product Name by product position")
	public String getProductNameByProductPosition(int position) {
		return $$("li.products-grid__cell").get(position).$("a.product__heading").text();
	}

	@Step ("Add product to cart by product position number")
	public ProductComparePage addProductToCartByProductPosition(int position) {
		$$("li.products-grid__cell").get(position).$("button.buy-button").click();
		return this;
	}

	@Override
	public void openPage() {

	}
}
