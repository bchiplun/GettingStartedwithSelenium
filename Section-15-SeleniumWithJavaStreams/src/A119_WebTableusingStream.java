import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A119_WebTableusingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.findElement(By.cssSelector("a[href='#/offers']")).click(); // clicking on top deals
		
		//Switching to new window
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		String parentId = id.next();
		driver.switchTo().window(id.next());
		
		//clicking on table head to sort data in order
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Storing the column contents in a list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Picking text data from Webelements and storing it to list using streams
		List<String> ogList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Sorting ogList and storing it to newList using stream
		List<String> sortedList = ogList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(ogList.equals(sortedList));
		
		
		//120: Fetching price of beans by using name coloumn using stream and printing it
		
		elementList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).forEach(s->System.out.println(s));

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
