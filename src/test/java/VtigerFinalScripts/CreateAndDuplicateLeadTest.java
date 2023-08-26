package VtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateAndDuplicateLeadTest extends BaseClass 
{
	@Test
	   public void createAndDuplicateLeadTest()
	   {
		   SoftAssert soft=new SoftAssert();
		   home.clickLeads();
		   lead.clickPlusButton();
		   soft.assertTrue(driver.getTitle().contains("Leads"));
		   lead.clickPlusButton();
		   soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		   Map<String,String> map=excel.readFromExcel("LeadTestData", "Create and Duplicate Lead");
		   String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		   createLead.setLastName(lastName);
		   createLead.setCompantName("Company");
		   createLead.clickSaveButton();
		   soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		   newLeadInfo.clickDuplicateButton();
		   soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating"));
		   String newLastName=map.get("New Last Name")+jutil.generateRandomNum(100);
		   duplicatingLead.setLastName(newLastName);
		   duplicatingLead.clickSaveButton();
		   if(newLeadInfo.getPageHeader().contains(newLastName))
			   excel.writeTOExcel("LeadTestData", "Create and Duplicate Lead", "Pass", IConstantpath.EXCEL_PATH);
		   else
		   excel.writeTOExcel("LeadTestData", "Create and Duplicate Lead", "Fail", IConstantpath.EXCEL_PATH);
		   
		   soft.assertAll(); 
	   }
}
