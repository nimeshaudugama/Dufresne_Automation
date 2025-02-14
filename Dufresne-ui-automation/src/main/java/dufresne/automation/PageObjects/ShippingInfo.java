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

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(xpath = "//input[@name='firstName' and @placeholder='First name']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@name='lastName' and @placeholder='Last name']")
	WebElement lastNameField;

	@FindBy(xpath = "//input[@placeholder='Address']")
	WebElement addressField;

	@FindBy(xpath = "//input[@placeholder='City']")
	WebElement cityField;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	WebElement phoneField;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement continueShippingButton;

	public PaymentPage submitshippinginfo(String email, String firstName, String lastName, String address, String city,
			String phone) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
		;
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		addressField.sendKeys(address);
		cityField.sendKeys(city);
		phoneField.sendKeys(phone);

		wait.until(ExpectedConditions.elementToBeClickable(continueShippingButton)).click();

		return new PaymentPage(driver);

	}

}
