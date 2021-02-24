package webElementMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();
		//disable notification parameter
		op.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(op);

		//Navigate to web page
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//Verify user landed on Facebook page.
		Assert.assertTrue(driver.getTitle().contains("Facebook"));

		//Click on Create Account button 

		driver.findElement(By.xpath("//a[normalize-space()='Create New Account']")).click();

		//1. FindElement - Find the first element using given method 

		WebElement firstname = driver.findElement(By.name("firstname"));

		firstname.sendKeys("Selenium 123");

		System.out.println("Successfully located FirstName web element ");

		//2. Clear - To clear the content

		firstname.clear();

		System.out.println("Successfully cleared input entered in first name ");

		//3. SendKeys() - Enter values to web element

		driver.findElement(By.name("firstname")).sendKeys("Selenium");

		System.out.println("Successfully re-entered first name text box");

		WebElement lastname = driver.findElement(By.name("lastname"));

		lastname.sendKeys("Leaning");

		//4 getLocation() - location of the web element

		Point location =  lastname.getLocation();

		System.out.println("Located last name element in  : "+location);

		WebElement req_mail = driver.findElement(By.name("reg_email__"));

		req_mail.sendKeys("onlyfortestingautomation@gmail.com");

		//5. getSize() - to get the size of the rendered element

		Dimension Size = req_mail.getSize();

		System.out.println("Element size : "+ Size);

		WebElement ConfirmEmail = driver.findElement(By.name("reg_email_confirmation__"));

		if(ConfirmEmail.isDisplayed()) {
			ConfirmEmail.sendKeys("onlyfortestingautomation@gmail.com");
		}

		WebElement password = driver.findElement(By.name("reg_passwd__"));
		password.sendKeys("SeleniumPassword123");

		//getAttribute() - to get the attribute 

		String placeholder = password.getAttribute("placeholder");

		System.out.println("Password have placeholder as : "+placeholder);

		//6. getTagName() - Returns the tag name of the element

		String TagName = password.getTagName();

		System.out.println("Tag name of the element is :"+TagName);

		//7. getCssValue(()- Get the value of the given CSS property

		String fontsize = password.getCssValue("font-size");

		System.out.println("Font size :"+fontsize);

		//8. getRect() - Location and Size of the rendered element
		Rectangle rect = password.getRect();

		System.out.println("Heigth of the element is - " + rect.getHeight());

		System.out.println("Width of the element is - " + rect.getWidth());

		System.out.println("Location of the element is - " + rect.getPoint());


		WebElement DateDropDown = driver.findElement(By.name("birthday_day"));

		Select BirthDay = new Select(DateDropDown);

		BirthDay.selectByVisibleText("5");

		// 9. isEnabled() - Check if web element is enabled or not

		boolean enable = driver.findElement(By.name("birthday_day")).isEnabled();

		System.out.println("Birthday Day drop down is enabled : "+enable);


		WebElement MonthDropDown = driver.findElement(By.name("birthday_month"));
		
		Select BirthMonth = new Select(MonthDropDown);

		BirthMonth.selectByIndex(10);	

		//10. isDisplayed() - Check if web element is displayed or not

		boolean displayed = MonthDropDown.isDisplayed();

		System.out.println("Birthday month drop down is displayed : "+displayed);

		WebElement YearDropDown = driver.findElement(By.name("birthday_year"));

		Select BirthYear = new Select(YearDropDown);

		BirthYear.selectByValue("1987");

		//11. Find Elements - Find web elements in the current page satisfies the given condition.

		List<WebElement> gender = driver.findElements(By.name("sex"));

		//12. Click() - Click the element

		gender.get(1).click();

		//13. isSelected() - Check if the web element is selected 

		boolean selected = gender.get(1).isSelected();

		System.out.println("Is gender field is selected  : "+selected);

		//14. getText() - To get the value of the given attribute of the element.	

		String text = driver.findElement(By.name("websubmit")).getText();

		System.out.println("Text of the user name element is - " + text);

		driver.findElement(By.name("websubmit")).click();
		System.out.println("Successfully created account ");
		
		WebElement logout = driver.findElement(By.linkText("Log Out"));
		
		Assert.assertTrue(logout.isDisplayed());
		logout.click();
		
		Assert.assertTrue(driver.getTitle().contains("Facebook – log in or sign up"));
		System.out.println("Successfully logged out ");
		
		
		//15. Submit  - Perform submit action 
		driver.findElement(By.name("email")).sendKeys("onlyfortestingautomation@gmail.com");

		driver.findElement(By.name("pass")).sendKeys("Automation123");

		driver.findElement(By.name("login")).submit();

		System.out.println("Successfully logged in");
		
		//locate the menu to hover over using its xpath

		WebElement menu = driver.findElement(By.xpath("//div[@aria-label='Account']"));
		
		Assert.assertTrue(menu.isDisplayed());

		// move the mouse to the earlier identified menu option

		menu.click();
		// wait for max of 5 seconds before proceeding.
		// until this submenu is found

		WebDriverWait wait = new WebDriverWait(driver, 5); 

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Log Out']")));  

		//identify menu option from the resulting menu display 
		WebElement menuOption = driver.findElement(By.xpath("//span[normalize-space()='Log Out']"));

		//Click the item from sub menu
		menuOption.click();
		
		Assert.assertTrue(driver.getTitle().contains("Facebook – log in or sign up"));
		
		System.out.println("Successfully logged out ");
		
		driver.close();
		driver.quit();

	}

}
