package ua.com.rozetka.test.category;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.pages.CategoryPage;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.test.BaseTest;

public class DisplayProductListTest extends BaseTest {

	@BeforeTest
	void openTestPage() {
		open("/");
	}

	@Test
	void displayProductsAfterFilterUseTest() {
		CategoryPage categoryPage = new CategoryPage();
		String category = "Товары для геймеров";
		String subcategory = "Игровые приставки";
		String filterBlock = "Бренд";
		String filterValue = "Sony PlayStation";
		String productName = "PlayStation";

		new HomePage().selectCategoryFromList(category)
					  .selectCategoryFromGrid(subcategory)
					  .selectFilterValue(filterBlock, filterValue);

		$("rz-selected-filters").shouldHave(text(filterValue));

		Assert.assertTrue(categoryPage.checkIfFilterValueSet(filterValue));
		//не смог найти метода в селениде для проверки каждого элемента из коллекции, shouldHave(texts()) не отрабатывает
		List<String> titles = categoryPage.getProductTitlesElements().texts();
		titles.forEach(i ->
				Assert.assertTrue(i.contains(productName)));
	}
}
