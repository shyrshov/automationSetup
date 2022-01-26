package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.CheckoutPage;

public class CartModal {
	private By
			checkoutButton = cssSelector("[data-testid='cart-receipt-submit-order']");

	@Step ("Click Checkout button")
	public CheckoutPage clickCheckoutButton() {
		$(checkoutButton).click();
		return new CheckoutPage();
	}
}
