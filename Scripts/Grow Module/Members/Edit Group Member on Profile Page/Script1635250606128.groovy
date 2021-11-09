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

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_lastName'), 
    LastName)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_firstName'), 
    FirstName)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_phone'), 
    Phone)

WebUI.setText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_email'), 
    Email)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_editOnProfile_journeyPoints'))

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/select_journeyPoints_experience'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
    GroupName) + '\']', true)

WebUI.click(dynamicObject)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/select_journeyPoints_role'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'roles-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
    Role) + '\']', true)

WebUI.click(dynamicObject)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/button_journeyPoints_save'))

