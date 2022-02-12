package ua.com.rozetka.test.compare;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.framework.pages.CheckoutPage;
import ua.com.rozetka.framework.pages.HomePage;
import ua.com.rozetka.framework.pages.ProductComparePage;
import ua.com.rozetka.test.BaseTest;

public class CompareProductsAndAddToCart extends BaseTest {

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
		String productPrice = productComparePage.getProductPriceByProductPosition(productPosition);

		productComparePage.addProductToCartByProductPosition(productPosition)
						  .clickHeaderCartButton()
						  .clickCheckoutButton();

		Assert.assertTrue(new CheckoutPage().isProductInCart(productName));
		Assert.assertEquals(productName, (new CheckoutPage().getProductNames().get(0)));
		Assert.assertEquals(productPrice, (new CheckoutPage().getProductPrices().get(0)));
	}
}
