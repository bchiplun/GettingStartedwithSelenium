package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageobjects.A193_LoginPageObjects;
import pageobjects.A195_Homepageobjects;

public class A193_LoginTestCase {
	
	@Test
	public void loginCase() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//creating object of page object model class to access elements of login page
		A193_LoginPageObjects lp = new A193_LoginPageObjects(driver);
		
		lp.username().sendKeys("hello");
		lp.password().sendKeys("password");
		//lp.loginbutton().click();
		lp.rediffhome().click();
		
		//after back to home page creating objects of homepage class to access webelements
		A195_Homepageobjects hp = new A195_Homepageobjects(driver);
		
		hp.search().sendKeys("Search rediff");
		hp.clickSearch().click();
				
		
	}

}
