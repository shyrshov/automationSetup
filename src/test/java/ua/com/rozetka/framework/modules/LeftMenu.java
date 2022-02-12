package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.UserDetailsPage;

public class LeftMenu extends AbstractModule{

	private static final By LOGIN_BUTTON = By.xpath("//button[text()=' Вход ']");

	private static final By USER_NAME = By.cssSelector("a.side-menu__user-name");

	@Step ("Click Login button")
	public LoginForm clickLoginButton() {
		Selenide.$(LOGIN_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new LoginForm().contentLoaded();
	}

	@Step ("Click User name for authorized user")
	public UserDetailsPage clickUserName() {
		Selenide.$(USER_NAME)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new UserDetailsPage().contentLoaded();
	}

	@Override
	public LeftMenu contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
