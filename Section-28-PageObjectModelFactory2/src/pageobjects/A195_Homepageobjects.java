package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class A195_Homepageobjects {
	
	WebDriver driver;
	
	public A195_Homepageobjects(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchbox = By.id("srchword");
	By searchbtn = By.xpath("//form[@name='srchform'] //input[@class='newsrchbtn']");
	
	public WebElement search() {
		return driver.findElement(searchbox);
	}
	
	public WebElement clickSearch() {
		return driver.findElement(searchbtn);
	}

}
