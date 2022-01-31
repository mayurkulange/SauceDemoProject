package Dependancy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardDependancy {
	@Test(dependsOnMethods = {"m2"})
	public void m1() {
		System.out.println("I am m1 method");
	}
	@Test
	public void m2() {
		System.out.println("I am m2 method");
		Assert.assertTrue(true);
	}
}
