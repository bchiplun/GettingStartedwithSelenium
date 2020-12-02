import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_7_WebTableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		WebElement table = driver.findElement(By.id("product"));
		
		int rowSize = table.findElements(By.tagName("tr")).size();
		System.out.println("Number of rows "+ rowSize);
		
		int colSize = table.findElements(By.xpath("//tr[1]/th")).size();
		System.out.println("Number of coloumns " + colSize);
		
		for(int i=0; i<colSize; i++) {
			System.out.println(table.findElements(By.xpath("//tr[3]/td")).get(i).getText());
		}
		
		

	}

}
