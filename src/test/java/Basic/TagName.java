package Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//open browser
//Enter facebook.com
//Fetch all the links in the webpage
//Print text on the elements in console
//Close the browser
public class TagName
{

	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		for(WebElement link:links)
		{
			System.out.println(link.getText());
		}
		Thread.sleep(3000);

	}

}
