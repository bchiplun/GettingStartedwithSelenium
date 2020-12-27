package packageB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Log4j2 framework along with the frames conecpts
 */
public class Assignment_5_NestedFrame {

	private static Logger log = LogManager.getLogger(A185_Log4jIntroB.class.getName());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("WIndow Maximized");
		
		log.debug("Now hitting home page");
		driver.get("http://the-internet.herokuapp.com/");
		log.info("Landed on home page");
		
		log.debug("Now clicking on nested frames");
		driver.findElement(By.cssSelector("a[href*='nested_frames']")).click();
		log.debug("Landed on nested frames page");
		
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src*='frame_top']")));
			log.info("Sucessfully switched to top nested frame");
		}
		catch(Exception e) {
			log.error("Error in first switching to top frame");
		}
		
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
			log.info("Sucessfully second switched to middle nested frame");
		}
		catch(Exception e) {
			log.error("Error in second switching to middle frame");
		}
		
		log.debug("Fetching text from the middle frame");
		try {
			System.out.println(driver.findElement(By.id("content")).getText());
			log.info("Successfully fetached text");
		}
		catch(Exception e) {
			log.error("Error in getting text from middle frame" + e);
		}
		
	}

}