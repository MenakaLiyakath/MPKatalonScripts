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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

/*WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Name'), GroupName)

WebUI.click(findTestObject('module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('module_grow/page_group/tab_group_details/content_group_unsavedLightbox'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/icon_group_closeUnsavedLightbox'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)*/

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Name'), GroupName)

if (GroupType != '') {
	WebUI.click(findTestObject('module_grow/page_group/tab_group_details/input_group_Type'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'groupType\']//div[@class=\'ng-option\']//span[@class=\'ng-option-label\'][text()=\'' +
			GroupType) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}


WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Focus'), Focus)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Location'), PrimaryLocation)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Address'), Address)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/input_group_Room'), Room)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_details/textarea_group_Notes'), GroupNotes)

if (Audience == 'Open') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceOpen'))
}

if (Audience == 'Select Audience') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_selectAudience'))
}

if (Audience == 'By Invite') {
    WebUI.click(findTestObject('module_grow/page_group/tab_group_details/radio_group_audienceByInvite'))
}

WebUI.click(findTestObject('module_grow/page_group/tab_group_details/button_group_save'))

WebUI.delay(2)

WebUI.click(findTestObject('module_grow/sidebar_grow/link_groupSidebar_overviewMenu'))

WebUI.delay(2)

