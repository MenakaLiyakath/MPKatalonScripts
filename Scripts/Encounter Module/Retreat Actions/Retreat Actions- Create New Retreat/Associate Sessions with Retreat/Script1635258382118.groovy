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

/* This script is to verify associate sessions with retreat*/
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_associateSessions1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

String[] sessionsToBeAssociatedCheckboxesSplit = sessionsToBeAssociatedCheckboxes.split(';')

for (i = 0; i < sessionsToBeAssociatedCheckboxesSplit.length; i++) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//input[@id=\'' + (sessionsToBeAssociatedCheckboxesSplit[
        i])) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}



WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_overview_associateSessions/button_overview_associateSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_address'),
	retreatAddress, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

