import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A9192_LimitingScopeofDriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1. get count of all links in page
		System.out.println("Count of All links in page:" + driver.findElements(By.tagName("a")).size()); // all links in page will conain anchor tag
		
		//2. get count of links present in footer of the page
		//Creating minidriver and limiting scope of that driver to footer only
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Count of All links in footer of page:" + footerdriver.findElements(By.tagName("a")).size());
		
		//3. Get count of links present in first coloumn of footer of page
		WebElement coldriver = footerdriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
		System.out.println("Count of All links in first col of footer of page:" + coldriver.findElements(By.tagName("a")).size());
		
		//4. check if all links in first coloumn of footer are working or not
		String clickonKeysTabs = Keys.chord(Keys.CONTROL, Keys.ENTER); // to click enter and control together to open links in new tab
		System.out.println(clickonKeysTabs);
		for(int i=1; i<coldriver.findElements(By.tagName("a")).size(); i++) {
			
			
			coldriver.findElements(By.tagName("a")).get(i).sendKeys(clickonKeysTabs);
		}
		
		//Getting titles of each tab that was opened
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		
		Thread.sleep(10000);
		//driver.quit();

	}

}
