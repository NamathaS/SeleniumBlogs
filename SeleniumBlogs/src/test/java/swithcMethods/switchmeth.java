package swithcMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchmeth {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);
		
		
		//switchToAlertBoxes(driver);
		//switchManyAlers(driver);
		switchToFrame(driver);
		switchToAnotherWindow(driver);
		driver.close();
		driver.quit();
	}

	private static void switchManyAlers(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to website
		driver.get("https://demoqa.com/alerts");
		System.out.println("Website is opened ");
		
		//First Alert Box 
		System.out.println("First Alert box");
		driver.findElement(By.id("alertButton")).click();
		System.out.println("First alert message is accepted..");
		
		//Navigate to Alert message
		driver.switchTo().alert().accept();
		
		//Second Alert Box 
		System.out.println("");
		System.out.println("Second Alert box");
		driver.findElement(By.id("timerAlertButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("Second timed alert message is accepted..");
		
		//Third Alert Box 
		System.out.println("");
		System.out.println("Third Alert box - Accept Alert ");
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		System.out.println("Accepted value :"+driver.findElement(By.id("confirmResult")).getText());

		
		System.out.println("");
		System.out.println("Third Alert box - Dismiss Alert ");
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Accepted value :"+driver.findElement(By.id("confirmResult")).getText());
		
		driver.navigate().refresh();
		//Fourth Alert Box 
		System.out.println("");
		System.out.println("Fourth  Accept box ");
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Namatha");
		driver.switchTo().alert().accept();
		System.out.println("Prompt message : "+driver.findElement(By.id("promptResult")).getText());
		
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

	private static void switchToAlertBoxes(WebDriver driver) {
		// TODO Auto-generated method stub
			
		//Navigate to website
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		System.out.println("Website is opened ");
		
		//Click on Third Party Button
		driver.findElement(By.id("thirdPartyButton")).click();
		System.out.println("Accept the agreement ");
		System.out.println("");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("thirdPartyResponseMessage")).getText());
		System.out.println("");
		
		System.out.println("Dismiss the agreement ");
		System.out.println("");
		driver.findElement(By.id("thirdPartyButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("thirdPartyResponseMessage")).getText());
				
		/*
		 * driver.close(); System.out.println("Browser closed after");
		 */
	}

	private static void switchToAnotherWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		
		//Navigate to website
		driver.get("https://manage.wix.com/account/sites");
		System.out.println("Website is opened ");
		
		
	}

}
