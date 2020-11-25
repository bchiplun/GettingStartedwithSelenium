import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A5960_CalendarUIEnableDisableUIElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * First selecting date from calendar
		 */
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // to click on from dropdown
		driver.findElement(By.xpath("//a[@value='BOM']")).click(); // to click on city from 'from dropdown'
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); // to click on city from 'To drpdown'
		
		//Selecting date from calendar.. Only selecting current highlighted date using CSS selector- class
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
		/*
		 * Enabling and disabling of Return Date(UI element) based in ine way or two way trip
		 */
		//return - ctl00_mainContent_rbtnl_Trip_1
		// one way- ctl00_mainContent_rbtnl_Trip_0
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("It is Enabled");
			driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		}
		else {
			System.out.println("It is disabled");
		}
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			
			System.out.println("It is Enabled");
			driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
			driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		}
		else {
			System.out.println("It is disabled");
		}

	}

}
