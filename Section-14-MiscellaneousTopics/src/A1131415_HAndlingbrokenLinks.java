import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class A1131415_HAndlingbrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		SoftAssert a = new SoftAssert(); // to use soft assert so that whenever assertion fails it will not fail entire script until we call it
		// In this we will iterate through all links present in footer of the page and will check if the link is broken or not
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		for(WebElement link: links) {
			
			String url = link.getAttribute("href");
			//To establish url connection to connectt to it and verify if it is giving correct response code
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); // to open connection with mentioned URL
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with name \""+link.getText()+"\" is broken and giving response code "+respCode); //soft assert
			
		}
		
		a.assertAll(); // to call assertion errors that we faced earlier
		

	}

}
