package wixExercise;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WixFirstResultInGoogleSearch {

	@Test
	public void testFirstResultInGoogleSearch() {
       
		String projectLocation = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.il/");
		
		//Let the user actually see something
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//SearchBox element - Types "Wix" AND submits
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Wix");
		searchBox.submit();
		
		//Get all search results in a list
	    List<WebElement> result = driver.findElements(By.xpath("//div[@class='r']/a/h3"));
		//Click the first element in the list (first record)
	    result.get(0).click();
	    	    
		//Wait for page load in selenium
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	    String URL = driver.getCurrentUrl();
	    
	    //Checks if CurrentURL & Wix URL are equal (if not, Print URL value)
	    assertTrue("value doesnt match: "+ URL,URL.contains("https://www.wix.com"));
	    driver.quit();
	}

}
