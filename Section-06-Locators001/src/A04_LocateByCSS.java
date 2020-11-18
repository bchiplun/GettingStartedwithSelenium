import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A04_LocateByCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		driver.findElement(By.cssSelector("#email")).sendKeys("Dummy user");
		driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("dummyyy");
		
		driver.findElement(By.linkText("Forgotten password?")).click(); // click on forgot password
		
		driver.navigate().back();
		
		driver.close();
		
	//driver
	}

}
