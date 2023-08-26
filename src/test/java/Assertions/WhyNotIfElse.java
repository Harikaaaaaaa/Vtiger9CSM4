package Assertions;

import org.testng.annotations.Test;

public class WhyNotIfElse
{
	@Test
    public void Demo()
    {
    	String s1="Hello";
    	String s2="hello";
    	if(s1.equals(s2))
    		System.out.println("Pass");
    	else
    		System.out.println("Fail");
    }
}
