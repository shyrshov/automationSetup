package ua.com.rozetka.framework.pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.PersonDetailsSection;

public class UserDetailsPage extends AbstractPage {

	private static final By PERSON_DETAILS_SECTION = By.xpath("//*[text() = ' Личные данные ']");

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Step ("Open Person Details Section")
	public PersonDetailsSection openPersonDetailsSection() {
		Selenide.$(PERSON_DETAILS_SECTION)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new PersonDetailsSection();
	}

	@Override
	public UserDetailsPage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
