package ua.com.rozetka.framework.pages;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TopLevelCategoryPage extends AbstractPage {

	private static final By CATEGORIES = By.cssSelector(".tile-cats");

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Step ("Select Category From category grid menu")
	public CategoryPage selectCategoryFromGrid(String categoryName) {
		Selenide.$$(CATEGORIES)
				.findBy(Condition.text(categoryName))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new CategoryPage().contentLoaded();
	}

	@Override
	public TopLevelCategoryPage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
