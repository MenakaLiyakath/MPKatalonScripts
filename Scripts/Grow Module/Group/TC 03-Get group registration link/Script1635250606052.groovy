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

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

WebUI.click(findTestObject('module_grow/page_group/dropdown_group_selectGroup'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupSelector\']//span[@class=\'ng-option-label\'][text()=\''+GroupName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
GlobalVariable.globalizedGrowMemberRegLink=WebUI.getText(findTestObject('Object Repository/module_grow/page_overview/link_overview_memberRegistration'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/button_group_customizeRegistrationForm'))
if(WebUI.verifyElementClickable(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeeRequired'), FailureHandling.CONTINUE_ON_FAILURE))
{
GlobalVariable.globalPmtDesc=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/textarea_customizeForm_pmtfeeDescription'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
GlobalVariable.globalPmtFeeLabel=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeeLabel'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
GlobalVariable.globalPmtPrice=WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_details/lightbox_group_customizeMemberRegistrationForm/input_customizeForm_pmtfeePrice'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)