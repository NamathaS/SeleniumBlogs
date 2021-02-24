package POMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.TradeMeRegistration;

public class TradeMeRegisteration {

	WebDriver driver;

	@BeforeTest
	public void initialSetUp() {

		WebDriverManager.chromedriver().setup();

		//ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		//op.addArguments("--disable-notifications");

		driver = new ChromeDriver();

		//Navigate to web page
		driver.get("https://www.trademe.co.nz");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void Register() {
		
		TradeMeRegistration Reg = new TradeMeRegistration(driver);
		
		Reg.clickLinkRegister();
		Reg.enterEmail("onlyfortestingautomation@gmail.com");
		Reg.enterPassword("seleniumautomation");
		Reg.enterPasswordConfirmation("seleniumautomation");
		Reg.enterUserName("Selenium1005");
		Reg.enterFirstName("Selenium");
		Reg.enterLastname("TestAccount");
		Reg.selectFemale();
		Reg.selectBirthDay("5");
		Reg.selectBirthMonth("10");
		Reg.selectPhoneExt("021");
		Reg.enterPhoneNumber("2102246069");
		Reg.selectNZRadio();
		Reg.enterAddressSearch("2/1334 Dominion Road, Mount Roskill, Auckland 1041");
		Reg.selectCloseDistricts("Auckland - Auckland City");
		Reg.checkAgeCheckBox();
		Reg.clickCreateAccount();
	}
}
