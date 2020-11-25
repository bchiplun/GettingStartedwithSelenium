import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A49_UpdatedPassengersDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * Select class for handling static dropdown
		 * this can only be used when static dropdown contains select tag and it's option contanis options tag
		 */
		Select s = new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"))); 
		s.selectByValue("INR");
		s.selectByIndex(2);
		s.selectByVisibleText("INR");
		
		// Handling passangers dropdown
		
		driver.findElement(By.id("divpaxinfo")).click(); // to click on passenger dropdown
			Thread.sleep(2000L);  	                       // to implicitly wait for 2 seconds
			
		for(int i=1; i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); // to click on increasing button of adult
		}
		int i = 0;
		while(i<4) {
			driver.findElement(By.id("hrefIncChd")).click(); // to click on increeasing button on child
			i++;
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); // to click on done
		

	}

}
