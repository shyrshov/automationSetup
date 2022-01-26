package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PersonDetailsSection {

	private final By
			lastNameTitle = cssSelector("[for='lastName']"),
			lastName = cssSelector("[for='lastName'] + p"),
			editButton = xpath("//*[text() = ' Личные данные ']/ancestor::details//button[text()=' Редактировать ']"),
			lastNameEditCondition = cssSelector("#lastName"),
			saveButton = xpath("//*[text() = ' Личные данные ']/ancestor::details//button[@type='submit']");

	@Step ("Get User Last Name")
	public String getUserLastName() {
		return $(lastName).getText();
	}

	@Step ("Click Edit Person Details")
	public PersonDetailsSection clickEditPersonDetails() {
		$(editButton).click();
		return this;
	}

	@Step ("Set Last Name value")
	public PersonDetailsSection editLastName(String newLastName) {
		$(lastNameEditCondition).setValue(newLastName);
		return this;
	}

	@Step ("Click Save Button")
	public PersonDetailsSection clickSaveButton() {
		$(saveButton).click();
		return this;
	}

	@Step ("Change Last Name")
	public PersonDetailsSection changeLastName(String newLastName) {
		clickEditPersonDetails();
		editLastName(newLastName);
		clickSaveButton();
		return this;
	}


}
