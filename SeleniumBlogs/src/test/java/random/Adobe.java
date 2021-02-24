package random;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adobe {

	public static void main(String[] args) {
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
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[normalize-space()='Create an account']")).click();
		
		Random rand = new Random();
		int number = rand.nextInt(15);
		String user = "SeleniumTestAccount"+number+"@owlymail.com";
		String Password ="ItsJustPassword"+number;
		driver.findElement(By.id("Signup-EmailField")).sendKeys(user);
		driver.findElement(By.id("Signup-FirstNameField")).sendKeys("Namatha");
		driver.findElement(By.id("Signup-LastNameField")).sendKeys("Scavish");
	//	driver.findElement(By.id("Signup-PasswordField")).sendKeys("Ns971505951939!");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='Signup-DateOfBirthChooser-Month-value']")));
		driver.findElement(By.xpath("//span[@id='Signup-DateOfBirthChooser-Month-value']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='June']")));
		driver.findElement(By.xpath("//span[normalize-space()='March']")).click();
		driver.findElement(By.id("Signup-PasswordField")).sendKeys(Password);
		driver.findElement(By.name("day")).sendKeys("9");
		driver.findElement(By.name("year")).sendKeys("1989");
		//driver.findElement(By.id("Signup-CountryChooser")).click();
		//driver.findElement(By.xpath("//span[@class='spectrum-Menu-itemLabel'][normalize-space()='New Zealand']")).click();
		WebElement countries = driver.findElement(By.id("Signup-CountryChooser-value"));
		countries.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 5); 
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Niger']")));  
		//identify menu option from the resulting menu display 
		WebElement menuOption = driver.findElement(By.xpath("//span[normalize-space()='Niger']"));
		//Click the item from sub menu
		menuOption.click();
		

		driver.findElement(By.xpath("//span[@class='spectrum-Button-label']")).click();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//a[@aria-label='Namatha Scavish']")).click();
		
		driver.findElement(By.xpath("//span[@class='Profile-header-cta']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//a[@class='app-nav-menu-item'][normalize-space()='Profile']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//span[normalize-space()='Privacy']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);

		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("PasswordPage-PasswordField")).sendKeys(Password);
		
		driver.findElement(By.xpath("//button[@aria-label='Continue']")).click();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--cta']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//input[@class='spectrum-Checkbox-input']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//button[@class='spectrum-Button spectrum-Button--warning']")).click();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[normalize-space()='Continue to New Zealand']")).click();
	
	}

}
