package random;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class github {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();

		String Repo_Owner, Repo_Name,confirm_Repo;
		driver.get("https://github.com/login");
		System.out.println("title"+driver.getTitle());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.id("login_field")).sendKeys("onlyfortestingautomation@gmail.com");
		driver.findElement(By.id("password")).sendKeys("seleniumautomation");
		driver.findElement(By.name("commit")).click();
		System.out.println("title"+driver.getTitle());
		
		driver.findElement(By.linkText("New")).click();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Repo_Owner = driver.findElement(By.id("repository-owner")).getText();
		Random randomno = new Random();
		int number =randomno.nextInt(15);
		Repo_Name = "TestRepo"+number;
		driver.findElement(By.id("repository_name")).sendKeys(Repo_Name);
		
		driver.findElement(By.id("repository_description")).sendKeys("Test Automation");
		
		driver.findElement(By.id("repository_visibility_public")).click();
		driver.findElement(By.id("repository_auto_init")).click();
		
		if(driver.findElement(By.xpath("//button[normalize-space()='Create repository']")).isDisplayed())
		{
			System.out.println("enabled ");
			driver.findElement(By.xpath("//button[normalize-space()='Create repository']")).submit();
		}
		
		driver.findElement(By.xpath("//span[@data-content='Settings']")).click();
		driver.findElement(By.xpath("//summary[normalize-space()='Delete this repository']")).click();
		confirm_Repo = Repo_Owner+"/"+Repo_Name;
		driver.findElement(By.xpath("//input[@aria-label='Type in the name of the repository to confirm that you want to delete this repository.']")).sendKeys(confirm_Repo);
		driver.findElement(By.xpath("//span[contains(text(),'I understand the consequences, delete this reposit')]")).click();
		
		driver.findElement(By.xpath("//summary[@aria-label='View profile and more']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		
		driver.close();
		driver.quit();
	}

}
