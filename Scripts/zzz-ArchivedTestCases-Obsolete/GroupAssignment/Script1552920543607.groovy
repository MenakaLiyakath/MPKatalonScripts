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
        , ('Address') : '123 Fourth Ave., Ann Arbor, MI 48104', ('NumberOfMeetings') : '10'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/Volunteer-Roles'), [('saveDisabledBGcolor') : '', ('firstRowParticipantLastName') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/ParticipantEntry - Old and Out of Date'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/sidebar/sessionGroupsLink'))

WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/input_sessionGroups_numberOfGroups'), '1')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_create'))

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_1hostOne'), 'Hosty, Helpo', false)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperOne'), 'Helpy, Hosto', false)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_save'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/label_sessionGroups_saveSuccessAlert'), 0)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/sidebar/sessionParticipantsLink'))

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/sidebar/sessionGroupsLink'))

WebUI.delay(1)

WebUI.verifyOptionSelectedByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/label__groupAssignment_1hostOne'), 'Hosty, Helpo', false, 
    0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperOne'), 'Helpy, Hosto', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_hostTwo'), 'Hosty, Helpo', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_hostTwo'), 'Helpy, Hosto', 
    false, 0)

WebUI.verifyOptionNotSelectedByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_hostTwo'), 'Smith, Molly', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_hostTwo'), 'Johnson, Jim', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperTwo'), 'Hosty, Helpo', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperTwo'), 'Helpy, Hosto', 
    false, 0)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperTwo'), 'Smith, Molly', 
    false, 0)

WebUI.verifyOptionNotSelectedByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/dropDown__groupAssignment_helperTwo'), 'Johnson, Jim', 
    false, 0)

