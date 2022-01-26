package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.UserDetailsPage;

public class LeftMenu {

	private final By
			loginButton = xpath("//button[text()=' Вход ']"),
			userName = cssSelector("a.side-menu__user-name");

	@Step ("Click Login button")
	public LoginForm clickLoginButton() {
		$(loginButton).click();
		return new LoginForm();
	}

	@Step ("Click User name for authorized user")
	public UserDetailsPage clickUserName() {
		$(userName).click();
		return new UserDetailsPage();

	}
}
