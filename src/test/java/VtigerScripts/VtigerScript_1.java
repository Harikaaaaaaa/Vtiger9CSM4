package VtigerScripts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerScript_1
{

	public static void main(String[] args)
	{
		WebDriver driver=new 	ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    if(driver.getTitle().contains("vtiger"))
	    	System.out.println("Login Page Displayed");
	    else
	    	System.out.println("Login Page Not Found");
	    
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).submit();
	    
	    if(driver.getTitle().contains("Home"))
	    	System.out.println("Home Page Displayed");
	    else
	    	System.out.println("Home Page Not Found");
	    
	    driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
	    
	    if(driver.getTitle().contains("Organizations"))
	    	System.out.println("Organization Page Displayed");
	    else
	    	System.out.println("Organization Page Not Found");
	    
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    WebElement createorg= driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	    
	    if(createorg.getText().equals("Creating New Organization"))
	    	System.out.println("Creating New Organization Page Displayed");
	    else
	    	System.out.println("Creating New Organization Page Not Found");

	    
	   Random random=new Random();
	   int randomnum=random.nextInt(100);
	    
	   String OrgName="TCS"+randomnum;
	   driver.findElement(By.name("accountname")).sendKeys(OrgName);
	   driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	   
	   String NewOrgInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   
	   if(NewOrgInfo.contains(OrgName))
	    	System.out.println("Organization Created successfully");
	    else
	    	System.out.println("Organization not created");
	   
	    WebElement  adminicon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(adminicon).perform();
	    
	   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	   driver.quit();
	    

	}

}
