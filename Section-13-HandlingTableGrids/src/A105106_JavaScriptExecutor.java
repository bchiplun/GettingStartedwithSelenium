import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A105106_JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.findElement(By.id("fromPlaceName")).sendKeys("BEN");
		Thread.sleep(2000);

		//List<WebElement> items = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));

		/*
		 * this is not working as it is javascript for(WebElement item: items) {
		 * System.out.println("inside for"); if(item.getText().contains("AIRPORT")) {
		 * System.out.println(item.getText()); item.click(); break;
		 */
		
		// since the text in the box is hiiden element which cannot be retrived from the selenium for that we need to use javascript executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String script = "return document.getElementById(\"fromPlaceName\").value"; //script which will check text that will appear on the box
		String text = "";

		int i = 0;  // to stop the loop if text not present

		while (!text.contains("AIRPORT")) { 

			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);

			i++;
			if (i > 10) {
				break;
			}
		}

		if (i > 10) {
			System.out.println("String not found");
		} else {
			System.out.println("Found!");
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
		}
		
		
		Thread.sleep(5000);
		driver.close();

	}

}
