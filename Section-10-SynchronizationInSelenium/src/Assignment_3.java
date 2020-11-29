import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax')]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Process completed')]")));
		
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.id("results"), "Process completed"));
		System.out.println(driver.findElement(By.xpath("//div[contains(text(), 'Process completed')]")).getText());
		
		

	}

}
