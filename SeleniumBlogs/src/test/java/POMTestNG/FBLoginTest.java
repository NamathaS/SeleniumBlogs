package POMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.FBHomeWithParameters;

public class FBLoginTest {

	WebDriver driver;
	
	@BeforeTest
	public void initialSetUp() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");

		driver = new ChromeDriver(op);

		//Navigate to web page
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Parameters({"UserName","Password"})
	@Test
	public void Login(String UserName,String Password) {
		
		FBHomeWithParameters fb = new FBHomeWithParameters(driver);
		fb.enterUserName(UserName);
		fb.enterLoginPassword(Password);
		fb.clickLoginAccount();
		fb.verifyAccountLogIn();	
		fb.clickAccountLogout();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
