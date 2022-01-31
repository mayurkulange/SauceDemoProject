package Dependancy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroup {
	@Test
	public void m5() {
		System.out.println("I am m5 method");
	}
	@Test(dependsOnGroups = {"Smoke"})
	public void m6() {
		System.out.println("I am m6 method");
	}
	@Test
	public void m7() {
		System.out.println("I am m7 method");
	}@Test(groups = "Smoke")
	public void m8() {
		System.out.println("I am m8 method");
		Assert.assertFalse(true);
	}@Test(groups = "Smoke")
	public void m9() {
		System.out.println("I am m9 method");
	}@Test(groups = "Smoke")
	public void m10() {
		System.out.println("I am m10 method");
	}
}
