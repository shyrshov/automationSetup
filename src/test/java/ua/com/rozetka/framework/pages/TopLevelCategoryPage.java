package ua.com.rozetka.framework.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

import io.qameta.allure.Step;

public class TopLevelCategoryPage extends AbstractPage {

	@Step ("Select Category From category grid menu")
	public CategoryPage selectCategoryFromGrid(String categoryName) {
		$$(".tile-cats").findBy(text(categoryName)).click();
		return new CategoryPage();
	}

	@Override
	public void openPage() {

	}
}
