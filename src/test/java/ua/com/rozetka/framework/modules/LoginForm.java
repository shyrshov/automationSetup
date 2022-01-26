package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.HomePage;

public class LoginForm {

	private final By
			emailInputField = cssSelector("#auth_email"),
			passwordInputField = cssSelector("#auth_pass"),
			loginButton = xpath("//button[text()=' Войти ']");

	@Step ("Fill email field")
	public LoginForm fillEmail(String email) {
		$(emailInputField).setValue(email);
		return this;
	}

	@Step ("Fill password field")
	public LoginForm fillPassword(String password) {
		$(passwordInputField).setValue(password);
		return this;
	}

	@Step ("Click Login Button")
	public void pressLoginButton() {
		$(loginButton).click();
	}

	@Step ("Fill User credentials and press Login Button")
	public HomePage fillUserCredentialsAndLogin(String email, String password) {
		fillEmail(email);
		fillPassword(password);
		pressLoginButton();
		sleep(10000);  //added to handle captcha manually
		return new HomePage();
	}
}
