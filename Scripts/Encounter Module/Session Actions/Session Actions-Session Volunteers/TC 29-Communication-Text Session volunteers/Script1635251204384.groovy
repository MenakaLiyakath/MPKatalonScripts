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

def email1 = findTestData('People').getValue(8, 38)

def email2 = findTestData('People').getValue(8, 39)

def email3 = findTestData('People').getValue(8, 40)

def PhoneNumber1 = (((('(' + findTestData('People').getValue(9, 38).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 38).substring(3, 6)) + '-') + findTestData('People').getValue(9, 38).substring(6)

def PhoneNumber2 = (((('(' + findTestData('People').getValue(9, 39).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 39).substring(3, 6)) + '-') + findTestData('People').getValue(9, 39).substring(6)

def PhoneNumber3 = (((('(' + findTestData('People').getValue(9, 40).substring(0, 3)) + ') ') + findTestData('People').getValue(
    9, 40).substring(3, 6)) + '-') + findTestData('People').getValue(9, 40).substring(6)

//}
println('PhoneNumber1' + PhoneNumber1)

println('PhoneNumber2' + PhoneNumber2)

println('PhoneNumber3' + PhoneNumber3)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_text'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_text'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_emailVolunteers/radio_emailVolunteers_text'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tag-input[@id=\'to-phone\']//tag//div//div//div[contains(text(),\'More\')]', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-phone\']//tag//div//div//div[contains(text(),\'' + 
    PhoneNumber1) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-phone\']//tag//div//div//div[contains(text(),\'' + 
    PhoneNumber2) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-phone\']//tag//div//div//div[contains(text(),\'' + 
    PhoneNumber3) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_emailVolunteers/textArea_emailVolunteers_body'), 
    'Text communication testing', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_emailVolunteers/button_emailVolunteers_send'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//table[@id=\'volunteersTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	PhoneNumber3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

