package dufresne.automation.PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

	WebDriver driver;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@data-cy='pdp__add-to-cart-main']")
	WebElement addToCart;

	public ViewCartDetailsPage addToCart() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", addToCart);

		wait.until(ExpectedConditions.elementToBeClickable(addToCart));

		js.executeScript("arguments[0].click();", addToCart);

		ViewCartDetailsPage viewdetailpage = new ViewCartDetailsPage(driver);
		return viewdetailpage;

	}

}
