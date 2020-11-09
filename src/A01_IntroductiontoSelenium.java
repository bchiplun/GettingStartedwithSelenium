import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_IntroductiontoSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// first selenium code to automate chrome
		
		// Creating driver object for chrome driver
		
		// implementing methods of webdriver interface and using class name ChromDriver
		
		//FIrst invoking .exe file for chrome
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		
		// implementing methods of webdriver interface and using class name ChromDriver
		
		WebDriver driver = new ChromeDriver();
		
		//Loading site on chrome
		
		driver.get("http://yahoo.com");
		
		//getting title of page
		
		System.out.println(driver.getTitle());
		

	}

}
