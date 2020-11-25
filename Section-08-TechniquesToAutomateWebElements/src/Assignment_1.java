import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Task1
		 */
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected()); //to verify that checkbox is not selected
		driver.findElement(By.id("checkBoxOption1")).click(); // to select the checkbox
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected()); // to verify that checkbox is selected
		
		driver.findElement(By.id("checkBoxOption1")).click(); // to unselect checkbox
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected()); //to verify that checkbox is not selected
		
		/*
		 * Task2 To get the count of checkbox
		 */
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 3);
		

	}

}
