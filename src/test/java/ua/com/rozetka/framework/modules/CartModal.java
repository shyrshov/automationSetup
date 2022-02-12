package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.CheckoutPage;

public class CartModal extends AbstractModule{

	private static final By CHECKOUT_BUTTON = By.cssSelector("[data-testid='cart-receipt-submit-order']");

	@Step ("Click Checkout button")
	public CheckoutPage clickCheckoutButton() {
		Selenide.$(CHECKOUT_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new CheckoutPage().contentLoaded();
	}

	@Override
	public CartModal contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
