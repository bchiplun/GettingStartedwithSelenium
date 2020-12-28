package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A193_LoginPageObjects {
	
	WebDriver driver;
	
	public A193_LoginPageObjects(WebDriver driver) {  //constructor to get the driver
		
		this.driver = driver;
	}
	
	By  username = By.xpath("//input[@id='login1']"); 
	By password = By.cssSelector("#password");
	By go = By.xpath("//input[@title='Sign in']");
	By home = By.linkText("rediff.com");
	
	public WebElement username() {   //Method to send login id webelemet to test case to perform operations on it
		return driver.findElement(username);
	}
	
	public WebElement password() {  // similarly for password
		return driver.findElement(password);
	}
	
	public WebElement loginbutton() {  //Similarly for login button
		return driver.findElement(go);

	}
	
	public WebElement rediffhome() {
		return driver.findElement(home);
	}
	
}	
