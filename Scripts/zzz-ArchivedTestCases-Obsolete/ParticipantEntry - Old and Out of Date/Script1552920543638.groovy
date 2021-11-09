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

try {
    WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_requiredFieldsHelperText'), '* denotes required fields')
}
catch (def e) {
    WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('DB Action/DB Action-MP DB activity'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/HomePage'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session Actions-Create New Session/Session Actions - Create New Session'), [('SessName') : 'Christ The King Session', ('PrimLoc') : 'The Church'
            , ('Address') : '123 Fourth Ave., Ann Arbor, MI 48104', ('NumberOfMeetings') : '10'], FailureHandling.STOP_ON_FAILURE)

    not_run: WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'))

    not_run: WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/Volunteer-Roles'), [('saveDisabledBGcolor') : '', ('firstRowParticipantLastName') : ''], 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'))
} 

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/pageStyles/ParticipantPageLayout'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Paul', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'John', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('null'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('null'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '  ', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('null'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('null'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '  ', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

saveDisabledBGcolor = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'), 'background-color', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(saveDisabledBGcolor, 'rgb(201, 201, 201)', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '313-555-1986', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'john@aviary.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'seat me with Peter please!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '1 child, age 6', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'looking forward to it!', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'meat please', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantDietaryRestrictions'))

WebUI.verifyMatch(testValue, 'meat please', false)

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/secondparticipantLastName'), 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Piazza', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Peter', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'peter@fahleylumber.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'friend of Paul', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'No children', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'none', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/secondparticipantLastName'))

WebUI.verifyMatch(testValue, 'Piazza', false)

WebUI.setText(findTestObject('null'), 'Muncil', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Abbey', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '734 688 9120', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '13, 9, and 7 year old.. my seven year old is VERY allergic to peanuts. I will have an epipen on my person I need to give to whoever is responsible for childcare.', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'My son is VERY allergic to peanuts. ', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/thirdparticipantChildcare'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, '13, 9, and 7 year old.. my seven year old is VERY allergic to peanuts. I will have an epipen on my person I need to give to whoever is responsible for childcare.', 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'cancelled comment', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/icon_editProfile_close'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantConnections'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'seat me with Peter please!', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/label_editProfile_lastName'), 'Last Name*')

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/label_editProfile_firstName'), 'First Name*')

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_lastName'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'Paul', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_firstName'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'John', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'john@aviary.com', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, '(313) 555-1986', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('null'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'looking forward to it!', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('null'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, '1 child, age 6', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_seatingNotes'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'seat me with Peter please!', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_dietaryRestrictions'), 'value', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'meat please', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Updated Comment', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('null'), 'Updated child care request', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_seatingNotes'), 'Updated Seating Notes', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_dietaryRestrictions'), 'Updated Dietary Restrictions', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_lastName'), '@', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_lastName'), 'New Last Name', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_firstName'), '&', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_firstName'), 'New First Name', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), Keys.chord(Keys.BACK_SPACE))

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'))

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'), ' ')

WebUI.delay(1)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'), '3135551987', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'), 'updated@email.com', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'))

WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_alertMessage'))

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantLastName'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'New Last Name', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantFirstName'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'New First Name', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantPhoneNumber'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, '(313) 555-1987', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantEmail'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'updated@email.com', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantConnections'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'Updated Seating Notes', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantChildcare'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'Updated child care request', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantDietaryRestrictions'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'Updated Dietary Restrictions', false, FailureHandling.CONTINUE_ON_FAILURE)

testValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/firstparticipantOther'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(testValue, 'Updated Comment', false, FailureHandling.CONTINUE_ON_FAILURE)

