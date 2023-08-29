package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactPage;
import pompages.CreateNewContactPage;
import pompages.CreateNewEventPage;
import pompages.CreateNewLeadPage;
import pompages.CreateNewOrganizationPage;
import pompages.DuplicatingLeadPage;
import pompages.HomePage;
import pompages.LeadsPage;
import pompages.LoginPage;
import pompages.NewContactInfoPage;
import pompages.NewEventInfoPage;
import pompages.NewLeadInfoPage;
import pompages.NewOrgInfoPage;
import pompages.OrganizationPage;
//his is an example for baseclass operation
public class BaseClass
{
	 protected PropertiesUtility property;
	   protected ExcelUtility excel;
	   protected JavaUtility jutil;
	   protected WebDriverUtility web;
	   protected WebDriver driver;
	   
	   
	   protected LoginPage login;
	   protected HomePage home;
	   protected OrganizationPage org;
	   protected ContactPage contacts;
	   protected LeadsPage lead;
	   protected CreateNewOrganizationPage  createOrg;
	   protected CreateNewContactPage createContact;
	   protected CreateNewLeadPage createLead;
	   protected CreateNewEventPage createEvent;
	   protected NewOrgInfoPage newOrgInfo;
	   protected NewContactInfoPage newContactInfo;
	   protected NewLeadInfoPage newLeadInfo;
	   protected  NewEventInfoPage newEventInfo;
	   protected  DuplicatingLeadPage duplicatingLead;
	   
	   public static WebDriver sdriver;
	   public static JavaUtility sjutil;
	   
	   
	   
	   //@BeforeSuite
	  // @BeforeTest
	   
	   @BeforeClass
	   public void classSetup()
	   {
		   property =new PropertiesUtility();
		   excel =new ExcelUtility();
		   jutil=new JavaUtility();
		   web= new WebDriverUtility();
		   
		   property.propertiesInitialiation(IConstantpath.PROPERTIES_PATH);
		   driver=web.launchBrowser(property.readFromProperties("browser"));
		   web.maximizeBrowser();
		   web.WaitTillElementFound(Long.parseLong(property.readFromProperties("time"))); 
		   
		   sdriver=driver;
		   sjutil=jutil;
	   }
	   
	   @BeforeMethod
	    public void methodSetup() 
	   {
		   excel.excelInitilization(IConstantpath.EXCEL_PATH);
		   
		   login=new LoginPage(driver);
		   home =new  HomePage(driver);
		   org= new OrganizationPage(driver);
		   contacts= new ContactPage(driver);
		   lead=new LeadsPage(driver);
		   createOrg=new CreateNewOrganizationPage(driver);
		   createContact =new CreateNewContactPage(driver);
		   createLead=new CreateNewLeadPage(driver);
		   createEvent=new CreateNewEventPage(driver);
		   newOrgInfo=new NewOrgInfoPage(driver);
		   newContactInfo=new NewContactInfoPage(driver);
		   newLeadInfo= new NewLeadInfoPage(driver);
		   newEventInfo=new NewEventInfoPage(driver);
		   duplicatingLead=new  DuplicatingLeadPage(driver);
		   
		   web.navigateToApp(property.readFromProperties("url"));
		   Assert.assertTrue(driver.getTitle().contains("vtiger"));
		   login.loginToApp(property.readFromProperties("username"),
				   property.readFromProperties("password"));
		   
		   Assert.assertTrue(driver.getTitle().contains("Home"));   
	   }
	   
	   @AfterMethod
	   public void methodTearDown()
	   {
		   home.signOutVitger(web);
		   excel.closeExcel();
	   }
	   @AfterClass
	   
	   public void classYearDown()
	   {
		   web.quitAllWindows();
	   }
	  // @AfterTest
	  // @AfterSuite
	   
	   
}
