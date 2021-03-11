package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
	
	public static WebElement searchBox(WebDriver driver) {
	
	WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
	
	return searchBox;

	}
	
	public static WebElement searchBtt(WebDriver driver) {
		
		WebElement searchBtt = driver.findElement(By.xpath("//input[@name='btnK']"));
		
		return searchBtt;

		}
	
}
