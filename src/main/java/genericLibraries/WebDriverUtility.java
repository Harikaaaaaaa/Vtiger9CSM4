package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains all the reusable methods to perform driver related operations 
 * @author DELL
 *
 */
public class WebDriverUtility 
{
    private WebDriver driver;
    private WebDriverWait wait;
    /**
     * This method is used to launch specified browser
     * @param browser
     * @return
     */
    public WebDriver launchBrowser(String browser)
    {
    	switch(browser)
    	{
    	case "chrome":
    		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
    		driver=new ChromeDriver();
    		break;
    	case "firefox":
    		driver=new FirefoxDriver();
    		break;
    	case "edge":
    		driver=new EdgeDriver();
    		break;
    	default:
    		System.out.println("Invalid browser info");
    	}
    	return driver;
    }
    /**
     * This method is used to maximize the browser
     */
    public void maximizeBrowser()
    {
    	driver.manage().window().maximize();
    }
    /**
     * This method is used to navigate to the specified application
     * @param url
     */
    public void navigateToApp(String url)
    {
    	driver.get(url);
    }
    /**
     * This method is used to wait until till the element is found
     * @param time
     */
    public void WaitTillElementFound(long time)
    
    {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    /**
     * This method is used to wait until element is visible
     * @param time
     * @param element
     * @return 
     */
    public WebElement explicitWait(long time,WebElement element)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(time));
    	return wait.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * This method is used to wait until element is enabled to remove click
     * @param time
     * @param element
     */
    public WebElement explicitWait(WebElement element,long time)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(time));
    	return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * This method is used to wait until web page title appears
     * 
     * @param title
     * @param time
     * @return
     */
    public boolean explicitWait(String title,long time)
    {
    	wait=new WebDriverWait(driver,Duration.ofSeconds(time));
    	return wait.until(ExpectedConditions.titleContains(title));
    }
    /**
     * This method is used to mouse hover on element
     * @param element 
     * @param element
     */
    public void mouseHover(WebElement element)
    {
    	Actions action=new Actions(driver);
    	action.moveToElement(element).perform();
    }
    /**
     * This method is used to right click on an element
     * @param element
     */
    public void rightClick(WebElement element)
    {
    	Actions action=new Actions(driver);
    	action.contextClick(element).perform();
    }
    /**
     * This method is used to double click on an element
     * @param element
     */
    public void doubleClickOnElement(WebElement element)
    {
    	Actions action=new Actions(driver);
    	action.doubleClick(element).perform();
    }
    /**
     * This method is used to drag and drop an element to the target
     * @param element
     * @param target
     */
    public void dragAndDrop(WebElement element,WebElement target)
    {
    	Actions action=new Actions(driver);
    	action.dragAndDrop(element,target).perform();
    }
    /**
     * This method is used to select an element from drop down based on index
     * @param element
     * @param index
     */
    public void selectFromDropDown(WebElement element,int index)
    {
    	Select select=new Select(element);
    	select.selectByIndex(index);
    }
    /**
     * This method is used to select an element from drop down based on value attribute
     * @param element
     * @param value
     */
    public void selectFromDropDown(WebElement element,String value)
    {
    	Select select=new Select(element);
    	select.selectByValue(value);
    }
    /**
     * This method is used to select an element from drop down based on visible text
     * @param visibleText
     * @param element
     */
    public void selectFromDropDown(String visibleText,WebElement element)
    {
    	Select select=new Select(element);
    	select.selectByVisibleText(visibleText);
    }
    /**
     * This method is used to switch the control to frame based on frame index
     * @param index
     */
    public void switchToFrame(int index)
    {
    	driver.switchTo().frame(index);
    }
    /**
     * This method is used to switch the control to frame based on frame id or name
     * @param idOrName
     */
    public void switchToFrame(String idOrName)
    {
    	driver.switchTo().frame(idOrName);
    }
    /**
     * This method is used to switch the control to frame based on frame element
     * @param frameElement
     */
    public void switchToFrame(WebElement frameElement)
    {
    	driver.switchTo().frame(frameElement);
    }
    /**
     * This method is used to switch back from frame to main web page
     */
    public void switchBackFromFrame()
    {
    	driver.switchTo().defaultContent();   
    }
    /**
     * This method is used to take the screenshot of the web page and generate image file
     * @param className
     * @param jUtil
     * @return
     */
    public String takeScreenshot(String className,JavaUtility jUtil)
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./Screenshot/"+className+"_"+jUtil.getCurrentTime()+".png");
    	try
    	{
    		FileUtils.copyFile(src,dest);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	return dest.getAbsolutePath();
    }
    /**
     * This method is used to take the screenshot of the web page and generates BASE64 image
     * @return
     */
    public String takeScreenshot()
    
    {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	return ts.getScreenshotAs(OutputType.BASE64);
    }
    /**
    * This method is used to scroll till the specified web element
    * @param element
    */
   
   public void scrollToElement(WebElement element)
   {
	  JavascriptExecutor js= (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView(true)",element);
   }
   
   /**
    * This method is used to handles alert pop up
    * @param status
    */
   public void handleAlert(String status)
   {
	   Alert alert=driver.switchTo().alert();
	   if(status.equalsIgnoreCase("ok"))
	       alert.accept();
	   else
		   alert.dismiss();
   }
   
   /**
    * This method is used to switch child browser
    */
   
   public void switchToChildWindow()
   {
	   Set<String> set=driver.getWindowHandles();
	   for(String window:set)
	   {
		   driver.switchTo().window(window);
	   }
   }
   
   /**
    * This method is used to switch to  the specified window id
    * @param windowID
    */
   public void switchToWindow(String windowID) 
   {
	   driver.switchTo().window(windowID);
   }
   
   /**
    * This method used to get parent window address
    * @return
    */
   public String getParentWindowID()
   {
	   return driver.getWindowHandle();
   }
   
   /**
    * This method is used to close current window
    */
   public void closeCurrentWindow() 
   {
	   driver.close();
   }
   /**
    * This  method used to quit all windows
    */
   public void quitAllWindows()
   {
	   driver.quit();
   }
   
   /**
    * This method is used to convert string to dynamic path
    * @param commonPath
    * @param replaceData
    * @return
    */
   
   public WebElement convertStringToDynamicXpath(String commonPath, String replaceData)
   {
	   String requiredPath=String.format(commonPath, replaceData);
	   return driver.findElement(By.xpath(requiredPath));
   }
   
   /**
    * This method is used to convert string to dynamic path
    * @param commonPath
    * @param replaceData
    * @return
    */
   
   public WebElement convertStringToDynamicXpath(String commonPath, int replaceData)
   {
	   String requiredPath=String.format(commonPath, replaceData);
	   return driver.findElement(By.xpath(requiredPath));
   }
}
    

