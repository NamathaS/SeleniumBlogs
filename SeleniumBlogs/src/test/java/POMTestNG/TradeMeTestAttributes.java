package POMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.TrademeHome;

public class TradeMeTestAttributes {

	WebDriver driver;
	TrademeHome Home;

	@Test	
	public void initialSetUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.trademe.co.nz");
		//Navigate to web page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Home = new TrademeHome(driver);
	}
	
	@Test(description = "This test is to naviagte to the website ")
	public void navigateToWebPage() {
		Home.waitToLoad();
		Home.verifyTradeMeHome();
	}

	@Test(description = "This test is to register")
	public void ClickRegistration() {
		Home.clickRegisterLink();
		Home.waitToLoad();
		Home.verifyRegistrationPage();
		Home.navigateBack();
	}

	@Test(description = "This test is to login")
	public void ClickLogin() {
		Home.clickLoginLink();
		Home.waitToLoad();
		Home.verifySignInPage();
		Home.navigateBack();
	}
	
	@Test(description = "This test is to search some thing ")
	public void SearchSomething() {
		Home.enterSearchElement("car");
		Home.waitToLoad();
		Home.clickSearchButton();
		Home.waitToLoad();
		Home.navigateBack();
	}
	
	@Test(description = "This test is to display cart")
	public void displayCart() {
		Home.clickCartButton();
		Home.waitToLoad();
		Home.verifySignInPage();
		Home.navigateBack();
	}
	
	@Test(description = "This test is to tidy up the driver", dependsOnMethods = {"initialSetUp"})
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
