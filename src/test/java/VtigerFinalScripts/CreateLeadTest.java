package VtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateLeadTest extends BaseClass
{
	 public static String lastName;
	   @Test
	   public void createLeadTest()
	   {
		   
		   SoftAssert soft=new SoftAssert();
		   home.clickLeads();
		   lead.clickPlusButton();
		   soft.assertTrue(driver.getTitle().contains("Leads"));
		   lead.clickPlusButton();
		   soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		   Map<String,String> map=excel.readFromExcel("LeadTestData", "Create Lead");
		    String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		    excel.writeToExcel("LeadTestData", 7, 3, lastName,IConstantpath.EXCEL_PATH);
		   createLead.setLastName(lastName);
		   createLead.setCompantName("Company");
		   createLead.clickSaveButton();
		   soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		   if(newLeadInfo.getPageHeader().contains(lastName))
			   excel.writeTOExcel("LeadTestData", "Create Lead", "Pass", IConstantpath.EXCEL_PATH);
		   else
		   excel.writeTOExcel("LeadTestData", "Create Lead", "Fail", IConstantpath.EXCEL_PATH);
		   
		   soft.assertAll(); 
	   }
}
