package Testing;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void m1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("I am m1 method");

	}

	@Test(priority = -1)
	public void m2() {
		System.out.println("m2 method");
	}
	@Ignore
	@Test()
	public void m3() {
		System.out.println("m3 method");
	}

	@Test(groups = "sanity")
	public void m4() {
		System.out.println("m4 method");
	}
}
