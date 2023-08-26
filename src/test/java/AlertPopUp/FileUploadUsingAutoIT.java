package AlertPopUp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();		
	    driver.manage().window().maximize();
	    driver.get("https://www.naukri.com/registration/createAccount?");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.findElement(By.xpath("//button[text()='Upload Resume']")).click();
	    Thread.sleep(5000);
	    Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\AutoIT\\Fileupload.exe");
	    Thread.sleep(3000);
	}

}


