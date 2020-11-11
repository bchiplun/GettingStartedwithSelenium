import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Basic methods of Selenium and browser
 */

public class WebDriverMEthods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");  //to hit the website
		
		System.out.println(driver.getCurrentUrl()); // to validate url
		
		//System.out.println(driver.getPageSource()); // to get the page source
		
		driver.get("http://yahoo.com"); //navigating to yahoo after google
		System.out.println(driver.getCurrentUrl()); // to validate url
		
		driver.navigate().to("https://facebook.com"); // navigationg to facebbok after yahoo
		System.out.println(driver.getCurrentUrl()); // to validate url
		
		driver.navigate().back(); //Navigating to previous webpage same as back button
		System.out.println("Back new page to page:"+driver.getCurrentUrl());
		
		driver.navigate().forward(); //Navigating to previous webpage same as back button
		System.out.println("next to new page: "+ driver.getCurrentUrl() + "From previos page");
		
		driver.close();  // to close the current browser, it does not close any other browser
		driver.quit();  // to close all browsers opened by selenium
		 
	
		

	}

}
