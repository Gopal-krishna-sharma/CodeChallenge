package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;

public class LandingPageObjects {

	WebDriver driver = null;
	BrowserActions browserAction = null;

	/**
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor - Initialize driver
	 * 
	 * @param driver - WebDriver object
	 * 
	 *               * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *               * * * * * *
	 */

	public LandingPageObjects(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
		browserAction = new BrowserActions(driver);
	}

	/**
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 * CODECHALLENGE LANDING PAGE OBJECTS
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 */

	// Inventory link

	@FindBy(how = How.XPATH, using = "*//a/div[text()='Inventory']")
	private WebElement inventoryLink;

	// Manufacturing link

	@FindBy(how = How.XPATH, using = "*//a/div[text()='Manufacturing']")
	private WebElement manufacturingLink;

	// Discuss link

	@FindBy(how = How.XPATH, using = "*//a/div[text()='Discuss']")
	private WebElement discussLink;

	// Navigation to Inventory section

	public void NavToInventory() {
		
		browserAction.click(inventoryLink);
	}

	// Navigation to manufacturing section

	public void NavToManufacturing() {
		browserAction.click(manufacturingLink);
	}

	// Navigation to Discussion section

	public void NavToDiscuss() {
		browserAction.click(discussLink);
	}

}
