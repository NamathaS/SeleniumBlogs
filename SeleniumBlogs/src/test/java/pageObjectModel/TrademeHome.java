package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrademeHome {
	
	WebDriver driver;

	@FindBy(linkText ="Register")
	WebElement Lnk_Register;
	
	@FindBy(id="LoginLink")
	WebElement Lnk_Login;
	
	@FindBy(id="searchString")
	WebElement Txt_SearchElement;
	
	@FindBy(id="SearchType")
	WebElement BtnSearchType;
	
	@FindBy(xpath="//button[@value='Search']")
	WebElement SearchButton;
	
	@FindBy(id="cart-button")
	WebElement Btn_Cart;
	
	@FindBy(id="SearchTabs1_MarketplaceLink")
	WebElement Tab_MarketPlace;
	
	@FindBy(id="SearchTabs1_JobsLink")
	WebElement Tab_JobSearch;
	
	@FindBy(id="SearchTabs1_MotorsLink")
	WebElement Tab_Motors;
	
	@FindBy(id="SearchTabs1_PropertyLink")
	WebElement Tab_Property;
	
	@FindBy(id="SubmitButton")
	WebElement Btn_CreateAccount;
	
	@FindBy(id="SignIn")
	WebElement Btn_Signin;
	
	public TrademeHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickRegisterLink() {
		Lnk_Register.click();
		System.out.println("Registration :"+driver.getTitle());
	}
	
	public void clickLoginLink() {
		Lnk_Login.click();
		System.out.println("Login :"+driver.getTitle());
	}
	
	public void enterSearchElement(String value) {
		Txt_SearchElement.sendKeys(value);
	}
	
	public void clickSearchButton() {
		SearchButton.click();
	}
	
	public void clickCartButton() {
		Btn_Cart.click();
	}

	public void clickTab_MarketPlace() {
		Tab_MarketPlace.click();
		System.out.println("Tab_MarketPlace :"+driver.getTitle());
	}
	
	public void clickTab_JobSearch() {
		Tab_JobSearch.click();
		System.out.println("Tab_search :"+driver.getTitle());
	}
	
	public void clickTab_Motors() {
		Tab_Motors.click();
		System.out.println("Tab_motors :"+driver.getTitle());
	}
	
	public void clickTab_Property() {
		Tab_Property.click();
		System.out.println("Tab property :"+driver.getTitle());
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void verifyRegistrationPage() {
		Assert.assertTrue(Btn_CreateAccount.isDisplayed());
	}
	
	public void verifyTradeMeHome() {
		Assert.assertTrue(driver.getCurrentUrl().contains("trademe"));
	}
	
	public void verifySignInPage() {
		Assert.assertTrue(Btn_Signin.isDisplayed());
	}
	
	public void verifyMarketTab() {
		System.out.println("mark  "+driver.getCurrentUrl());
		//Assert.assertTrue(driver.getCurrentUrl().contains("marketplace"));
	}
	
	public void verifyPropertyTab() {
		System.out.println("prop  "+driver.getCurrentUrl());
		//Assert.assertTrue(driver.getCurrentUrl().contains("property"));
	}
	public void verifyJobTab() {
		System.out.println("jon  "+driver.getCurrentUrl());
		//Assert.assertTrue(driver.getCurrentUrl().contains("jobs"));
	}
	
	public void verifyMotorsTab() {
		System.out.println("motor  "+driver.getCurrentUrl());
		//Assert.assertTrue(driver.getCurrentUrl().contains("motors"));
	}
	public void waitToLoad() {
		System.out.println("Wait for page to load ... ");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
