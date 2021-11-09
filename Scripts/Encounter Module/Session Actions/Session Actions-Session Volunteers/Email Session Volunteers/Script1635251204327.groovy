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

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
/*
actualToEmails = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_emailVolunteers/input_emailVolunteers_toAddress'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)*/

def sendToCount = expectedEmails.size() - 2

println('expectedEmails.size()::::' + expectedEmails.size())

def sendToCountText = (' ' + sendToCount.toString()) + ' More '

println('sendToCountText::::' + sendToCountText)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div[text()=\'' + sendToCountText) + 
    '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_emailVolunteers/input_emailVolunteers_toAddress'), 
    FailureHandling.CONTINUE_ON_FAILURE)

for (def index : (0..expectedEmails.size() - 1)) {
    def Email = expectedEmails[index]

    println('Email:::::' + Email)

    WebUI.delay(1)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tag-input[@id=\'to-address\']//tag//div[@title=\'' + 
        Email) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
}
//
WebUI.delay(1)

