package naviagationMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NaviagationMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://simple.wikipedia.org/wiki/Wikipedia:About");

		//1. Navigate to 
		System.out.println("Current Titile : "+driver.getTitle());

		//2. navigate().refresh() method refreshes the current page thereby reloading all WebElements

		driver.navigate().refresh();

		driver.findElement(By.xpath("//a[normalize-space()='Main page']")).click();

		System.out.println("Current Titile after main page click  : "+driver.getTitle());

		//3. The navigate().back() method moves back a single page in our browser’s history.
		driver.navigate().back();

		System.out.println("Current Titile after back : "+driver.getTitle());

		//4. The navigate().forward() method moves forward one page in our browser’s history. 
		driver.navigate().forward();
		System.out.println("Current Titile after forward  : "+driver.getTitle());

		driver.close();

		driver.quit();
	}

}
