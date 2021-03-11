package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObjects.GoogleSearchPageObject;

public class Test_GoogleSearchPageObject {
	WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;

	@BeforeSuite
	public void init() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/Spark/Spark.html");
		extent.attachReporter(spark);
	}

	@BeforeTest
	public void setUp() throws IOException {
		String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// driver= DriverConfigures.getDriver();
	}

	@Test
	public void testSearch() {
		test = extent.createTest("Google Search Test");
		test.log(Status.INFO, "Start a search on google");
		googleSearch("ABCDE");

	}

	public void googleSearch(String searchItem) {
		GoogleSearchPageObject gschObj = new GoogleSearchPageObject(driver);

		// launch google search
		test.info("Navigate to google search page");
		driver.get("https://www.google.ca/");

		// Enter search item into search box
		test.info("Enter search item");
		gschObj.setTextForsSearchBox(searchItem);

		// Click Enterkey
		test.info("Click search button");
		gschObj.clickSearchBtt();

		test.addScreenCaptureFromPath("screenshot.png");

	}

	@AfterTest
	public void tearDown() {
		// Close blowser
		System.out.println("Succeed!!");
		driver.close();
	}

	@AfterSuite
	public void turnOff() {
		extent.flush();
	}
}
