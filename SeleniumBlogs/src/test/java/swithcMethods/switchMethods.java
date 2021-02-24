package swithcMethods;

import java.time.Duration;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchMethods {
	
	//public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		
		
		//swithcToAlertBox();
		switchToFrame(driver);
		switchToAnotherWindow(driver);
		
		driver.close();
		
		driver.quit();
	}

	private static void switchToFrame(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to web page 
		driver.get("https://www.reddit.com");
		System.out.println("Successfully navigated to reddit ");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Log In")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("loginUsername")).sendKeys("testselenium");
		driver.findElement(By.id("loginPassword")).sendKeys("seleniumautomation");
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
		System.out.println("Successfully logged into reddit ");
		driver.findElement(By.className("_2BMnTatQ5gjKGK5OWROgaG")).click();
		
		driver.findElement(By.xpath("//div[normalize-space()='Log Out']")).click();
		System.out.println("Successfully logged out from  reddit ");
	
	}

	private static void swithcToAlertBox() {
		// TODO Auto-generated method stub
		
	
	}

	private static void switchToAnotherWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to parent window
		driver.navigate().to("https://manage.wix.com/account/sites");
		System.out.println("Successfully opened Parent Window");
		
		//Get parent window handle 
		String ParentHandle = driver.getWindowHandle();
		System.out.println("Parent page handle is :"+ParentHandle);
		System.out.println("");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Navigate to another page
			
		driver.findElement(By.xpath("//span[normalize-space()='Continue with Google']")).click();
		
		Set<String> AllWindowHandles = driver.getWindowHandles();
		
		//iterate through all open windows and take control to the last / new window
		for(String Handle:AllWindowHandles) {
			
			driver.switchTo().window(Handle);
			System.out.println("Current Window Title : "+driver.getTitle());
			
		}
		
		System.out.println("Total number of windows opened .. :"+AllWindowHandles.size());
		
		//Get New Window handle 
		String ChildHandle = driver.getWindowHandle();
		System.out.println("Child page handle is :"+ChildHandle);
		System.out.println("Current Child Window Title : "+driver.getTitle());
		System.out.println("");	
	}

}
