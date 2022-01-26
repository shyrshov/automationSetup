package ua.com.rozetka.framework.modules;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

import io.qameta.allure.Step;
import ua.com.rozetka.framework.pages.ProductComparePage;

public class ProductsCompareModal {

	@Step ("Open Product Compare Page by clicking on Compare List Name")
	public ProductComparePage openProductCompareList(String listName) {
		$$("a.comparison-modal__link").findBy(text(listName)).click();
		return new ProductComparePage();
	}
}
