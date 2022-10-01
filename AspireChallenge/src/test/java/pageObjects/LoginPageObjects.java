package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserActions;

public class LoginPageObjects {

	WebDriver driver 				= null;
	BrowserActions browserAction 	= null;

	/**
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * Constructor - Initialize driver
	 * 
	 * @param driver - WebDriver object
	 * 
	 *               * * * * * * * * * * * * * * * * * * * * * * * *
	 */

	public LoginPageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		browserAction = new BrowserActions(driver);
	}

	/**
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 * CODECHALLENGE LOGIN PAGE OBJECTS
	 * *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
	 */

	// Enter username

	@FindBy(how = How.CSS, using = "input#login")
	private WebElement emailInput;

	// Enter Password

	@FindBy(how = How.CSS, using = "input#password")
	private WebElement pwdInput;

	// Click on Login Button

	@FindBy(how = How.CSS, using = "button[type=submit]")
	private WebElement loginBtn;

	// Method - To signin to the portal

	public void SignIn() {
		try {
			browserAction.WaittoPageLoad();
			
			browserAction.setText(emailInput, "user@codechallenge.app");

			browserAction.setText(pwdInput, "@sp1r3app");

			browserAction.click(loginBtn);
			
			browserAction.WaittoPageLoad();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
