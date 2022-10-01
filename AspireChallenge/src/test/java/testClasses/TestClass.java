package testClasses;

import org.testng.annotations.Test;
import pageObjects.InventoryPageObjects;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.ManufacturingPageObjects;

public class TestClass extends BaseTest

{
	
	
	@Test(priority = 1)
	public void AppLogin() throws InterruptedException {
		LoginPageObjects LoginPgObj = new LoginPageObjects(driver);
		LoginPgObj.SignIn();
	}

	@Test(priority = 2)
	public void NavToInventory() {

		LandingPageObjects LndgPgObj = new LandingPageObjects(driver);
		LndgPgObj.NavToInventory();

	}

	
	@Test(priority = 3)
	public void CreateProduct() {
		
		InventoryPageObjects InvPgObj = new InventoryPageObjects(driver);
		InvPgObj.NavToProduct();
		InvPgObj.CreateProduct();
		InvPgObj.UpdateProductQty();
		InvPgObj.NavigationToLandingPage();
	}

	@Test(priority = 4)
	public void NavToManufacturing() {
		LandingPageObjects LndgPgObj = new LandingPageObjects(driver);
		LndgPgObj.NavToManufacturing();

	}

	@Test(priority = 5)
	public void CreateManufacturingOrder() {

		ManufacturingPageObjects MfngPgObj = new ManufacturingPageObjects(driver);
		MfngPgObj.CreateManufacturingOrder();

	}

}
