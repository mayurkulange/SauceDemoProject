package Testing;

import org.testng.annotations.Test;

public class B extends BaseFramework{
	@Test(groups = "sanity")
	public void m1() {
		System.out.println("This is m1 method of B");
		//driver.get("https://www.facebook.com");

	}

	@Test
	public void m2() {
		System.out.println("This is m2 method of B");
	}

	@Test
	public void m3() {
		System.out.println("This is m3 method of B");
	}

	@Test
	public void m4() {
		System.out.println("This is m4 method of B");
	}
}
