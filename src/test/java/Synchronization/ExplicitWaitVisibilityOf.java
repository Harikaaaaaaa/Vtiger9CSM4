package Synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//This is an example for explicitlywait operation
public class ExplicitWaitVisibilityOf 
{
	public static void main(String[] args)
	{
	WebDriver driver=new ChromeDriver();	
	driver.manage().window().maximize();
	driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
	driver.findElement(By.xpath("//button[text()='Start']")).click();
	WebElement header=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	String text=wait.until(ExpectedConditions.visibilityOf(header)).getText();
	System.out.println(text);
	driver.close();
	
	}

}
