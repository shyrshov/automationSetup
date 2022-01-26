package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

import io.qameta.allure.Step;

public class CheckoutPage {

	@Step ("Check is the product in cart")
	public boolean isProductInCart(String productName) {
		$$("div.checkout-product__title-product").findBy(text(productName)).shouldBe(visible);
		return $$("div.checkout-product__title-product").findBy(text(productName)).isDisplayed();
	}


}
