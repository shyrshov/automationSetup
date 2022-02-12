package ua.com.rozetka.framework.modules;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductFilter  extends AbstractModule{

	public static final By SIDEBAR_FILTER_BLOCK = By.cssSelector("div.sidebar-block");

	@Step ("Find block if Filter by Block Name")
	public SelenideElement findBlock(String blockName) {
		return (Selenide.$$(SIDEBAR_FILTER_BLOCK)
						.findBy(Condition.text(blockName)));
	}

	@Override
	public ProductFilter contentLoaded() {
		Selenide.$(PAGE_PRE_LOADER).should(Condition.disappear);
		Selenide.$(PRE_LOADERS).should(Condition.disappear);
		return this;
	}
}
