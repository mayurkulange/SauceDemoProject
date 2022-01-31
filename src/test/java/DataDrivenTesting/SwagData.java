package DataDrivenTesting;

import org.testng.annotations.DataProvider;

public class SwagData {
	@DataProvider(name ="login")
	public Object[][] userData() {
		Object[][] obj = {{"standard_user","secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
		return obj;
		
	}
}
