package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageobjects.A193_LoginPageObjects;
import pageobjects.A195_Homepageobjects;
import pageobjects.A198_LoginPageFactory;
import pageobjects.A199_HomePageFactory;

public class A198_LoginTestCaseFactory {
	
	@Test
	public void loginCase() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//creating object of page object model class to access elements of login page
		A198_LoginPageFactory lp = new A198_LoginPageFactory(driver);
		
		lp.username().sendKeys("hello");
		lp.password().sendKeys("password");
		//lp.loginbutton().click();
		lp.rediffhome().click();
		
		//after back to home page creating objects of homepage class to access webelements
		A199_HomePageFactory hp = new A199_HomePageFactory(driver);
		
		hp.search().sendKeys("Search rediff");
		hp.clickSearch().click();
				
		
	}

}
