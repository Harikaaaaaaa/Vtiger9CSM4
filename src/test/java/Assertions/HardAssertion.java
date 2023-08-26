package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion 
{
	@Test
    public void Demo()
    {
    	String s1="Hello";
    	String s2="hello";
    	
    	Assert.assertEquals(s1, s2);    //Error next lines will skip
    	
    	System.out.println(s1);
    	System.out.println(s2);
    }
}
