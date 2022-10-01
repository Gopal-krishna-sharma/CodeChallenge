package testClasses;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import pageObjects.LoginPageObjects;
import utils.BrowserActions;

public class BaseTest {

	public static WebDriver driver = null;
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest logger;
	BrowserActions browserAction;
	LoginPageObjects LoginPgObj;

	@BeforeSuite
	public void beforeSuite() {
		browserAction = new BrowserActions(driver);

	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
		driver.close();

	}

	@BeforeMethod
	public void beforeMethod(Method testMethod) {
		logger = extentReport.createTest(testMethod.getName());
		System.out.println("Test name: " + testMethod.getName());

	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Failed");
		}

	}

	@BeforeTest
	public void beforeTest() {
		setupDriver("chrome");
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "AspireReport.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Aspire Automation Report");
		htmlReporter.config().setReportName("Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Automation QA", "Gopal");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After test");
		extentReport.flush();

	}

	public void setupDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://codechallenge.odoo.com/");
		}

	}

}
