import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_LocateById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.facebook.com");
		
		/*
		 * Locating field on webpage by id
		 * Find Elements will find element with id having "email" and sendKeys will send "Dummy Characters" in that field
		 */
		driver.findElement(By.id("email")).sendKeys("Dummy Characters"); 
		
		/*
		 * Locating by name and classname similar to id above
		 */
		driver.findElement(By.name("pass")).sendKeys("Dummy Pass");
		
		/*
		 * Locating by linkText
		 */
		driver.findElement(By.linkText("Forgotten password?")).click(); //click() is used to click the link
		
		driver.navigate().back();
		
		driver.findElement(By.id("email")).sendKeys("Dummy Characters"); 
		driver.findElement(By.name("pass")).sendKeys("Dummy Pass");
		driver.findElement(By.name("login")).click();
		

		
	
		//	driver.close();
		
		

	}

}
