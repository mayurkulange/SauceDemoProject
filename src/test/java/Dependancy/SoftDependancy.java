package Dependancy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftDependancy {
	@Test(dependsOnMethods = {"m4"}, alwaysRun = true)
	public void m3() {
		System.out.println("I am m3 method");
	}
	@Test
	public void m4() {
		System.out.println("I am m4 method");
		Assert.assertFalse(true);
	}
}
