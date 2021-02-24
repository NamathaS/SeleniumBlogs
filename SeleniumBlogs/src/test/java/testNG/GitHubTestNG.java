package testNG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubTestNG {

	WebDriver driver;
	String Title, Match ,Repo_Owner, Repo_Name,confirm_Repo;

	@BeforeClass
	public void  InitialSetUp() {
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
	}
	@Test(priority=-10)
	public void navigateToGitHub() {
		
		driver.get("https://github.com/login");	
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Title = driver.getTitle();
		
		Match = "Sign in to GitHub";
		
		validateCurrentTitleOrUrl(Title,Match);
				
		System.out.println("Website has opened ... ");
	}
	@Test(priority= 0)
	public void loginToGitHub() {

		//Enter user name  
		driver.findElement(By.id("login_field")).sendKeys("onlyfortestingautomation@gmail.com");
		
		//Enter password 
		driver.findElement(By.id("password")).sendKeys("seleniumautomation");
		
		//Login to git hub
		driver.findElement(By.name("commit")).click();
		
		Title = driver.getTitle();
		
		Match = "GitHub";
		
		validateCurrentTitleOrUrl(Title,Match);
		
		System.out.println("Successfully logged in into github");
	}
	@Test(priority= 10)
	public void createNewRepo() {
		
	
		WebElement CreateRepo = driver.findElement(By.linkText("New"));
		
		Assert.assertTrue(CreateRepo.isDisplayed());
		
		//Create new repository 
		CreateRepo.click();
			
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		Title = driver.getTitle();
		
		Match = "Create";
		
		validateCurrentTitleOrUrl(Title,Match);
		
		System.out.println("Successfully created new repository");
		
		//Get the user name 
		Repo_Owner = driver.findElement(By.id("repository-owner")).getText();
		
		Random randomno = new Random();
		
		int number =randomno.nextInt(15);
		
		Repo_Name = "TestRepo"+number;
		
		driver.findElement(By.id("repository_name")).sendKeys(Repo_Name);
		
		driver.findElement(By.id("repository_description")).sendKeys("Test Automation");
		
		driver.findElement(By.id("repository_visibility_public")).click();
		
		driver.findElement(By.id("repository_auto_init")).click();
		
		WebElement CreateRepository = driver.findElement(By.xpath("//button[normalize-space()='Create repository']"));
		
		if(CreateRepository.isDisplayed())
		{
			
			CreateRepository.submit();
		}
		
		Title = driver.getTitle();
		
		validateCurrentTitleOrUrl(Title,Repo_Name);
		
	}
	@Test(priority =20)
	public void deleteRepo() {
		
		driver.findElement(By.xpath("//span[@data-content='Settings']")).click();
		
		Match = Repo_Name+"/settings";
		
		Title =driver.getCurrentUrl();
		
		validateCurrentTitleOrUrl(Title,Match);
		
		driver.findElement(By.xpath("//summary[normalize-space()='Delete this repository']")).click();
		
		confirm_Repo = Repo_Owner+"/"+Repo_Name;
		
		WebElement ConfirmRepoTextBox = driver.findElement(By.xpath("//input[@aria-label='Type in the name of the repository to confirm that you want to delete this repository.']"));
		
		ConfirmRepoTextBox.sendKeys(confirm_Repo);
		
		WebElement ConfirmationButton =driver.findElement(By.xpath("//span[contains(text(),'I understand the consequences, delete this reposit')]"));
		
		ConfirmationButton.click();
		
		Title = driver.getTitle();
		
		Match = "GitHub";
		
		validateCurrentTitleOrUrl(Title,Match);
		
		System.out.println("Successfully deleted Repository");
	
	}
	@Test(priority=30)
	public void signOutGitHub() {
		
		driver.findElement(By.xpath("//summary[@aria-label='View profile and more']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign out')]")).click();
		
		Title = driver.getTitle();
		
		Match = "GitHub";
		
		validateCurrentTitleOrUrl(Title,Match);
		
		System.out.println("Successfully Signed out from user account ");
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();
		
		driver.quit();
	}
	
	public void validateCurrentTitleOrUrl(String stringToValidate, String match) {
		
		Assert.assertTrue(stringToValidate.contains(match));
	}
	
	
}
