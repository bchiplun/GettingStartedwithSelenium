import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A121_AutomatingPagination {

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

		// clicking on table head to sort data in order
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Storing the column contents in a list
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

		// Picking text data from Webelements and storing it to list using streams
		List<String> ogList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sorting ogList and storing it to newList using stream
		List<String> sortedList = ogList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(ogList.equals(sortedList));

		// 121: Fetching price of Strawberry by using name coloumn using stream which is
		// present on the last page and printing it
		List<String> price; // defining the list price to store price if we get any
		
		// using do while to iterate through all pages of list
		do {
			elementList = driver.findElements(By.xpath("//tr/td[1]"));  // to get the list of veggies
			price = elementList.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getPriceVeggie(s)) // to get the price of veggie in list 
					.collect(Collectors.toList());

			if (price.size() < 1) {      // if veggie not found in current page
				
				if(driver.findElement(By.cssSelector("a[aria-label='Next']")).getAttribute("aria-disabled").equals("false")) { // to check if next button is disabled
					driver.findElement(By.cssSelector("a[aria-label='Next']")).click(); // if not disabled
				}
				else {
					System.out.println("No such veggie found!");  // if disabled
					break;
				}
				
			}
		} while (price.size() < 1);  // condition for keep loop working

		if (price.size() > 0) {      // if veggie found
			price.stream().forEach(a -> System.out.println(a));

		}

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
