package utils;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BrowserActions {

	public WebDriver driver;
	public WebDriverWait wait;

	public BrowserActions(WebDriver driver) {

		this.driver = driver;
}

	// Wait for Page Load

	public void WaittoPageLoad() {

		Boolean readyStateComplete = false;

		try {

			while (!readyStateComplete) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Click on Web Element

	public void click(WebElement element) {

		try {
		
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	// Wait for Web element Clickable
	
		public void waitForElement(WebElement element) throws InterruptedException {
			
			try {
				
				wait	= new WebDriverWait(driver, Duration.ofSeconds(10));
		
				wait.until(ExpectedConditions.elementToBeClickable(element));
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
	// Scroll to WebElement using JavaScriptExecuter

	public void scrollToElement(WebElement element) {

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Get text of Web element

	public String getText(WebElement element) {

		String elementText = null;

		try {
			elementText = element.getText();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return elementText;
	}

	// Set Text of Web element

	public void setText(WebElement element, String value) {

		try {
		
			element.sendKeys(value);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Set Text of Web element and log step in report

	public void setText(WebElement element, String value, String imagePath, String message) {

		try {

			element.sendKeys(value);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// Clear text from the field

	public void clearText(WebElement element) {

		try {
			element.clear();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// Verify Page Title

	public boolean verifyPageTitle(String title) {

		return driver.getTitle().trim().contains(title);
	}

	// Wait for expected Page Title

	public void waitForExpectedTitle(String title) {

		System.out.println("ExpectedTittle-" + title + "-");

		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;

		while (elapsedTime < 180) {

			System.out.println("Tittle-" + driver.getTitle() + "-");

			if (driver.getTitle().equalsIgnoreCase(title))
				break;
			else
				elapsedTime = (new Date().getTime() / 1000) - (startTime / 1000);

		}

	}

}
