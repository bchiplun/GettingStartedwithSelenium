package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A145_CarLoan {
	
	@Test(enabled=false)
	public void webLoginCarLoan() {
		System.out.println("Web Login car Loan");
	
	}
	
	@BeforeMethod
	public void bfMethod()
	{
		System.out.println("***This will be exeuted before each method present in this test folder.. scope is limited for this class only");
	}
	
	@AfterMethod
	public void afMethod()
	{
		System.out.println("***This will be exeuted after each method present in this test folder.. scope is limited for this class only");
	}
	
	@Test(dataProvider = "getData")
	public void mobileLoginCarLoan(String uname, String pass) {
		System.out.println("Mobile Login car Loan");
		System.out.println(uname);
		System.out.println(pass);
	}
	
	@Test(groups= {"A"}) 
	public void mobilesigninCarLoan() {
		System.out.println("Mobile signin car Loan");
	
	}
	
	@Test
	public void mobiledignoutCarLoan() {
		System.out.println("Mobile signout car Loan");
	
	}
	
	@Test(dependsOnMethods= {"mobiledignoutCarLoan"})
	public void APILoginCarLoan() {
		System.out.println("API Login car Loan");
	
	}
	
	@DataProvider
	public Object getData() {
		//gives 3 usernames and passwords
		Object[][] data = new Object[3][2];
		data[0][0] = "name1";
		data[0][1] = "passw1";
		data[1][0] = "name2";
		data[1][1] = "passw2";
		data[2][0] = "name3";
		data[2][1] = "passw3";
		
		return data;
		
	}

}
