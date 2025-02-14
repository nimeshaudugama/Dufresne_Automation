package dufresne.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement paymentButton;

	public boolean isPaymentButtonDisplayed() {
		return paymentButton.isDisplayed();
	}

}
