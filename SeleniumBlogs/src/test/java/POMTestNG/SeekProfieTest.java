package POMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.SeekProfile;
import pageObjectModel.SeekRegistration;

public class SeekProfieTest {

	WebDriver driver ;
	
	SeekProfile profile;

	@BeforeTest
	public void launchapp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// Launch web site
		driver.get("https://www.seek.co.nz/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority =0)
	public void Login() {
		
		profile = new SeekProfile(driver);
		profile.clickSignin();
		profile.enterUserName("onlyfortestingautomation@gmail.com");	
		profile.enterLoginPassword("seleniumautomation");
		profile.clickLoginButton();
	}
	@Test(priority =10)
	public void LogOut() {
		
		profile.clickProfile();
		profile.clickSignOut();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
	
}
