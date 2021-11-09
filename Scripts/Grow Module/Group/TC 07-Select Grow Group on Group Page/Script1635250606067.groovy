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

WebUI.click(findTestObject('module_grow/page_group/dropdown_group_selectGroup'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupSelector\']//span[@class=\'ng-option-label\'][text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

if(openCalendar.toString().toLowerCase()=='yes')
{
	if(WebUI.verifyElementPresent(findTestObject('Object Repository/module_grow/page_calendar/label_calendar_calendar'), 2, FailureHandling.CONTINUE_ON_FAILURE))
	{
	WebUI.click( findTestObject('Object Repository/module_grow/page_group/tab_group_details/icon_groupDetails_calendar'), FailureHandling.CONTINUE_ON_FAILURE)
	def groupNameOnCalendarFilter=WebUI.getText(findTestObject('Object Repository/module_grow/page_calendar/input_calendar_showGroup'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(groupNameOnCalendarFilter, GroupName, false, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

if(navigateToMember=='yes')
{
	WebUI.click(findTestObject('module_grow/page_group/tab_group_members/tab_groupMembers_membersTab'), FailureHandling.CONTINUE_ON_FAILURE)
}
