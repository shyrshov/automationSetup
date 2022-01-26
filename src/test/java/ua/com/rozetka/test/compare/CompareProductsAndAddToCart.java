package ua.com.rozetka.test.compare;

import static com.codeborne.selenide.Selenide.open;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.pages.CheckoutPage;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.framework.pages.ProductComparePage;
import ua.com.rozetka.test.BaseTest;

public class CompareProductsAndAddToCart extends BaseTest {

	@BeforeTest
	void openTestPage() {
		open("/");
	}

	@Test
	void compareProductsAndAddToCart() {
		ProductComparePage productComparePage = new ProductComparePage();
		String topCategory = "Спорт и увлечения";
		String category = "Гироборды";
		String sortingType = "От дорогих к дешевым";
		String compareList = "Гироборды";
		String compareBlock = "Вес";

		new HomePage().openCatalog()
					  .hoverOnTopCategory(topCategory)
					  .selectCategoryFromCatalog(category)
					  .selectSortingType(sortingType)
					  .addProductToCompareByProductPosition(0)
					  .addProductToCompareByProductPosition(1)
					  .openProductsCompare()
					  .openProductCompareList(compareList);

		int productPosition = productComparePage.getProductPositionWithLowerValue(compareBlock);
		String productName = productComparePage.getProductNameByProductPosition(productPosition);

		productComparePage.addProductToCartByProductPosition(productPosition)
						  .clickHeaderCartButton()
						  .clickCheckoutButton();

		Assert.assertTrue(new CheckoutPage().isProductInCart(productName));
	}
}
