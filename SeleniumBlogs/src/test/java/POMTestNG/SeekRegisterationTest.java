package POMTestNG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.SeekRegistration;

public class SeekRegisterationTest {

	SeekRegistration Reg ;
	static String UserName;
	WebDriver driver ;
	
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
	public void Register() {
		Random random = new Random();
		int RandomNumber = random.nextInt(20);
		UserName = "TestAccount"+RandomNumber+"@cuentemelo.com";
		
		Reg = new SeekRegistration(driver);
		
		Reg.verifySeekHome();
		Reg.clickRegisterLink();
		Reg.enterFirstName("Test");
		Reg.enterLastName("Account");
		Reg.enterEmail(UserName);
		Reg.enterPassword("seleniumautomation");
		Reg.clickRegisterButton();
		Reg.verifyRegisterationPage();
		Reg.enterJobTitle("Automation Engineer");
		Reg.enterCompany("Fake Test Company");
		Reg.selectStartMonth(3);
		Reg.selectStartYear(6);
		Reg.selectEndMonth("9");
		Reg.selectEndYear("2019");
		Reg.selectLocation("Auckland");
		Reg.selectPrimaryClassification("Information & Communication Technology");
		Reg.selectSubClassification("Testing & Quality Assurance");
		Reg.selectVisibility("Limited");
		Reg.clickSaveButton();
		Reg.verifyRegistrationOnboardPage();
		Reg.clickContinue();
		Reg.verifyRegistrationOnboardPage();
		
		try {
			Thread.sleep(5000);
			delteAccount();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	private void delteAccount() {
		// TODO Auto-generated method stub
		Reg.clickProfile();
		Reg.clicksettings();
		Reg.clickDeletespan();
		Reg.enterConfirmPassword("seleniumautomation");
		Reg.clickDeleteButton();
		Reg.verifyDeleteConfirmation();
	}
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
	

}
