package AlertPopUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileuploadpopup
{

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("https://www.naukri.com/registration/createAccount?");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//button[text()='Upload Resume']")).click();
	    Thread.sleep(5000);
	    //select the file path
	    StringSelection str=new StringSelection("C:\\Users\\DELL\\Downloads\\Sushanthi Resume -1.pdf");
	    //set the file path to system clip board
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	    //Paste the path to File upload pop up 
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(5000);
	    driver.quit();
	    
	    
	}

}
