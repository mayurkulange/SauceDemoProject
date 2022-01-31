package DataDrivenTesting;

import org.testng.annotations.Test;

public class DemoData {
	@Test(dataProvider = "Excel", dataProviderClass = ExcelStates.class)
	public void m1( String StateCode, String StateName) {
		System.out.println("  State code : " + StateCode + "\t" + "State Name : " + StateName);
	}
}
