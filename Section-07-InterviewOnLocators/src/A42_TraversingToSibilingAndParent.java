import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class A42_TraversingToSibilingAndParent {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://courses.rahulshettyacademy.com/courses");
		
		driver.findElement(By.xpath("//div[@class='row course-list list']/div[1]")).click();
		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.navigate().back();
		
		
		driver.get("https://courses.rahulshettyacademy.com/courses");
		
		driver.findElement(By.xpath("//div[@class='row course-list list']/div[1]/following-sibling::div[1]")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@class='row course-list list']/div[1]/following-sibling::div[3]")).click();
		//driver.navigate().back();

	}

}
