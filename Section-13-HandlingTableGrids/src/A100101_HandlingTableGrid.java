import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A100101_HandlingTableGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/31638/aus-vs-ind-2nd-odi-india-tour-of-australia-2020-21");
		int totalRuns=0;
		//Creating minidriver for selecting only first inning's batting table
		
		WebElement batdriver = driver.findElement(By.xpath("//div[@id='innings_1']/div[1]"));
		
		// storing number batsmen played
		int count = batdriver.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']")).size();
		
		//fetching runs scored by all batsmen one by one 
		for(int i=1; i<count; i++) {
			
			String value = batdriver.findElements(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']")).get(i).getText();
			totalRuns = totalRuns + Integer.parseInt(value);  //parsing string to integer
		}
		
		//fetching extras and total aand adding to totalRuns
		String extras = batdriver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		totalRuns = totalRuns + Integer.parseInt(extras);
		
		//fetching actual score
		String actualscore = batdriver.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText();
		int actualScore = Integer.parseInt(actualscore);
		
		//Comparing result
		/*if(actualScore == totalRuns) {
			System.out.println("Correct!");
		}
		else {
			System.out.println("Something wrong!");
		}*/
		
		//Comparing result using try catch and assert
		
		try {
			Assert.assertEquals(actualScore, totalRuns);
			System.out.println("Correct!");
		}
		catch (AssertionError e){
			System.out.println("Wrong!");
		}
		
		
		driver.close();
	}

}
//