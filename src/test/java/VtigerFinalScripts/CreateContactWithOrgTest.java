package VtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test
	   public void createContactWithOrgTest()
	   {
		   SoftAssert soft=new SoftAssert();
		   home.clickContacts();
		   soft.assertTrue(driver.getTitle().contains("Contacts"));
		   contacts.clickPlusButton();
		   soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		   Map<String,String> map=excel.readFromExcel("ContactTestData", "Create Contact With Organization");
		   String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		   createContact.setLastName(lastName);
		   createContact.selectExistingOrg(web,map.get("Organization Name"));
		   createContact.clickSaveButton();
		   soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		   if(newContactInfo.getPageHeader().contains(lastName))
			   excel.writeTOExcel("ContactTestData", "Create Contact With Organization", "Pass", IConstantpath.EXCEL_PATH);
		   else
		   excel.writeTOExcel("ContactTestData", "Create Contact With Organization", "Fail", IConstantpath.EXCEL_PATH);
		   
		   soft.assertAll();
		   
		   
		   
	   }
}
