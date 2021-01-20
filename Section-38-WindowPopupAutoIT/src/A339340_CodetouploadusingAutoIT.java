import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A339340_CodetouploadusingAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String currentPath = System.getProperty("user.dir");
		String downloadPath = System.getProperty("user.dir")+"\\downloads";
		System.out.println(downloadPath);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		
		//to set chrome properties
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popup", 0);
		chromePrefs.put("download.default_directory",downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://pdf2doc.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div[id='pick-files'] span[class='ui-button-text']")).click(); 
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(currentPath+"\\AutoITscripttouploadfile.exe");
		
		
		
		/*
		 * To download converted file and to verify if it is downloaded correctly
		 */
		
		System.out.println("Not enabled");
		WebDriverWait w = new WebDriverWait(driver, 15);
		//https://stackoverflow.com/questions/15237129/webdriverwait-for-an-element-attribute-to-change
		w.until(new ExpectedCondition<Boolean>()
		{
			public Boolean apply(WebDriver driver) 
			{
				 WebElement button = driver.findElement(By.xpath("//button[@id='download-all']"));
			        String enabled = button.getAttribute("class");
			        if(enabled.contains("ui-state-disabled")) 
			            return false;
			        else
			            return true;
			}
		});
		
				
		//Thread.sleep(10000);
		
		driver.findElement(By.xpath("//span[normalize-space()='Download All']")).click();
		
		System.out.println("clicked");
		
		Thread.sleep(5000);
		// to verify if correct file is downloaded in downloads folder
		
		File f = new File(downloadPath+"/pdf2doc.zip");
		
		if(f.exists())
		{
			System.out.println("Downloaded file successfully");
		}
		
		if(f.delete())
		{
			System.out.println("File Deleted");
		}
		
	
		Thread.sleep(5000);
		driver.close();

	}

}
