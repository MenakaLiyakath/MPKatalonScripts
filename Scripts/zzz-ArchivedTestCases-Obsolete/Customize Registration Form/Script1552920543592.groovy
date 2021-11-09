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

WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session Actions-Create New Session/Session Actions - Create New Session'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Session Overview/label_sessionOverview_registration'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_participantRegistration'))

WebUI.delay(1)

regpageurl = WebUI.getUrl()

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'), 'Jeff', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'), 'Tenbrook', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'), '734-555-5555', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'), 'jten@primeproductions.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), '1 child, 12', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'), 'Andrew B', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'), 'Thanks!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 'Vegetables please', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionName'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Signup-Form-Page-Participants/label_participantSignup_infoSessionDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionStartDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_welcomeHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_signupFor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/Label_participantSignup_requiredErrorMessage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('https://omega-menlo-qa-frontend.herokuapp.com/')

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_logout'))

WebUI.deleteAllCookies()

WebUI.delay(1)

WebUI.navigateToUrl('https://omega-menlo-qa-frontend.herokuapp.com/addOrView')

WebUI.delay(3)

testurl = WebUI.getUrl()

WebUI.verifyMatch(testurl, loginurl, true)

WebUI.navigateToUrl(regpageurl)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'), 'Andrew', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'), 'Briggs', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'), '313-555-4567', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'), 'andrewbriggs@dc8.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), '2 children, 15, 20', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'), 'JT', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'), 'Really excited!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 'Meat', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionName'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Signup-Form-Page-Participants/label_participantSignup_infoSessionDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionStartDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_welcomeHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_signupFor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/Label_participantSignup_requiredErrorMessage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', true, FailureHandling.CONTINUE_ON_FAILURE)

customSettingSessionId = CustomKeywords.'cKDbActions.dbActions.executeQuery'('SELECT pk_id FROM public.sessions WHERE user_id = \'5c239182e7844e5e82589724\'')

CustomKeywords.'cKDbActions.dbActions.executeInsertCustomSettingQuery'(customSettingSessionId, 'hasChildcareAvailable', 
    'false')

WebUI.navigateToUrl(regpageurl, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'))

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'), 'Matt', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'), 'Slonecki', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'), '9895553124', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'), 'matt1989@wyliecollege.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 'clean challenge', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionName'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Signup-Form-Page-Participants/label_participantSignup_infoSessionDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionStartDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_welcomeHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_signupFor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/Label_participantSignup_requiredErrorMessage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', true, FailureHandling.CONTINUE_ON_FAILURE)

customSettingSessionId = CustomKeywords.'cKDbActions.dbActions.executeQuery'('SELECT pk_id FROM public.sessions WHERE user_id = \'5c239182e7844e5e82589724\'')

CustomKeywords.'cKDbActions.dbActions.executeInsertCustomSettingQuery'(customSettingSessionId, 'hasDietaryRestrictionsAvailable', 
    'false')

WebUI.navigateToUrl(regpageurl, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'), 'Rita', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'), 'Smith', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'), '(419) 555-2152', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'), 'beachfan@newsurf.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'), 'Matt Slonecki please', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'), 'This is my first time!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionName'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Signup-Form-Page-Participants/label_participantSignup_infoSessionDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionStartDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_welcomeHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_signupFor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/Label_participantSignup_requiredErrorMessage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', true, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'cKDbActions.dbActions.updateQuery'('UPDATE public.custom_session_settings SET custom_value = true where fk_name=\'hasChildcareAvailable\'')

WebUI.navigateToUrl(regpageurl, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), 1, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'cKDbActions.dbActions.updateQuery'('UPDATE public.custom_session_settings SET custom_value = true where fk_name=\'hasDietaryRestrictionsAvailable\'')

WebUI.navigateToUrl(regpageurl, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'), 'Sarah', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'), 'D\'Amato', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'), '517.555.7349', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'), 'sarah@damatorestaurants.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'), '3 children, 2 4 6', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 'no chocolate', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionName'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Signup-Form-Page-Participants/label_participantSignup_infoSessionDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_infoSessionStartDate'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_welcomeHeader'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_signupFor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/Label_participantSignup_requiredErrorMessage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl('https://omega-menlo-qa-frontend.herokuapp.com/login')

WebUI.delay(3)

try {
    WebUI.click(findTestObject('page_login/button_login_lastLogin'))
}
catch (def e) {
    WebUI.setText(findTestObject('page_login/input_login_email'), 'shani@menloinnovations.com')

    WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), 'b2v+j84GDvCDyV1ZIgd/gw==')

    WebUI.click(findTestObject('page_login/button_login_logIn'))
} 

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 'Christ The King Session', false)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), 
    'value', 'Tenbrook', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantFirstName'), 
    'value', 'Jeff', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantPhoneNumber'), 
    'value', '734-555-5555', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantEmail'), 
    'value', 'jten@primeproductions.com', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantConnections'), 
    'value', 'Andrew B', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantChildcare'), 
    'value', '1 child, 12', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantOther'), 
    'value', 'Thanks!', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantDietaryRestrictions'), 
    'value', 'Vegetables please', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/secondparticipantLastName'), 
    'value', 'Briggs', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/secondparticipantFirstName'), 
    'value', 'Andrew', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/secondparticipantChildcare'), 
    'value', '', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/thirdparticipantEmail'), 
    'value', 'matt1989@wyliecollege.com', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/thirdparticipantPhone'), 
    'value', '9895553124', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fourthparticipantChildcare'), 
    'value', '', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fourthparticipantConnections'), 
    'value', 'Matt Slonecki please', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fourthparticipantDietaryRestrictions'), 
    'value', '', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fifthparticipantChildcare'), 
    'value', '3 children, 2 4 6', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fifthparticipantDietaryRestrictions'), 
    'value', 'no chocolate', 0, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.verifyElementAttributeValue(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/fifthparticipantLastName'), 
    'value', 'D\'Amato', 0, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'cKDbActions.dbActions.closeDatabaseConnection'()

