package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass
{
	@BeforeSuite
	public void suiteConfg()
	{
		System.out.println("before suite");
	}
	@BeforeTest
	public void TestConfg()
	{
		System.out.println("before test");
	}
	@BeforeClass
	public void classConfg()
	{
		System.out.println("before class");
	}
	@BeforeMethod
	public void methodConfg()
	{
		System.out.println("before method");
	}
	
	@AfterMethod
	public void methodconfig()
	{
		System.out.println(" after method");
	}
	@AfterClass
	public void classconfig()
	{
		System.out.println(" after class");
	}@AfterTest
	public void testconfig()
	{
		System.out.println(" after test");
	}
	@AfterSuite
	public void suiteconfig()
	{
		System.out.println(" after suite");
	}
	


}
