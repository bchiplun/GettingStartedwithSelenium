import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class A48_HandlingStaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * Select calss for hanling static dropdown
		 * this can only be used when static dropdown contains select tag and it's option contanis options tag
		 */
		Select s = new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"))); 
		s.selectByValue("INR");
		s.selectByIndex(2);
		s.selectByVisibleText("INR");

	}

}
