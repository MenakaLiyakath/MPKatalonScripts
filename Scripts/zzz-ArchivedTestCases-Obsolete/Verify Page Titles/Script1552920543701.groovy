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

WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session Actions-Create New Session/Session Actions - Create New Session'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('null'), 'Session Overview: Christ The King Session')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/sidebar/sessionVolunteersLink'))

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/headerbar/headerTitle'), 'Session Volunteers: Christ The King Session')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/sidebar/sessionParticipantsLink'))

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/headerbar/headerTitle'), 'Session Participants: Christ The King Session')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/sidebar/sessionGroupsLink'))

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/headerbar/headerTitle'), 'Group Assignments: Christ The King Session')

WebUI.click(findTestObject('null'))

WebUI.verifyElementText(findTestObject('null'), 'Alpha Sessions & Retreats')

