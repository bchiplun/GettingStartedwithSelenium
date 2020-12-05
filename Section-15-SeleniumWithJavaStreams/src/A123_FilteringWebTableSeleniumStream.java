import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A123_FilteringWebTableSeleniumStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.findElement(By.cssSelector("a[href='#/offers']")).click(); // clicking on top deals

		// Switching to new window
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> id = ids.iterator();
		id.next();
		driver.switchTo().window(id.next());
		String text = "Ri"; // text to search
		driver.findElement(By.id("search-field")).sendKeys(text); 
		
		//Storing all the Webelements of veggie names in a list 
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		// filtering the veggies list based on the text we entered in the search and storing it new list
		List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
		
		// if the length of both list is equal then our fuctinality is working fine else some issue
		Assert.assertEquals(veggies.size(), filteredList.size());
		

	}

}
