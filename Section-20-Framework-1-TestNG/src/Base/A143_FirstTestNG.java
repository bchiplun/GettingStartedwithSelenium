package Base;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A143_FirstTestNG {
	
	
	@Test
	public void demo1() {
		System.out.println("First TestNG");
		Assert.assertTrue(false);
	}
	
	@Test(groups={"B"})
	public void bye() {
		System.out.println("Bye!");
	}

}
