package VtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantpath;

public class CreateOrgwithTypeAndIndustry extends BaseClass
{
	@Test
	public void CreateOrgwithIndustryAndTypeTest()
	{
		SoftAssert soft = new SoftAssert();
		home.clickorganisations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String,String> map=excel.readFromExcel("OrganizationTestData", "Create Organization");
		   String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		   createOrg.setOrgName(orgName);
		   
		   createOrg.selectIndustry(web, map.get("Industry"));
		   createOrg.selectType(web, map.get("Type"));
		   createOrg.clickSaveButton();
		   
		   
		   soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		   if(newOrgInfo.getPageHeader().contains(orgName))
			   excel.writeTOExcel("OrganizationTestData", "Create Organization With Industry And Type", "Pass", IConstantpath.EXCEL_PATH);
		   else
			   excel.writeTOExcel("OrganizationTestData", "Create Organization With Industry And Type", "Fail", IConstantpath.EXCEL_PATH);
		   
		  soft.assertAll();
	}
}
