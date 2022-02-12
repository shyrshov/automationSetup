package ua.com.rozetka.framework.modules;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ua.com.rozetka.framework.pages.ProductComparePage;

public class ProductsCompareModal  extends AbstractModule{

	private static final By COMPARE_LIST_LINK = By.cssSelector("a.comparison-modal__link");

	@Step ("Open Product Compare Page by clicking on Compare List Name")
	public ProductComparePage openProductCompareList(String listName) {
		Selenide.$$(COMPARE_LIST_LINK)
				.findBy(Condition.text(listName))
				.waitUntil(VISIBLE_AND_CLICKABLE, Duration.ofSeconds(5).toMillis())
				.scrollIntoView(false)
				.click();
		return new ProductComparePage().contentLoaded();
	}

	@Override
	public ProductsCompareModal contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
