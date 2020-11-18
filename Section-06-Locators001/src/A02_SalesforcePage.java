import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A02_SalesforcePage {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\chipl\\Java\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com/?locale=eu");
		
		/*
		 * Creting example of issue which we will get when we have spaces in class name/name/id
		 */
		
		driver.findElement(By.id("username")).sendKeys("Dummyname");;
		driver.findElement(By.name("pw")).sendKeys("12345");
		
		driver.findElement(By.className("button r4 wide primary")).click(); // This will create issue
		
	}

}
