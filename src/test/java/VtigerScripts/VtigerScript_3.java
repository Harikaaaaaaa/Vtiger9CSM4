package VtigerScripts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VtigerScript_3
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
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
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    if(driver.getTitle().contains("Contacts"))
	    	System.out.println("Contacts Page Displayed");
	    else
	    	System.out.println("Contacts Page Not Found");
	    driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    WebElement Createcontact=driver.findElement(By.xpath("//span[text()='Creating New Contact']"));
	    if(Createcontact.isDisplayed())
	        System.out.println("Creating new contact page is displayed");
	    else
	        System.out.println("Creating new contact page not displayed");
	    Random random=new Random();
		int randomnum=random.nextInt(100);
		String L_name="naveen"+randomnum;
		driver.findElement(By.name("lastname")).sendKeys("L_name");
		driver.findElement(By.xpath(" //input[normalize-space(@value)='Save']")).click();
		String Contact=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Contact.contains(L_name))
	    	System.out.println("Contacts Created successfully");
	    else
	    	System.out.println("Contact not created");
		WebElement Icon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions a=new Actions(driver);
	    a.moveToElement(Icon).perform();
	    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

	}

}
