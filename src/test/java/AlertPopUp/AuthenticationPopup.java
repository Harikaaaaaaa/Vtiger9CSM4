package AlertPopUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup 
{

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    String text=driver.findElement(By.xpath("//p[normalize-space(text())='Congratulations! You must have the proper credentials.']")).
	    		        getText();
	    System.out.println(text);
	    driver.quit();

	}

}
