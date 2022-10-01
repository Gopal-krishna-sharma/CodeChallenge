package testClasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.InventoryPageObjects;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ManufacturingPageObjects;



public class TestClass extends BaseTest

{
	
	LoginPageObjects LoginPgObj = new LoginPageObjects(driver);
	InventoryPageObjects InvPgObj = new InventoryPageObjects(driver);
	ManufacturingPageObjects MfngPgObj = new ManufacturingPageObjects(driver);
	LandingPageObjects LndgPgObj = new LandingPageObjects(driver);

	
	
	@Test
	
	public void AppLogin() throws InterruptedException {

		LoginPgObj.SignIn();
	}

	
}
