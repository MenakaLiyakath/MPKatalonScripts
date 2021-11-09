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
import java.io.File as File
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

def email1 = findTestData('People').getValue(8, 52)

def email2 = findTestData('People').getValue(8, 53)

def email3 = findTestData('People').getValue(8, 54)

def PhoneNumber1 = (((('(' + findTestData('People').getValue(9, 52).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 52).substring(3, 6)) + '-') + findTestData('People').getValue(9, 52).substring(6)

def PhoneNumber2 = (((('(' + findTestData('People').getValue(9, 53).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 53).substring(3, 6)) + '-') + findTestData('People').getValue(9, 53).substring(6)

def PhoneNumber3 = (((('(' + findTestData('People').getValue(9, 54).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 54).substring(3, 6)) + '-') + findTestData('People').getValue(9, 54).substring(6)

//}
println('email1' + email1)

println('email2' + email2)

println('email3' + email3)

//Validate to verify email icon is in disabled state
WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipants_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

//Validate to verify email icon is in enabled state
WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipants_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

//Click email icon
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipants_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

//To validate and click on More in Email communication send to
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'More\')]', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

//Validate all the emails are availble on send to
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email1) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email2) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email3) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipants_emailVolunteers/input_emailVolunteers_subject'), 
    'Test Email', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipants_emailVolunteers/textArea_emailVolunteers_body'), 
    'Email communication testing', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipants_emailVolunteers/button_emailVolunteers_send'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

