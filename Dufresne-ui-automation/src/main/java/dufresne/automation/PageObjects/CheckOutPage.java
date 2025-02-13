package dufresne.automation.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[@id='Checkout_With_CC_Paypal']")
	WebElement btncheckout;
	
	
	public ShippingInfo checkout() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(btncheckout));

	        try {
	            btncheckout.click(); // Try standard Selenium click first
	        } catch (Exception e) {
	            // Fallback: Use JavaScript click if standard click fails
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", btncheckout);
	        }
		
		//btncheckout.click();
		
//		WebElement checkoutButton = driver.findElement(By.id("Checkout_With_CC_Paypal"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);

		ShippingInfo shippinginginfo = new ShippingInfo(driver);
		return shippinginginfo;
		
	}

}
