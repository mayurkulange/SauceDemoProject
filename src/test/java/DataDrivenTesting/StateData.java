package DataDrivenTesting;

import org.testng.annotations.DataProvider;

public class StateData {
	@DataProvider(name = "FirstD")
	public Object[][] dataProvider(){
		Object[][] obj = {{"MH","Maharashtra"},{"RJ","Rajasthan"},{"PJ","Punjab"}};
		
		return obj;
	}
}
