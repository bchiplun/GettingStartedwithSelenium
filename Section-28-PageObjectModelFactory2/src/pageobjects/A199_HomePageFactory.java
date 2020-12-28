package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class A199_HomePageFactory {
	
	WebDriver driver;
	
	public A199_HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  //initializing elements
	}
	
	@FindBy(id = "srchword")
	WebElement searchbox;
	
	@FindBy(xpath="//form[@name='srchform'] //input[@class='newsrchbtn']")
	WebElement searchbtn;
	
	public WebElement search() {
		return searchbox;
	}
	
	public WebElement clickSearch() {
		return searchbtn;
	}

}
