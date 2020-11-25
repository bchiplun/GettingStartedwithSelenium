import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A52_ParentChildXpathCSS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Handling dynamic dropdown using indexing
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // to click on from dropdown
		/*
		driver.findElement(By.xpath("//a[@value='BOM']")).click(); // to click on city from 'from dropdown'
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); // to click on city from 'To drpdown'
		*/
		
		// Handling dynamic dropdown using parent child relatioon xpath
		/*
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BOM']")).click(); // to click on city from 'from dropdown'
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click(); // to click on city from 'To drpdown'
		*/
		
		// Using CSS selector same as above
		driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_originStation1_CTNR a[value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='BLR']")).click();
	}

}
