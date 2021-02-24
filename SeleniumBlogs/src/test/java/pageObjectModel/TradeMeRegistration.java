package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TradeMeRegistration {

	WebDriver driver;

	@FindBy(linkText ="Register")
	WebElement Lnk_Register;

	@FindBy(linkText="business account")
	WebElement Lnk_BusinessAccount;

	@FindBy(id="LoginDetails_EmailAddressTextBox")
	WebElement Txt_Email;

	@FindBy(id="LoginDetails_PasswordTextBox")
	WebElement Txt_Password;

	@FindBy(id="LoginDetails_ConfirmPasswordTextBox")
	WebElement Txt_ConfirmPassword;

	@FindBy(id="LoginDetails_UserNameTextBox")
	WebElement Txt_UserName;

	@FindBy(id="ContactDetails_FirstNameTextBox")
	WebElement Txt_FirstName;

	@FindBy(id="ContactDetails_LastNameTextBox")
	WebElement Txt_LastName;

	@FindBy(xpath="//label[normalize-space()='Man']")
	WebElement Chk_Male;

	@FindBy(xpath="//label[normalize-space()='Woman']")
	WebElement Chk_Female;

	@FindBy(xpath="//label[normalize-space()='Gender diverse']")
	WebElement Chk_diverse;

	@FindBy(id="ContactDetails_DobDay")
	WebElement DD_BirthDay;

	@FindBy(id="ContactDetails_DobMonth")
	WebElement DD_BirthMonth;

	@FindBy(id="ContactDetails_DobYear")
	WebElement Txt_Year;

	@FindBy(id="ContactDetails_ContactPhoneAreaCodeDropDown")
	WebElement DD_PhoneExt;	

	@FindBy(id="ContactDetails_ContactPhoneAreaCodeDropDown")
	WebElement Txt_PhoneNumber;

	@FindBy(xpath="//span[@class='tm-switch tm-switch-radio']//label[@for='ContactDetails_StreetAddress_radioNewZealand'][normalize-space()='New Zealand']")
	WebElement Radio_NZ;

	@FindBy(xpath="//span[@class='tm-switch tm-switch-radio']//label[@for='ContactDetails_StreetAddress_radioAustralia'][normalize-space()='Australia']")
	WebElement Radio_AU;

	@FindBy(xpath="//input[@placeholder='Start typing your address...']")
	WebElement Txt_AddressSearch;

	@FindBy(xpath="ContactDetails_ClosestSuburbDropDown")
	WebElement DD_Close_Districts;

	@FindBy(xpath="//span[@name='TnCCheckbox']")
	WebElement Chk_Box;

	@FindBy(id="SubmitButton")
	WebElement Btn_CreateAccount;

	public TradeMeRegistration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickLinkRegister() {
		Lnk_Register.click();
	}

	public void clickLinkBusinessAccount() {
		Lnk_BusinessAccount.click();
	}

	public void enterEmail(String Email) {
		Txt_Email.sendKeys(Email);
	}	

	public void enterPassword(String Password) {
		Txt_Password.sendKeys(Password);
	}

	public void enterPasswordConfirmation(String Password) {
		Txt_ConfirmPassword.sendKeys(Password);
	}

	public void enterUserName(String UserName) {

		Txt_UserName.sendKeys(UserName);
	}

	public void enterFirstName(String FirstName) {
		Txt_FirstName.sendKeys(FirstName);
	}

	public void enterLastname(String LastName) {
		Txt_LastName.sendKeys(LastName);
	}

	public void selectMale() {
		Chk_Male.click();
	}

	public void selectFemale() {
		Chk_Female.click();
	}

	public void selectDiverse() {
		Chk_diverse.click();
	}

	public void selectBirthDay(String value) {
		Select BirthDay = new Select(DD_BirthDay);
		BirthDay.selectByIndex(10);
	}

	public void selectBirthMonth(String index) {
		Select BirthMonth = new Select(DD_BirthMonth);
		BirthMonth.selectByIndex(10);
	}

	public void enterBirthYear(String year) {
		Txt_Year.sendKeys(year);
	}

	public void selectPhoneExt(String index) {
		Select Phone_Exnt = new Select(DD_PhoneExt);
		Phone_Exnt.selectByVisibleText(index);
	}

	public void enterPhoneNumber(String phone) {
		Txt_PhoneNumber.sendKeys(phone);
	}

	public void selectNZRadio() {
		Radio_NZ.click();
	}

	public void selectAURadio() {
		Radio_AU.click();
	}	

	public void enterAddressSearch(String Address) {
		Txt_AddressSearch.sendKeys(Address);
	}

	public void selectCloseDistricts(String index) {
		Select districts = new Select(DD_Close_Districts);
		districts.selectByVisibleText(index);
	}

	public void checkAgeCheckBox() {
		Chk_Box.click();
	}

	public void clickCreateAccount()
	{
		Btn_CreateAccount.click();
	}




}
