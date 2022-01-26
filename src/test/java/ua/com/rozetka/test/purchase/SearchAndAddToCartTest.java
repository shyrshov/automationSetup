package ua.com.rozetka.test.purchase;

import static com.codeborne.selenide.Selenide.open;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.framework.pages.SearchResultsPage;
import ua.com.rozetka.test.BaseTest;

public class SearchAndAddToCartTest extends BaseTest {

	@BeforeTest
	void openTestPage() {
		open("/");
	}

	@Test
	void searchForProductAndCheckout() {
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		String productName = "Ноутбук Acer Aspire";
		String sortingType = "От дорогих к дешевым";

		homePage.searchForProduct(productName);

		Assert.assertTrue(searchResultsPage.getPageHeadingText().contains(productName));

		searchResultsPage.selectSortingType(sortingType)
						 .addProductToCartByProductPosition(0)
						 .clickHeaderCartButton()
						 .clickCheckoutButton()
						 .isProductInCart(productName);
	}
}
