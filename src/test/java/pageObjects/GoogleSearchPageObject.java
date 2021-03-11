package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPageObject {
	private WebDriver driver;
	//By searchBox = By.xpath("//input[@name='q']");
	//By searchBtt = By.xpath("//input[@name='btnK']");
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextForsSearchBox(String text) {

		WebDriverWait wait = new WebDriverWait(driver, 300);
		WebElement sb = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='q']")));
		sb.sendKeys(text);

	}

	public void clickSearchBtt() {

		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.ENTER);

	}

}
