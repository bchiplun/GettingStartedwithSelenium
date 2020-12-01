import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		// clicking option2 and storing label in variable

		driver.findElement(By.id("checkBoxOption2")).click();
		String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(label);

		// Selecting label from dropdown
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(label);

		// Entering text into alert example
		driver.findElement(By.id("name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();

		// getting text message from popup
		Assert.assertTrue(driver.switchTo().alert().getText().contains(label));
		//System.out.println(driver.switchTo().alert().getText().contains(label));
		driver.switchTo().alert().accept();

	}

}
