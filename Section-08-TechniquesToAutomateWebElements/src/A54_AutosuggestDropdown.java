import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class A54_AutosuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		Thread.sleep(2000); //it may take some time to load all options
		//to store all elements of suggested dropdown we will use List class
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a")); //stores all anchor tags present under li inside options varibale
		
		for(WebElement option: options) {
			if(option.getText().equalsIgnoreCase("india")) { // to match text that we want
				option.click();
				break;  //to stop loop after gettig desired text
			}
		}

	}

}
