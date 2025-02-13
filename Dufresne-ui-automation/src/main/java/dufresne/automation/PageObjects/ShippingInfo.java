package dufresne.automation.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ShippingInfo {
	
	WebDriver driver;
	
	public ShippingInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	
}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@name='firstName' and @placeholder='First name']")
	WebElement firstnamefield;
	
	@FindBy(xpath="//input[@name='lastName' and @placeholder='Last name']")
	WebElement lastnamefield;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	WebElement addressfield;
	
	@FindBy(xpath="//input[@placeholder='City']")
	WebElement cityfield;
	
	@FindBy(xpath="//input[@placeholder='Phone']")
	WebElement phonefield;

	//@FindBy(xpath="//span[normalize-space()='Continue to shipping']")
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement btncontinueshipping;
	
	
	
	public PaymentPage submitshippinginfo(String email , String firstname , String lastname , String address , String city , String phone ) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		
		emailfield.sendKeys(email);
		firstnamefield.sendKeys(firstname);
		lastnamefield.sendKeys(lastname);
		addressfield.sendKeys(lastname);
		cityfield.sendKeys(city);
		
		wait.until(ExpectedConditions.elementToBeClickable(btncontinueshipping));
		btncontinueshipping.click();
		
		PaymentPage paymentpage = new PaymentPage();
		return paymentpage;

		
		
		
	}


}
