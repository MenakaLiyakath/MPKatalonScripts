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


WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/button_sessionFeedback_save'), 'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/input_sessionFeedback_sessionNotes'), sessionFeedbackNotesActual)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/button_sessionFeedback_save'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionOverview'))
WebUI.delay(1)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/link_sessionFeedback_sessionFeedback'))
WebUI.delay(1)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/input_sessionFeedback_sessionNotes'), 'value', FailureHandling.CONTINUE_ON_FAILURE), sessionFeedbackNotesExpected, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/input_sessionFeedback_sessionNotes'), 'value', FailureHandling.CONTINUE_ON_FAILURE).length().toString(), '4000', false, FailureHandling.CONTINUE_ON_FAILURE)