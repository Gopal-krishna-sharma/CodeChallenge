package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserActions;

public class ManufacturingPageObjects {

	WebDriver driver = null;

	BrowserActions browserAction = null;

	/**
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor - Initialize driver
	 * 
	 * @param driver - WebDriver object
	 * 
	 * * * * * * * * * * * * * * * * * * * * * * * * *
	 */

	public ManufacturingPageObjects(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		browserAction = new BrowserActions(driver);

	}

	/**
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 * MANUFACTURING PAGE OBJECTS
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 */

	// Create manufacturing order button

	@FindBy(how = How.CSS, using = "button[data-original-title='Create record']")
	private WebElement CreateOrderBtn;

	// Product name input

	@FindBy(how = How.CSS, using = "div[name=product_id] input[type=text]")
	private WebElement EnterProduct;

	// Save button

	@FindBy(how = How.CSS, using = "button[title='Save record']")
	private WebElement SaveBtn;

	// Confirm button

	@FindBy(how = How.CSS, using = "button[name='action_confirm']")
	private WebElement ConfirmBtn;

	// Quantity update button

	@FindBy(how = How.CSS, using = "div > span[name=product_qty]")
	private WebElement QtyUpdateBtn;

	// Input quantity to be updated

	@FindBy(how = How.CSS, using = "button input[name=product_qty]")
	private WebElement QtyUpdateInput;

	// Mark done button

	@FindBy(how = How.CSS, using = "div button[name=button_mark_done][class='btn btn-primary']")
	private WebElement MarkDoneBtn;

	// Ok button for confirmation pop-up

	@FindBy(how = How.CSS, using = "Footer button[class='btn btn-primary']")
	private WebElement ConfirmationOKBtn;

	// Method - To create manufacturing order

	public void CreateManufacturingOrder() {
		browserAction.click(CreateOrderBtn);
		browserAction.setText(EnterProduct, "CheeseBurger1010");
		browserAction.click(SaveBtn);
		browserAction.click(ConfirmBtn);
		browserAction.click(QtyUpdateBtn);
		browserAction.setText(QtyUpdateInput, "2");
		browserAction.click(SaveBtn);
		browserAction.click(MarkDoneBtn);
		browserAction.click(ConfirmationOKBtn);
	}

}
