package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A145_PersonalLoan {
	
	
	@Test
	public void webLoginpersoanlLoan() {
		System.out.println("Web Login personal Loan");
	
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("**This will always be executed before current test folder!!");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("**This will always be executed after current test folder!!");
	}
	
	@BeforeSuite(groups= {"B"})
	public void bfSuit() {
		System.out.println("*This will be executed before entire test suit");
	}
	
	@AfterSuite
	public void afSuit() {
		System.out.println("*This will be executed after entire test suit");
	}
	
	@BeforeMethod
	public void bfMethod2()
	{
		System.out.println("*2**This will be exeuted before each method present in this test folder.. scope is limited for this class only");
	}
	
	@AfterMethod
	public void afMethod2()
	{
		System.out.println("*2**This will be exeuted after each method present in this test folder.. scope is limited for this class only");
	}
	
	@Test(groups= {"A"})
	public void mobileLoginpersoanlLoan() {
		System.out.println("Mobile Login personal Loan");
	
	}
	
	@Test(groups= {"B"})
	public void APILoginpersoanlLoan() {
		System.out.println("API Login personal Loan");
	
	}

}
