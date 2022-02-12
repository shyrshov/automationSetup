package ua.com.rozetka.framework.pages;

import java.util.List;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckoutPage {

	private static final By PRODUCT_TITLE = By.cssSelector("div.checkout-product__title-product");

	private static final By PRODUCT_PRICE = By.cssSelector("span.checkout-product__price");

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Step ("Check is the product in cart")
	public boolean isProductInCart(String productName) {
		Selenide.$$(PRODUCT_TITLE)
				.findBy(Condition.text(productName))
				.shouldBe(Condition.visible);
		return Selenide.$$(PRODUCT_TITLE)
					   .findBy(Condition.text(productName))
					   .isDisplayed();
	}

	@Step ("Get names of products which is already in cart")
	public List<String> getProductNames() {
		return Selenide.$$(PRODUCT_TITLE)
				.texts();
	}

	@Step ("Get prices of products which is already in cart")
	public List<String> getProductPrices() {
		return Selenide.$$(PRODUCT_PRICE)
					   .texts();
	}

	public CheckoutPage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
