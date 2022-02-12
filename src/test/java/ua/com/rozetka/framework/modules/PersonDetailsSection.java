package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PersonDetailsSection  extends AbstractModule{

	private static final By LAST_NAME_TITLE = By.cssSelector("[for='lastName']");

	private static final By LAST_NAME = By.cssSelector("[for='lastName'] + p");

	private static final By EDIT_BUTTON = By.xpath("//*[text() = ' Личные данные ']/ancestor::details//button[text()=' Редактировать ']");

	private static final By LAST_NAME_EDIT_CONDITION = By.cssSelector("#lastName");

	private static final By SAVE_BUTTON = By.xpath("//*[text() = ' Личные данные ']/ancestor::details//button[@type='submit']");

	@Step ("Get User Last Name")
	public String getUserLastName() {
		return Selenide.$(LAST_NAME)
					   .getText();
	}

	@Step ("Click Edit Person Details")
	public PersonDetailsSection clickEditPersonDetails() {
		Selenide.$(EDIT_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this;
	}

	@Step ("Set Last Name value")
	public PersonDetailsSection editLastName(String newLastName) {
		Selenide.$(LAST_NAME_EDIT_CONDITION)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.setValue(newLastName);
		return this;
	}

	@Step ("Click Save Button")
	public PersonDetailsSection clickSaveButton() {
		Selenide.$(SAVE_BUTTON)
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return this;
	}

	@Step ("Change Last Name")
	public PersonDetailsSection changeLastName(String newLastName) {
		clickEditPersonDetails();
		editLastName(newLastName);
		clickSaveButton();
		return this;
	}

	@Override
	public PersonDetailsSection contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
