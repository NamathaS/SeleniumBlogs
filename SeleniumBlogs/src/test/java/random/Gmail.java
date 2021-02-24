package random;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.adobe.com/nz/");
		System.out.println("title"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Create an account']")).click();
		
		Random rand = new Random();
		int number = rand.nextInt(15);
		String user = "TestAccount"+number+"@owlymail.com";
		driver.findElement(By.id("Signup-EmailField")).sendKeys(user);
		driver.findElement(By.name("firstname")).sendKeys("Selenium");
		driver.findElement(By.name("lastname")).sendKeys("Test Account");
		driver.findElement(By.name("password")).sendKeys("ItsJustAPassword123");
		
		
//		if(driver.findElement(By.xpath("//section[@id='Signup-PasswordStrength']")).isDisplayed()) {
			//Thread.sleep(1000);
		
		 WebDriverWait wait2 = new WebDriverWait(driver, 10);

		 WebElement Months = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='Signup-DateOfBirthChooser-Month-value']")));
//		}
		 driver.findElement(By.xpath("//span[@id='Signup-DateOfBirthChooser-Month-value']")).click();
		 
		//WebElement Months = driver.findElement(By.xpath("//button[@id='Signup-DateOfBirthChooser-Month']"));
		//Months.click();
//		WebDriverWait wait1 = new WebDriverWait(driver, 5); 
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='April']")));  
//		
		WebElement month = driver.findElement(By.xpath("//span[normalize-space()='April']"));
//		
		month.click();
//				
//		driver.findElement(By.name("day")).sendKeys("19");
//		driver.findElement(By.name("year")).sendKeys("1987");
//		
//		WebElement countries = driver.findElement(By.id("Signup-CountryChooser-value"));
//		countries.click();
//		WebDriverWait wait = new WebDriverWait(driver, 5); 
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Niger']")));  
//		//identify menu option from the resulting menu display 
//		WebElement menuOption = driver.findElement(By.xpath("//span[normalize-space()='Niger']"));
//		//Click the item from sub menu
//		menuOption.click();
//		
//		driver.findElement(By.xpath("//span[@class='spectrum-Button-label']")).click();
//		
		
		

	}

}
