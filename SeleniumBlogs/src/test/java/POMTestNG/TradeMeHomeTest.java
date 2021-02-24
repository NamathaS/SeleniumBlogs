package POMTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectModel.TrademeHome;

public class TradeMeHomeTest {

	WebDriver driver;
	TrademeHome Home;

	@BeforeGroups
	public void initialSetUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.trademe.co.nz");
		//Navigate to web page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Home = new TrademeHome(driver);
	}
	
	@Test(groups= {"sanity", "regression"}, priority = -1)
	public void navigateToWebPage() {
		Home.waitToLoad();
		Home.verifyTradeMeHome();
	}

	@Test(groups= {"sanity"}, priority = 0)
	public void ClickRegistration() {
		Home.clickRegisterLink();
		Home.waitToLoad();
		Home.verifyRegistrationPage();
		Home.navigateBack();
	}

	@Test(groups= {"regression"}, priority = 1)
	public void ClickLogin() {
		Home.clickLoginLink();
		Home.waitToLoad();
		Home.verifySignInPage();
		Home.navigateBack();
	}
	
	@Test(groups= {"retesting"}, priority = 10, enabled = true)
	public void SearchSomething() {
		Home.enterSearchElement("car");
		Home.waitToLoad();
		Home.clickSearchButton();
		Home.waitToLoad();
		Home.navigateBack();
	}
	
	@Test(groups= {"sanity"}, priority = 10, enabled = false)
	public void displayCart() {
		Home.clickCartButton();
		Home.waitToLoad();
		Home.verifySignInPage();
		Home.navigateBack();
	}
	
	@AfterGroups(groups = {"sanity"})
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}
