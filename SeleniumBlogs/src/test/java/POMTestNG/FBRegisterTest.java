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

public class FBRegisterTest {

	
	WebDriver driver;
	FBHomeWithParameters fb;
	
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
	
	@Parameters({"FirstName","LastName","UserName","Password","Date","Month","Year","Sex"})
	@Test
	public void Register(String FirstName,String LastName,String UserName,String Password,String Date,int Month,String Year,int Sex) {
			
		fb = new FBHomeWithParameters(driver);
			
		fb.click_CreateAccount();
		fb.enterFirstName(FirstName);
		fb.enterLastName(LastName);
		fb.enterEmail(UserName);
		fb.enterConfirmationEmail(UserName);
		fb.enterPassword(Password);
		fb.selectBirthday(Date);
		fb.selectBirthMonth(Month);
		fb.selectBirthYear(Year);
		fb.chooseGender(Sex);
		fb.click_FormSubmit();
		fb.verifyAccountCreated();		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
