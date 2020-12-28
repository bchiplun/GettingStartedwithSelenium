package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A198_LoginPageFactory {
	
	//Writing the same page object model in form of page object factory
	
	WebDriver driver;
	
	public A198_LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='login1']")
	WebElement username;
	
	@FindBy(css= "#password")  //cssSelector is converted to css change in page object factory
	WebElement password; 
	
	
	@FindBy(xpath="//input[@title='Sign in']")
	WebElement go;
	
	@FindBy(linkText="rediff.com")
	WebElement home;
	
	public WebElement username() {   //Method to send login id webelemet to test case to perform operations on it
		return username;
	}
	
	public WebElement password() {  // similarly for password
		return password;
	}
	
	public WebElement loginbutton() {  //Similarly for login button
		return go ;

	}
	
	public WebElement rediffhome() {
		return home;
	}
}
