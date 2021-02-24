package pageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeekRegistration {

	WebDriver driver; 

	By lnk_Register = By.xpath("//a[@class='FCpVUlh'][normalize-space()='Register']");
	By txt_FirstName = By.id("firstName");
	By txt_LastName = By.id("lastName");
	By txt_Email = By.id("email");
	By txt_Password = By.id("password");
	By Btn_Register = By.xpath("//button[normalize-space()='Register']");
	By lnk_Signin = By.id("sign-in-link");
	By Chk_Has_Experience = By.id("hasExperience");
	By txt_JobTitle = By.id("title");
	By txt_Company = By.id("company");
	By DD_FromMonth = By.id("from-month");
	By DD_FromYear = By.id("from-year");
	By DD_ToMonth = By.id("to-month");
	By DD_ToYear=By.id("to-year");
	By Chk_StillinRole = By.id("stillInRole");
	By DD_location = By.id("currentLocation-primary");
	By DD_Prim_Classification = By.id("preferredClassification-primary");
	By DD_Sub_Classification =By.id("preferredClassification-secondary");
	By Btn_Visibitlity  = By.xpath("//button[@id='profileVisibility']");
	By Btn_Hidden = By.xpath("//strong[normalize-space()='Hidden']");
	By Btn_Save = By.xpath("//button[@type='submit']");
	By Btn_Continue = By.xpath("//button[@data-automation='continue']");
	By lnk_Settings = By.linkText("Settings");
	By span_delete = By.xpath("//span[contains(text(),'Delete Account')]");
	By txt_confirmPassword = By.xpath("//input[@type='password']");
	By BtnDelete = By.xpath("//button[normalize-space()='Delete']");
	By Profile = By.xpath("//label[@class='FYwKg _38w9lFq']");
	By Lbl_Deleteconfirmation = By.xpath("//h1[normalize-space()='Account Deleted']");
	
	public SeekRegistration(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicksettings() {
		driver.findElement(lnk_Settings).click();
	}
	public void clickProfile() {
		driver.findElement(Profile).click();
	}
	
	
	public void clickDeletespan() {
		driver.findElement(span_delete).click();
	}
	
	public void clickDeleteButton() {
		driver.findElement(BtnDelete).click();
	}
	public void enterConfirmPassword(String Password) {
		driver.findElement(txt_confirmPassword).sendKeys(Password);
	}
	public void clickRegisterLink() {
		driver.findElement(lnk_Register).click();
	}

	public void enterFirstName(String FirstName) {
		driver.findElement(txt_FirstName).sendKeys(FirstName);
	}

	public void enterLastName(String LastName) {
		driver.findElement(txt_LastName).sendKeys(LastName);
	}

	public void enterEmail(String Email) {
		driver.findElement(txt_Email).sendKeys(Email);
	}

	public void enterPassword(String Password) {
		driver.findElement(txt_Password).sendKeys(Password);
	}

	public void clickRegisterButton() {
		driver.findElement(Btn_Register).click();
	}

	public void checkHasExperience() {
		driver.findElement(Chk_Has_Experience).click();
	}

	public void enterJobTitle(String Job) {
		driver.findElement(txt_JobTitle).sendKeys(Job);
	}

	public void enterCompany(String company) {
		driver.findElement(txt_Company).sendKeys(company);
	}

	public void selectStartMonth(int index) {

		WebElement StartMonth = driver.findElement(DD_FromMonth);
		Select Month = new Select(StartMonth);
		Month.selectByIndex(index);
	}

	public void selectStartYear(int index) {

		WebElement StartYear = driver.findElement(DD_FromYear);
		Select Year = new Select(StartYear);
		Year.selectByIndex(index);
	}	
	public void selectEndMonth(String option) {

		WebElement EndMonth = driver.findElement(DD_ToMonth);
		Select Month = new Select(EndMonth);
		Month.selectByValue(option);
	}

	public void selectEndYear(String option) {

		WebElement EndYear = driver.findElement(DD_ToYear);
		Select Year = new Select(EndYear);
		Year.selectByValue(option);
	}

	public void checkStillInRole() {
		driver.findElement(Chk_StillinRole).click();     
	}

	public void selectLocation(String loc) {
		
		WebElement LocationDD = driver.findElement(DD_location);
		Select location = new Select(LocationDD);
		location.selectByVisibleText(loc);
	}

	public void selectPrimaryClassification(String Option) {
		
		WebElement Prim_ClassificationDD = driver.findElement(DD_Prim_Classification);
		Select primary = new Select(Prim_ClassificationDD);
		primary.selectByVisibleText(Option);
	}
	
	public void selectSubClassification(String Option) {
		
		WebElement Sub_ClassificationDD = driver.findElement(DD_Sub_Classification);
		Select secondary = new Select(Sub_ClassificationDD);
		secondary.selectByVisibleText(Option);
	}
	public void selectVisibility(String Option) {
		
		WebElement VisibilityDD = driver.findElement(Btn_Visibitlity);
		VisibilityDD.click();
		driver.findElement(Btn_Hidden).click();
	}

	public void clickSaveButton() {
		driver.findElement(Btn_Save).click();
	}
	
	public void clickContinue() {
		driver.findElement(Btn_Continue).click();
	}
	public void verifySeekHome() {
		Assert.assertTrue(driver.getTitle().contains("Jobs on SEEK"));
		System.out.println("Successfully navigated to Seek Website");
	}

	public void verifyRegisterationPage() {
		Assert.assertTrue(driver.getTitle().contains("Register with SEEK"));
		System.out.println("Successfully naviagted to registration page");

	}
	
	public void verifyDeleteConfirmation() {
		Assert.assertTrue(driver.findElement(Lbl_Deleteconfirmation).isDisplayed());
	}
	
	public void verifyRegistrationOnboardPage() {
		Assert.assertTrue(driver.getTitle().contains("Profile onboarding"));
		System.out.println("Successfully naviagted to Profile onboarding page");
	}

}
