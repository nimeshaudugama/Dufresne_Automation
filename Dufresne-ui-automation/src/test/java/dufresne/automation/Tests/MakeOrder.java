package dufresne.automation.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dufresne.automation.Data.DataReader;
import dufresne.automation.PageObjects.CheckOutPage;
import dufresne.automation.PageObjects.ProductDetailPage;
import dufresne.automation.PageObjects.ShippingInfo;
import dufresne.automation.PageObjects.ViewCartDetailsPage;
import dufresne.automation.TestComponents.BaseTest;

public class MakeOrder extends BaseTest{
	
	String productName = "Sofa";
	
	@Test(dataProvider="getData")
	public void makeOrder(HashMap<String,String> input) {
//		ProductDetailPage productdetailpage = landingpage.searchProduct(productName);
//		String selectedProduct = landingpage.getSelectedProductName();
//	
//		ViewCartDetailsPage viewdetailspage = productdetailpage.addToCart();
//		
//
//		
//		CheckOutPage checkoutpage = viewdetailspage.viewDetails();
//		List<String> cartProducts = viewdetailspage.getCartProductName();
//		System.out.println("Product added to cart: " + selectedProduct);
//		System.out.println("Products in cart: " + cartProducts);
//
//	    Assert.assertTrue(cartProducts.contains(selectedProduct), "Product is not in the cart!");
//		ShippingInfo shippinginfo = checkoutpage.checkout();
//		shippinginfo.submitshippinginfo("isurujayakodu123@gmail.com","isuru", "jayakody", "123 , Glen", "Manitoba","2262379268");
		
		ProductDetailPage productdetailpage = landingpage.searchProduct(productName);
	    String selectedProduct = landingpage.getSelectedProductName();

	    ViewCartDetailsPage viewdetailspage = productdetailpage.addToCart();
	    
	    viewdetailspage.viewCart(); // Navigate to the cart page

	    List<String> cartProducts = viewdetailspage.getCartProductName(); // Verify cart items
	    System.out.println("Product added to cart: " + selectedProduct);
	    System.out.println("Products in cart: " + cartProducts);

	    Assert.assertTrue(cartProducts.contains(selectedProduct), "Product is not in the cart!");

	    CheckOutPage checkoutpage = viewdetailspage.proceedToCheckout(); // Now proceed
	    ShippingInfo shippinginfo = checkoutpage.checkout();
	    shippinginfo.submitshippinginfo(input.get("email"), input.get("firstname"), input.get("lastname"), input.get("address"),input.get("city"), input.get("phone"));
	}
	
	
	
	@DataProvider
	
	public Object[][] getData() throws IOException {
		 DataReader dataReader = new DataReader();
		List<HashMap<String,String>> data = dataReader.getJsonDataToMap();
		return new Object[][]  {{data.get(0)}};
	
	}
	

}
