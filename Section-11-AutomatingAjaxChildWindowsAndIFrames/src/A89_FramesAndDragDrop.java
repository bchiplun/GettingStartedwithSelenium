import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class A89_FramesAndDragDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		
		
		//switching to frame
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		
		//switching to frame using to index
		
		System.out.println(driver.findElements(By.tagName("iframe")).size()); // to check nuber of frame elements in webpage
		driver.switchTo().frame(0); // to access first frame		
		
		Actions a = new Actions(driver); // to do drag and drop
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		
		
		//Back to default page
		driver.switchTo().defaultContent();
		
		Thread.sleep(5000);
		driver.close();
	}

}
