import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A03_LocateByXpath {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\chipl\\Java\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.salesforce.com/?locale=eu");
		
		driver.findElement(By.id("username")).sendKeys("Dummyname");;
		driver.findElement(By.name("pw")).sendKeys("12345");
		
		//driver.findElement(By.className("button r4 wide primary")).click(); // This will create issue
		
		/*
		 * Locating login button using Xpath
		 */
		
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		
		/*
		 * Getting error text from page and printing it in console		
		 */
		
		System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		
		driver.close();
		
	}

}
