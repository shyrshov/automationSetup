package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.HomePage;

public class LoginForm  extends AbstractModule{

	private static final By EMAIL_INPUT_FIELD = By.cssSelector("#auth_email");

	private static final By PASSWORD_INPUT_FIELD = By.cssSelector("#auth_pass");

	private static final By LOGIN_BUTTON = By.xpath("//button[text()=' Войти ']");

	@Step ("Fill email field")
	public LoginForm fillEmail(String email) {
		Selenide.$(EMAIL_INPUT_FIELD)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.setValue(email);
		return this;
	}

	@Step ("Fill password field")
	public LoginForm fillPassword(String password) {
		Selenide.$(PASSWORD_INPUT_FIELD)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.setValue(password);
		return this;
	}

	@Step ("Click Login Button")
	public void pressLoginButton() {
		Selenide.$(LOGIN_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
	}

	@Step ("Fill User credentials and press Login Button")
	public HomePage fillUserCredentialsAndLogin(String email, String password) {
		fillEmail(email);
		fillPassword(password);
		pressLoginButton();
		Selenide.sleep(10000);  //added to handle captcha manually
		return new HomePage().contentLoaded();
	}

	@Override
	public LoginForm contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
