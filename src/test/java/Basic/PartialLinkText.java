package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//*Scenario
//open browser
//Enter demo.actitime.com
//Click on forgotten password
//Click on return to login page
//Close browser
public class PartialLinkText
{

	public static void main(String[] args) throws InterruptedException 
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Return")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
