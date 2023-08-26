package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_practice {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("https://www.ebay.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement dropdown=driver.findElement(By.id("gh-cat"));
	    Select s=new Select(dropdown);
	    s.selectByIndex(3);
	    Thread.sleep(2000);
	    s.selectByValue("625");
	    Thread.sleep(2000);
	    s.selectByVisibleText("Crafts");
	    if(s.isMultiple())
	    {
	    	System.out.println("Multi select");
	    }
	    else
	    {
	    	System.out.println("Single select");
	    }
	    List<WebElement> dropdownList=s.getOptions();
	    for(WebElement e : dropdownList)
	    {
	    	System.out.println(e.getText());
	    }
	}

}
