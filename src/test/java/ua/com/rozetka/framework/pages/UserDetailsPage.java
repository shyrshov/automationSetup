package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.xpath;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.modules.PersonDetailsSection;

public class UserDetailsPage extends AbstractPage {

	private final By
			personDetailsSection = xpath("//*[text() = ' Личные данные ']");

	@Step ("Open Person Details Section")
	public PersonDetailsSection openPersonDetailsSection() {
		$(personDetailsSection).click();
		return new PersonDetailsSection();
	}

	@Override
	public void openPage() {
		open("/cabinet/personal-information/");
	}
}
