package ua.com.rozetka.test.purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.framework.pages.SearchResultsPage;
import ua.com.rozetka.test.BaseTest;

public class SearchAndAddToCartTest extends BaseTest {

	@Test
	void searchForProductAndCheckout() {
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		String productName = "Acer Aspire";
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
