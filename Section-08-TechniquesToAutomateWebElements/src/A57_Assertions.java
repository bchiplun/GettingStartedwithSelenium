import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A57_Assertions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * Using assertion to validate the returns as per the script
		 */
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // to check if it is selected before clicking using assertion
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // to check if it is selected after clicking
		
		driver.findElement(By.id("divpaxinfo")).click(); // to click on passenger dropdown
		Thread.sleep(2000L);  	                       // to implicitly wait for 2 seconds
		
		for(int i=1; i<4;i++) {
		driver.findElement(By.id("hrefIncAdt")).click(); // to click on increasing button of adult
	   }
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");

	}

}
