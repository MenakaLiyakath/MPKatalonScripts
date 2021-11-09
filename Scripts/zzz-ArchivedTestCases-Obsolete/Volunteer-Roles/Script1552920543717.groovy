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
import org.openqa.selenium.Keys as Keys

WebUI.delay(1)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/pageStyles/VolunteerPageLayout'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Johnson', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Jim', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'disabled', 0)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.verifyElementNotPresent(findTestObject('null'), 1)

WebUI.setText(findTestObject('null'), '  ')

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'disabled', 0)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.verifyElementNotPresent(findTestObject('null'), 1)

WebUI.setText(findTestObject('null'), '  ')

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'disabled', 0)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.verifyElementNotPresent(findTestObject('null'), 1)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('null'), '734-555-12346', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'jim@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'learning', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '2018', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'cooking', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('null'), 'Food', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Smith', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Molly', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '(313)4321234', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'none', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('null'), 'Food', FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Jones', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Jill', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'jj@jj.com')

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.setText(findTestObject('null'), 'Hosty', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Helpo', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'h@h.com')

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.setText(findTestObject('null'), 'Helpy', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Hosto', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'h2@h.com')

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('null'), 'Volunteer Pool (5)', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/sidebar/sessionOverviewLink'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeader(s)'), 'Jill Jones')

