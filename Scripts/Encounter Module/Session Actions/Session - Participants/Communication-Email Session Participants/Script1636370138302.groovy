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

def email1 = findTestData('Encounter/SessionParticipants').getValue(5, 4)

def email2 = findTestData('Encounter/SessionParticipants').getValue(5, 5)

def email3 = findTestData('Encounter/SessionParticipants').getValue(5, 6)

println('email1' + email1)

println('email2' + email2)

println('email3' + email3)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipant_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' + 
    email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' + 
    email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' + 
    email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipant_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipant_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'More\')]', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email1) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email2) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div//div//div[contains(text(),\'' + 
    email3) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipant_communication/input_communicationEmail_subject'), 
    'Test Email', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipant_communication/input_communication_body'), 
    'Email communication testing', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipant_communication/button_communication_send'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//kendo-grid-list//tbody//tr//td[text()=\'' +
	email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//tbody//tr//td[text()=\'' + 
    email1) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//tbody//tr//td[text()=\'' + 
    email2) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'participantsTable\']//tbody//tr//td[text()=\'' + 
    email3) + '\']//ancestor::tr//td//input', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
