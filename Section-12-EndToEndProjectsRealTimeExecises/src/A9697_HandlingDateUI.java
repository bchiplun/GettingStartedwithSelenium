import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A9697_HandlingDateUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		
		//https://stackoverflow.com/questions/38367762/how-to-handle-browser-level-notification-using-selenium-webdriver
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		
		driver.get("https://www.cleartrip.com/");
		
		w.until(ExpectedConditions.elementToBeClickable(By.id("DepartDate")));
		driver.findElement(By.id("DepartDate")).click();
		
		if(driver.findElement(By.cssSelector("div[class='monthBlock first'] span[class='ui-datepicker-month']")).getText().contains("April")) {
			selectDate(driver, "div[class='monthBlock first']");
		}
		else {
			
			while(!driver.findElement(By.cssSelector("div[class='monthBlock last'] span[class='ui-datepicker-month']")).getText().contains("April")){
				driver.findElement(By.cssSelector("a[class='nextMonth ']")).click();
			}
			
			selectDate(driver, "div[class='monthBlock last']");
			
		}
		
	}
	
	
		
	public static void selectDate(WebDriver driver, String monthCss) {
		List<WebElement> dates = driver.findElements(By.cssSelector(monthCss + " td[data-handler='selectDay']"));
		
		for(int i=0; i<dates.size(); i++) {
			
			if (dates.get(i).getText().equalsIgnoreCase("19")) {
				System.out.println("Found");
				dates.get(i).click();
				break;
	}
	
			
		}
	}
		
		

	

}
