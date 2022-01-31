package Testing;

import org.testng.annotations.Test;

public class C extends BaseFramework{
	@Test(groups = "sanity")
	public void m1() {
		System.out.println("This is m1 method of c");
		//driver.get("https://www.facebook.com");
	}

	@Test
	public void m2() {
		System.out.println("This is m2 method of c");
	}

	@Test
	public void m3() {
		System.out.println("This is m3 method of c");
	}

	@Test
	public void m4() {
		System.out.println("This is m4 method of c");
	}
}
