import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A110_MaxWindowDeleteCookiesScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//maximizing window
		driver.manage().window().maximize();
		
		//deleting all cookies
		driver.manage().deleteAllCookies();
		
		//delete only particular cookie using cookie name
		//driver.manage().deleteCookieNamed("name");
		
		driver.get("https://www.google.com/");
		
		//take screenshot
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\SeleniumWithJava\\selenium_screenshots\\googlpage.png"));
		
		driver.close();

	}

}
