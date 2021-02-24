package browserMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {
	
	public static void main(String[] args) {	
		//Browser driver set up
		WebDriverManager.edgedriver().setup();
		
		//Instantiate WebDriver interface
		WebDriver driver = new EdgeDriver();
		
		//Load a new web page in current window
		driver.get("https://accounts.google.com/signup");
		
		//Get the current url  		
		String url = driver.getCurrentUrl();
		System.out.println("Current URL  :  "+url);
		
		//Get title of current web page		
		String title = driver.getTitle();
		System.out.println("Current title :  "+title);
		
		//Get the page source code 
		String sourcecode=  driver.getPageSource();
		System.out.println("Current Source Code  : "+ sourcecode);
		
		//Close current Web page
		driver.close();
		
		//Terminate the driver instant
		driver.quit();				
	}
}
