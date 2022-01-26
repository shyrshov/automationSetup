package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProductFilter {

	@Step ("Find block if Filter by Block Name")
	public SelenideElement findBlock(String blockName) {
		return ($$("div.sidebar-block").findBy(text(blockName)));
	}
}
