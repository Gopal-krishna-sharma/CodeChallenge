package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserActions;

public class InventoryPageObjects {

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

	public InventoryPageObjects(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		browserAction = new BrowserActions(driver);

	}

	/**
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 * INVENTORY PAGE OBJECTS
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 */

	// Product link in header menu bar

	@FindBy(how = How.CSS, using = "[title=Products] span")
	private WebElement ProductsMenuBtn;

	// Product option in dropdown

	@FindBy(how = How.XPATH, using = "//div/a[text()='Products']")
	private WebElement ProductsLink;

	// Create button

	@FindBy(how = How.CSS, using = "button[title='Create record']")
	private WebElement CreateBtn;


	//Product name input field
	
	@FindBy(how = How.CSS, using = "input[name='name']")
	private WebElement ProductNameInput;

	// Save button

	@FindBy(how = How.CSS, using = "button[title='Save record']")
	private WebElement SaveBtn;

	// Update Quantity link

	@FindBy(how = How.CSS, using = "button[name='action_update_quantity_on_hand'] span")
	private WebElement UpdQtyLink;

	// Create quantity button

	@FindBy(how = How.CSS, using = "button[data-original-title='Create record']")
	private WebElement CreateQtyBtn;

	// Quantity input
	
	@FindBy(how = How.CSS, using = "input[name='inventory_quantity']")
	private WebElement CountedQtyUpdate;
	
	// Save quantity button

	@FindBy(how = How.CSS, using = "button[title='Save record']")
	private WebElement SaveQtyBtn;

	// Navigation link for landing page
	
	@FindBy(how = How.CSS, using = "header nav a[title='Home menu']")
	private WebElement NavToLandingLink;
	
	
	//Method - To navigate to Product creation page
	
	public void NavToProduct() {
		browserAction.click(ProductsMenuBtn);
		browserAction.click(ProductsLink);
	}

//******************************************************************************************************************
	
	//Method - To create a product 
	
	public void CreateProduct() {
		browserAction.click(CreateBtn);
		browserAction.setText(ProductNameInput, "CheeseBurger1100");
		browserAction.click(SaveBtn);
	}

	//Method - To update Product quantity 
	
	public void UpdateProductQty() {
		browserAction.click(UpdQtyLink);
		browserAction.click(CreateQtyBtn);
		browserAction.setText(CountedQtyUpdate, "11");
		browserAction.click(SaveQtyBtn);
	}
	
	//Method - To navigate to landing page
	
	public void NavigationToLandingPage() {
		browserAction.click(NavToLandingLink);
	}
}
