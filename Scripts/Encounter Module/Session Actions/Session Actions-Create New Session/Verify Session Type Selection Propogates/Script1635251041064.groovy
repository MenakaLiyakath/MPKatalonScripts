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

WebUI.delay(2)

WebUI.callTestCase(findTestCase('Common Actions/Common Actions- Module navigation'), [('module') : 'session', ('sidebarLink') : '',('sessionOrRetreatName') : SessName], FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select_sessionOverview_sessionTypes'), 'innerHTML').indexOf(
    ('<span class="ng-value-label">' + SessType) + '</span>') < 0) {
    WebUI.verifyMatch('innerHTML of ng-select', 'does not contain SessType', false, FailureHandling.CONTINUE_ON_FAILURE)
}
	
	WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_customizeRegistrationForms'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/label_customizeForm_haveYouAttended')), 
    ('How did you hear about ' + SessType) + '?', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/icon_customizeForm_close'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_participantRegistration'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_referenceSource')), 
    ('How did you hear about ' + SessType) + '?', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.globalBaseHomeURL, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common Actions/Common Actions- Module navigation'), [('module') : 'session', ('sidebarLink') : 'sessionParticipantsLink'
        , ('sessionOrRetreatName') : SessName], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_referenceSource')), 
    ('How did you hear about ' + SessType) + '?', false, FailureHandling.CONTINUE_ON_FAILURE)

