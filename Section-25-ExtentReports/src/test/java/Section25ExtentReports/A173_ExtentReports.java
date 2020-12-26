package Section25ExtentReports;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class A173_ExtentReports {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		// ExtentReports , ExtentSparkReporter 
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";  // to store reports in reports folder inside current path
		ExtentSparkReporter reporter =  new ExtentSparkReporter(path); // to set thr properties of the extent reports
		reporter.config().setReportName("Web automation report"); 
		reporter.config().setDocumentTitle("Test Result");
		
		extent = new ExtentReports();  //to actually create the report based properties set on reporter
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bhavesh");
		
		
		
	}
	
	
	
	@Test
	public void browserTest() {
		ExtentTest test = extent.createTest("Initial Test");  // create one new test object for generating report and tweaking the report of this method.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chipl\\Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Results do not match"); // Deliberately failing the test only for reporting
		extent.flush();  // to notify that test is completed so it will no longer monitor the method.
	}

}
