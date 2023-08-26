package Frames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal_practice
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("https://www.snapdeal.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebElement signIn=driver.findElement(By.xpath("//span[text()='Sign In']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(signIn).perform();
	    driver.findElement(By.className("//a[text()='login']")).click();
	    driver.switchTo().frame("iframeLogin");
	    driver.findElement(By.id("userName")).sendKeys("4564586486");
	    driver.findElement(By.id("close-pop")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.name("keyword")).sendKeys("Soft Toys");
	    driver.findElement(By.className("searchTextSpan")).click();
	    driver.quit();
	    
	}
}
