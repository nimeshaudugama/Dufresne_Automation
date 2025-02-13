package dufresne.automation.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriver driver;
	private String selectedProductName; 
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//input[@class='autosuggest__input--open'])[1]")
	WebElement searchTab;
	
//	@FindBy(xpath="//div[contains(@class,'products-list__item')]")
//	private List<WebElement> products;
	
	
	public void goTo() {
		driver.get("https://dufresne.ca/");
	}
	
	public ProductDetailPage searchProduct(String productName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));  // Increased wait time for dialog box to appear

		// Wait for the search box to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(searchTab));

		// Click the search tab and enter the product name
		searchTab.click();
		searchTab.sendKeys(productName);

		searchTab.sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'product-title-card')])[1]")));


		 
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//a[contains(@class, 'product-title-card')]")
				));
		
		List<WebElement> allProducts = driver.findElements(By.xpath("//a[contains(@class, 'product-title-card')]"));

	
		for (WebElement product : allProducts) {
		    System.out.println(product.getText());
		}

		// Click on the first product in the list
		if (!allProducts.isEmpty()) {
			selectedProductName = allProducts.get(0).getText();
			allProducts.get(0).click();  // Click on the first product
			
		} else {
		    System.out.println("No products found.");
		  
		}
		
		ProductDetailPage productdetailpage = new ProductDetailPage(driver);
		return productdetailpage;

	
		  

		    }
	
	 public String getSelectedProductName() {
		  System.out.println("Selected Product: " + selectedProductName);
	        return selectedProductName; // Return the stored product name
	    }
	
	
		}

		
		
		
	


