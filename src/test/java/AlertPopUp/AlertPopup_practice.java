package AlertPopUp;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup_practice
{

	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	    Alert al=driver.switchTo().alert();
	    System.out.println(al.getText());
	    al.accept();
	    
	    
	    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	    System.out.println(al.getText());
	    al.dismiss();
	    System.out.println(driver.findElement(By.id("result")).getText());
	    
	   
	    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	    System.out.println(al.getText());
	    al.sendKeys("papa");
	    al.accept();
	    System.out.println(driver.findElement(By.id("result")).getText());
	    driver.quit();


}
}
