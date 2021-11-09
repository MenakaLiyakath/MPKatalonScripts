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

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('DB Action/DB Action-MP DB activity'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/HomePage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session Actions-Create New Session/Session Actions - Create New Session'), [('SessName') : 'Christ The King Session', ('PrimLoc') : 'The Church'
        , ('Address') : '123 Fourth Ave., Ann Arbor, MI 48104', ('NumberOfMeetings') : '10', ('pageURL') : ''], FailureHandling.STOP_ON_FAILURE)

'Maximize current window'
WebUI.maximizeWindow()

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 'Christ The King Session', false)

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_openSession'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

WebUI.setText(findTestObject('null'), 'Arnie', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Bamuor', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '734-555-12346', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'ABamour@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Learning, Cooking, Cleaning', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '2018', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'cooking', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

WebUI.setText(findTestObject('null'), 'Carlson', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Donell', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '734-555-2314', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'DonelC@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'coding football crafts etc.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '2017', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Session Lead', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

WebUI.setText(findTestObject('null'), 'Edward', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Foot', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '248-555-0909', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'EddieF@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'N/A', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '2016', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'None', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

WebUI.setText(findTestObject('null'), 'Henson', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Garry', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '248.555.1234', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Hen_Gar@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Teaching & stuff', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '2018', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'setup/takedown', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/sidebar/sessionOverviewLink'))

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeader(s)'), 'Donell Carlson, Garry Henson')

