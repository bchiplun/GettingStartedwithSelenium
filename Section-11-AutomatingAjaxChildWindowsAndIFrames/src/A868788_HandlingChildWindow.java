import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A868788_HandlingChildWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/intl/en-GB/gmail/about/");
		
		driver.findElement(By.cssSelector(".h-c-button.h-c-header__cta-li-link.h-c-header__cta-li-link--primary")).click();
		
		//Getting title before switching window
		System.out.println("Before switching window");
		System.out.println(driver.getTitle());
		
		//to switch window first we need to store all windows ids in one variable for that we use getWindowHandles()
		Set<String> ids = driver.getWindowHandles();
		
		// To access any id from ids set we need to iterate through it
		Iterator<String> id = ids.iterator();
		
		//to access parent id we do id next
		String parentId = id.next();
		String childId = id.next();
		
		//Switching window using switchTo.window
		driver.switchTo().window(childId);
		
		//Getting title after switching to child window
		System.out.println("After switching to child window");
		System.out.println(driver.getTitle());
		
		//Switching back to parent
		driver.switchTo().window(parentId);
		
		System.out.println("After switching to parent window again");
		System.out.println(driver.getTitle());
		
		System.out.println("****************");
		driver.switchTo().window(childId);
		driver.findElement(By.xpath("//ul[@class='Bgzgmd']/li[1]")).click();
		
		System.out.println("Before switching window");
		System.out.println(driver.getTitle());
		
		//after switchinig for parent again
		driver.switchTo().window(parentId);
		System.out.println("After switching to parent");
		System.out.println(driver.getTitle());
		
		Set<String> ids2 = driver.getWindowHandles();
		Iterator<String> id2 = ids2.iterator();
		String parentId2 = id2.next();
		String childId2 = id2.next();
		String subchildId2 = id2.next();
		
		System.out.println("***********************");
		driver.switchTo().window(parentId2);
		System.out.println("Inside parent, Title of page:" + driver.getTitle());
		
		driver.switchTo().window(childId2);
		System.out.println("Inside child, Title of page:" + driver.getTitle());
		
		driver.switchTo().window(subchildId2);
		System.out.println("Inside subchild, Title of page:" + driver.getTitle());
		
		
		

	}

	
}
