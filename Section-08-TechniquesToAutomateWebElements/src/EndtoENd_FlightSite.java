import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoENd_FlightSite {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		 * In this project we wiil be automating end to end flight booking site using selenium 
		 * We wiil handle different dropdowns, calendar UI, checkboxes, radio buttons etc.
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Selecting radio button - one way trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		// Handling from and to location dropdown
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_originStation1_CTNR a[value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
		
		//Selecting current date from calendar
		
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		
		//Ensuring that return date calendar is disabled
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("It is disabled! COrrect");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("It is enabled, incorrect!");
			Assert.assertTrue(false);
		}
		
		//Handling passengers dropdown and selecting 4 adults and 4 children
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for(int i=1; i<4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		for(int i=0; i<4; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		//Ensuring that we have selected correct number of passengers
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult, 4 Child");
		
		//Handling currency dropdown using Select class
		
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("USD");
		
		// Clicking on Family and friends checkbox
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(5000);
		
		//Finally clicking on search button
		//driver.findElement(By.cssSelector("input[id*='FindFlights']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'FindFlights')]")).click();
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
