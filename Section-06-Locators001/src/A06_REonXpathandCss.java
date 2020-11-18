import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A06_REonXpathandCss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com");
		/*
		 * using xpath
		 */
		/*
		driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click(); //xpath for sign in button using regular expression
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Dummyuser");
		driver.findElement(By.xpath("//*[contains(@id,'passw')]")).sendKeys("Dummypasswd");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		*/
		
		
		/*
		 * Using CSS
		 */
		
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click(); // css locator for sign in button using regular expression
		driver.findElement(By.cssSelector("input[id='login1']")).sendKeys("Dummyuser");
		driver.findElement(By.cssSelector("input[id*='passw']")).sendKeys("Dummypassw");
		driver.findElement(By.cssSelector("input[name='proceed']")).click();
		
		driver.close();
	}

}
