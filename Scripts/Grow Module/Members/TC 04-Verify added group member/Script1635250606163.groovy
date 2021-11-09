import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


if(navigateToMembers=='yes')
{
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName)

WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', "Is equal to")

WebUI.delay(1)

		
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','//kendo-grid[@id=\'leadershipKendoGrid\']//kendo-grid-list//table//td//span[text()=\''+LastName+'\']' , true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
