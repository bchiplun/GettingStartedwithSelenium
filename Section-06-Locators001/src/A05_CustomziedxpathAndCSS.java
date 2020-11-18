import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A05_CustomziedxpathAndCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		
		/*
		 * First from customized xpath
		 * Syntax of xpath
		 */// //tagname[@attribute='valuesofattribute']
		 
		/*
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Dummyxpath");  // select input tag having name = email
		driver.findElement(By.xpath("//*[@name='pass']")).sendKeys("Dummyxpath");  // select any tag having name = pass (using regular expression)
		driver.findElement(By.xpath("//button[@name='login']")).click(); // select button tag having name login
		 */
		
		/*
		 * From customized css
		 * Syntax for css
		 * tagname[attribute='value']
		 * tagname#idvalue --> will only work if tag has id attribute
		 * tagname.classnamevalue --> will only work if tag has classname attribute
		 */
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("dummycss"); // select input tag having name email using css
		driver.findElement(By.cssSelector("input#pass")).sendKeys("dummycsspass"); //select input tag having id pass
		driver.findElement(By.cssSelector("button[name='login']")).click();
		
		driver.quit();

	}

}
