package dufresne.automation.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCartDetailsPage {

	WebDriver driver;

	public ViewCartDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'/cart')]")
	WebElement btnviewDetails;

	@FindBy(xpath = "//span[text()='Confirm']")
	WebElement btnconfirm;

	@FindBy(xpath = "//p[(@class='text-base')]")
	List<WebElement> cartProductTitle;

	// Navigate to View Cart page
	public void viewCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(btnviewDetails));

		btnviewDetails.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cy='update-postalcode']")));
	}

	// Extract product names from cart
	public List<String> getCartProductName() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfAllElements(cartProductTitle));

		List<String> productNames = new ArrayList<>();
		for (WebElement product : cartProductTitle) {
			productNames.add(product.getText().trim());
			
		}
		return productNames;
	}

	// Proceed to checkout
	public CheckOutPage proceedToCheckout() {
		btnconfirm.click();
		return new CheckOutPage(driver);
	}

}
