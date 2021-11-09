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

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/input_group_Name'), 'value', FailureHandling.CONTINUE_ON_FAILURE), GroupName, false, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/input_group_Type'), null, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupType\']//span[@class=\'ng-value-label\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), GroupType, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/input_group_Focus'), 'value', FailureHandling.CONTINUE_ON_FAILURE), Focus, false, FailureHandling.CONTINUE_ON_FAILURE)
if (Audience=='By Invite')
{
WebUI.verifyElementChecked(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceByInvite'), 2, FailureHandling.CONTINUE_ON_FAILURE)
}
if (Audience=='Open')
{
WebUI.verifyElementChecked(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceOpen'), 2, FailureHandling.CONTINUE_ON_FAILURE)
}
if (Audience=='Select Audience')
{
WebUI.verifyElementChecked(findTestObject('module_grow/page_group/tab_group_details/radio_group_selectAudience'), 2, FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/input_group_Location'), 'value', FailureHandling.CONTINUE_ON_FAILURE), PrimaryLocation
, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Address'), 'value', FailureHandling.CONTINUE_ON_FAILURE), Address, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/input_group_Room'), 'value', FailureHandling.CONTINUE_ON_FAILURE), Room, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Notes'), 'value', FailureHandling.CONTINUE_ON_FAILURE), GroupNotes
, false, FailureHandling.CONTINUE_ON_FAILURE)

