import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_8_AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"autocomplete\").value";

		String text = (String) js.executeScript(script);
		int i = 0;

		while (!text.contains("(USA)")) {

			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);

			if (i > 10) {
				break;
			}
		}

		if (i > 10) {
			System.out.println("Not found");
		} else {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
			System.out.println("Found");
		}

		
		Thread.sleep(5000);
		driver.close();

	}

}
