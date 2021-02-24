package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeekProfile {
	
	WebDriver driver;
	
	By Profile = By.xpath("//label[@class='FYwKg _38w9lFq']");
	By Lnk_Signout = By.linkText("Sign Out");
	By Lnk_Cancel = By.xpath("//button[normalize-space()='Cancel']");
	By lnk_Signin = By.xpath("//a[@class='FCpVUlh'][normalize-space()='Sign in']");
	By txtUserName = By.id("email");
	By txtLoginPassword = By.id("password");
	By Btn_Signin = By.xpath("//button[normalize-space()='Sign In']");
	
	public SeekProfile(WebDriver driver) {
		this.driver=driver;
	}
	public void clickSignin() {
		driver.findElement(lnk_Signin).click();
	}

	public void enterUserName(String username) {
		driver.findElement(txtUserName).sendKeys(username);
	}
	public void enterLoginPassword(String password) {
		driver.findElement(txtLoginPassword).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(Btn_Signin).click();
	}
	
	public void clickProfile() {
		driver.findElement(Profile).click();
	}
	
	public void clickSignOut() {
		driver.findElement(Lnk_Signout).click();
	}
	
	public void clickCancel() {
		driver.findElement(Lnk_Cancel).click();
	}
	
}
