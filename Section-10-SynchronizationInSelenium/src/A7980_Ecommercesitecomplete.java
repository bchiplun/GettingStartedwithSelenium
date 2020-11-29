import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A7980_Ecommercesitecomplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] itemsNeeded = { "Cucumber", "Beetroot", "Tomato", "Beans" }; // The items which we want to add in cart

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		//Adding implicit wait of 5 seconds
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // this will be applicable for all setps of driver
																		//it will wait for max 5 seconds until page is loaded for any step
		
		//Defining object for explicit wait using two objects just for pactice purpose
		WebDriverWait w1 = new WebDriverWait(driver, 3); //explcit wait object for 3 seconds
		WebDriverWait w2 = new WebDriverWait(driver, 8); //explcit wait object for 8 seconds
		
		addItemsInCart(driver, itemsNeeded);
		
		//Clicking on cart and proceed to checkout
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Entering promo code applying it and clicking on place order
		w1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // it will wait for max 3 seconds until the element is visible
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy"); //coupon code
		
		w1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.promoBtn")));
		driver.findElement(By.cssSelector("button.promoBtn")).click();  //coupon button
		
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // it will wait for max 8 seconds until the element is visible
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); //coupon applied text
		
		
		

	}
	
	

	public static void addItemsInCart(WebDriver driver, String[] neededItems) {
		
		//Method for adding items into cart
		
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class='product-name']")); // Storing names  of all products

		List itemsNeededList = Arrays.asList(neededItems); // converting array to list as it is fast but takes more space than Array

		int j = 0; // counter to get out of the loop once all products in neededItems are added in cart
		
		for (int i = 0; i < productNames.size(); i++) {

			String[] product = productNames.get(i).getText().split("-"); // getting each product name and splitting it to convert
																			// 'veggiename - 1kg' to 'veggiename', '1kg'
			String productName = product[0].trim(); // split will return {'veggiename ', '1kg'} from this only picking veggiename and trimmimg spaces

			if (itemsNeededList.contains(productName)) { // checking if prductname that we got from webpage(selenium) is present in arraylist

				j++;

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // if present then clicking on the button

				if (j == neededItems.length) { // to exit the loop
					break;
				}
			}

		}

	}

	
	
}
