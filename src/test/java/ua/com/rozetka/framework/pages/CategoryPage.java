package ua.com.rozetka.framework.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class CategoryPage extends ProductListingPage {

	private static final By PAGE_PRE_LOADER = By.cssSelector(".tile-cats");

	private static final By PRE_LOADERS = By.cssSelector("[class*=preloader]");

	@Override
	public CategoryPage contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
