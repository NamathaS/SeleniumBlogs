package waitMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitMethods {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.flipkart.com");
		//pageTimeOutMethod();
		implicitWaitMethod();
		setScriptTimeOutMethod();
		threadSleepMethod();
		explicitWaitMethod();
		fluentWaitMethod();
		//driver.close();
		//driver.quit();
	}

	private static void fluentWaitMethod() {
		// TODO Auto-generated method stub
	
		
	}

	private static void explicitWaitMethod() {
		// TODO Auto-generated method stub
			
	//	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("onlyfortestingautomation@gmail.com");
//		driver.findElement(By.id("input_0")).sendKeys("onlyfortestingautomation@gmail.com");
//		driver.findElement(By.id("input_1")).sendKeys("seleniumautomation");
//		driver.findElement(By.name("submit")).click();
		
	}

	private static void threadSleepMethod() {
		// TODO Auto-generated method stub
		
	}

	private static void setScriptTimeOutMethod() {
		// TODO Auto-generated method stub
		//driver.get("https://manage.wix.com/dashboard/df480b0f-82e8-4839-ac19-5fbd052d3f0f/home/?referralInfo=setup-progress-bar");
	//	driver.findElement(By.xpath("//span[normalize-space()='Continue with Google']")).click();
	//	driver.findElement(By.id("input_0")).sendKeys("onlyfortestingautomation@gmail.com");
		//driver.findElement(By.id("input_1")).sendKeys("seleniumautomation");
		//driver.findElement(By.name("submit")).click();;
		
	}

	private static void implicitWaitMethod() {
		// TODO Auto-generated method stub
		
	}

	private static void pageTimeOutMethod() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Mobiles')]")).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("mobile"));
		System.out.println("Successfully navigated to Mobile Phone Store ");
		driver.navigate().back();
		System.out.println("Successfully navigated to Mobile Phone Store ");
		Assert.assertTrue(driver.getCurrentUrl().contains("flipkart"));
		System.out.println("Successfully navigated back to Flipkart home page ");
	}

}
