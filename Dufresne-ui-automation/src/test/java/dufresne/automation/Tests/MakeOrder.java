package dufresne.automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dufresne.automation.Data.DataReader;
import dufresne.automation.PageObjects.CheckOutPage;
import dufresne.automation.PageObjects.PaymentPage;
import dufresne.automation.PageObjects.ProductDetailPage;
import dufresne.automation.PageObjects.ShippingInfo;
import dufresne.automation.PageObjects.ViewCartDetailsPage;
import dufresne.automation.TestComponents.BaseTest;

public class MakeOrder extends BaseTest {

	// String productName = "Sofa";

	@Test(dataProvider = "getData")
	public void makeOrder(HashMap<String, String> input) {

		// Search for product
		ProductDetailPage productDetailPage = landingPage.searchProduct(input.get("product_name"));
		String selectedProduct = landingPage.getSelectedProductName();

		// Add product to cart
		ViewCartDetailsPage viewDetailsPage = productDetailPage.addToCart();

		// Navigate to the cart page
		viewDetailsPage.viewCart();

		List<String> cartProducts = viewDetailsPage.getCartProductName();

		// Verify cart item and selected product
		System.out.println("Product added to cart: " + selectedProduct);
		System.out.println("Products in cart: " + cartProducts);
		Assert.assertTrue(cartProducts.contains(selectedProduct), "Product is not in the cart!");

		// Proceed to checkout
		CheckOutPage checkoutpage = viewDetailsPage.proceedToCheckout();
		ShippingInfo shippinginfo = checkoutpage.proceedToCheckout();

		// Fill shipping details
		PaymentPage paymentPage = shippinginfo.submitshippinginfo(input.get("email"), input.get("first_name"),
				input.get("last_name"), input.get("address"), input.get("city"), input.get("phone_number"));

		// Assert that the payment button is displayed
		Assert.assertTrue(paymentPage.isPaymentButtonDisplayed());

		System.out.println("Payment button is visible, assertion passed.");
	}

	@DataProvider

	public Object[][] getData() throws IOException {
		DataReader dataReader = new DataReader();
		List<HashMap<String, String>> data = dataReader.getJsonDataToMap();

		// Return the first test data set
		return new Object[][] { { data.get(0) } };

	}

}
