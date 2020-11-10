import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoxdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// first selenium code to automate chrome
		
				// Creating driver object for chrome driver
				
				// implementing methods of webdriver interface and using class name ChromDriver
				
				//FIrst invoking .exe file for chrome
				
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\chipl\\Java\\eclipse-workspace\\geckodriver-v0.28.0-win64\\geckodriver.exe");
				
				// implementing methods of webdriver interface and using class name ChromDriver
				
				WebDriver driver = new FirefoxDriver();
				
				//Loading site on chrome
				
				driver.get("http://yahoo.com");
				
				//getting title of page
				
				System.out.println(driver.getTitle());

	}

}
