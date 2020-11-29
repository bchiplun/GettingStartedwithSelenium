import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automatingecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] neededItems = { "Cucumber", "Beetroot", "Tomato", "Beans" }; // The items which we want to add in cart

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']")); // Storing names
																										// of all
																										// products

		List itemsNeededList = Arrays.asList(neededItems); // converting array to list as it is fast but takes more
															// space than Array

		int j = 0; // counter to get out of the loop once all products in neededItems are added in
					// cart
		for (int i = 0; i < productNames.size(); i++) {

			String[] product = productNames.get(i).getText().split("-"); // getting each product name and splitting it
																			// to convert
																			// 'veggiename - 1kg' to 'veggiename'
			String productName = product[0].trim(); // split will return {'veggiename ', '1kg'} from this only picking
													// veggiename and trimmimg spaces

			if (itemsNeededList.contains(productName)) { // checking if prductname that we got from webpage(selenium) is
															// present in arraylist

				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // if present
																										// then clicking
																										// on the button

				if (j == neededItems.length) { // to exit the loop
					break;
				}
			}

		}

	}

}
