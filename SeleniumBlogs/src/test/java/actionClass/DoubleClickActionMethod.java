package actionClass;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickActionMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String Url;

		driver.get("https://www.flipkart.com");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));

		Url = driver.getCurrentUrl();

		Assert.assertTrue(Url.contains("flipkart"));

		System.out.println("Successfully navigated to Flipkart webpage");

		//create an object for the Actions class and pass the driver argument 
		Actions action = new Actions(driver);

		//Ignore the sign in option 
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();

		//Locate the menu item
		WebElement elementMenu = driver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));	
		action.moveToElement(elementMenu).doubleClick();
	}

}
