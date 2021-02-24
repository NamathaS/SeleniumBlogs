package pageObjectModel;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FBHomeWithParameters {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Create New Account']")
	WebElement Btn_CreateAccount;
	
	@FindBy(name="firstname")
	WebElement Txt_FirstName;
	
	@FindBy(name="lastname")
	WebElement Txt_LastName;
	
	@FindBy(name="reg_email__")
	WebElement Txt_Email;
	
	@FindBy(name="reg_email_confirmation__")
	WebElement Txt_Confirm_Email;
	
	@FindBy(name="reg_passwd__")
	WebElement Txt_Req_Password;
	
	@FindBy(name="birthday_day")
	WebElement DD_Birthday;
	
	@FindBy(name="birthday_month")
	WebElement DD_BirthMonth;
	
	@FindBy(name="birthday_year")
	WebElement DD_BirthYear;
	
	@FindBy(name="sex")
	List<WebElement> Radio_Gender;
	
	@FindBy(name="websubmit")
	WebElement Btn_Submit;

	@FindBy(linkText="Log Out")
	WebElement Lnk_Logout;

	@FindBy(name="email")
	WebElement Txt_Username;
	
	@FindBy(name="pass")
	WebElement Txt_Password;
	
	@FindBy(name="login")
	WebElement Btn_Login;

	@FindBy(xpath="//div[@aria-label='Account']")
	WebElement Lnk_Account;
	
	@FindBy(id="recovery_code_entry")
	WebElement Txt_EnterCode;
	
	@FindBy(xpath="//span[normalize-space()='Log Out']")
	WebElement Lnk_AccountLogOut;
	
	public FBHomeWithParameters(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void click_CreateAccount() {
		Btn_CreateAccount.click();
	}
	
	public void enterFirstName(String FirstName) {
		Txt_FirstName.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName) {
		Txt_LastName.sendKeys(LastName);
	}
	
	public void enterEmail(String Email) {
		Txt_Email.sendKeys(Email);
	}
	
	public void enterConfirmationEmail(String confirmEmail) {
		Txt_Confirm_Email.sendKeys(confirmEmail);
	}
	
	public void enterPassword(String Password) {
		Txt_Req_Password.sendKeys(Password);
	}
	
	public void selectBirthday(String index) {
	
		Select BirthDay = new Select(DD_Birthday);
		BirthDay.selectByVisibleText("5");
	}
	
	public void selectBirthMonth(int index) {
		
		Select BirthMonth = new Select(DD_BirthMonth);
		BirthMonth.selectByIndex(10);	
	}
	
	public void selectBirthYear(String value) {

		Select BirthYear = new Select(DD_BirthYear);
		BirthYear.selectByValue("1987");
	}

	public void chooseGender(int index) {
		
		Radio_Gender.get(1).click();
	}
	
	public void click_FormSubmit() {
		Btn_Submit.click();
	}
	
	public void clickLogoutLink() {
		Lnk_Logout.click();
	}
	
	public void enterUserName(String username) {
		Txt_Username.sendKeys(username);
	}
	
	public void enterLoginPassword(String password) {
		Txt_Password.sendKeys(password);
	}
	
	public void clickLoginAccount() {
		Btn_Login.click();
	}
	
	public void clickAccountLink() {
		Lnk_Account.click();
	}
	
	public void clickAccountLogout() {
		Lnk_Account.click();
		Lnk_AccountLogOut.click();
	}
	
	public void verifyFBHome() {
		Assert.assertTrue(driver.getTitle().contains("Facebook"));
		System.out.println("Successfully navigated to facebook home page");
	}
	
	public void verifyAccountCreated() {
		
		System.out.println("Account has been created successfully ");
	}
	
	public void verifyAccountLogIn() {
		Assert.assertTrue(Lnk_Account.isDisplayed());
		System.out.println("Successfully logged in to the account ");
	}
}
