package Base;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A144_SecondTestNG {
	
	@Parameters({"URL"})
	@Test
	public void secondDay(String url) {
		System.out.println("Second day");
		System.out.println("parameter: "+url+"\n");
	}

}
