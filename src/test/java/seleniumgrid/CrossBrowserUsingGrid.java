package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserUsingGrid 
{
    WebDriver driver;
	
	@Parameters("BROWSER")
	 @BeforeMethod
	   public void methodsetup(String browser) throws MalformedURLException, InterruptedException
	   {
		   URL url=new URL(" http://192.168.43.24:9999/wd/hub");
		   DesiredCapabilities cap= new DesiredCapabilities();
		   switch (browser) 
		   {
		case "chrome":
			cap.setBrowserName("chrome");
			break;
		case "firefox":
			cap.setBrowserName("firefox");
			break;
		case "edge":
			cap.setBrowserName("msedge");
			break;

		default:
			System.out.println("Invalid browser");
		}
		   
		   cap.setPlatform(Platform.WINDOWS);
		   driver=new RemoteWebDriver(url,cap);
	   }
	@Test
	public void test1() throws InterruptedException 
	{
		   
		   driver.manage().window().maximize();
		   driver.get("https://www.google.com/");
		   Thread.sleep(3000);
		   
	    }
	@AfterMethod
	public void methodclose()
	{
		driver.close();
		   
	   }
}
