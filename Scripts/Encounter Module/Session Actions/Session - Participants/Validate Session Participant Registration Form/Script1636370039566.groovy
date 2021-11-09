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

WebUI.navigateToUrl(GlobalVariable.globalizedParticipantRegLink)

//Validate gender display
println('customizeGenderContatDisplay' + customizeGenderContatDisplay)

if (customizeGenderContatDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_genderMale'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate age display
println('customizeAgeDisplay' + customizeAgeDisplay)

if (customizeAgeDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_age'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Hear About ACT display
println('customizeHearAboutACTSDisplay' + customizeHearAboutACTSDisplay)

if (customizeHearAboutACTSDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_referenceSource'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Have About ACT display
println('customizeHaveAboutACTSDisplay' + customizeHaveAboutACTSDisplay)

if (customizeHaveAboutACTSDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_attendChurch'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate religious affiliation  display
println('customizeReligiousDisplay' + customizeReligiousDisplay)

if (customizeReligiousDisplay == 'yes') {
	WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignUp_religiousAffiliation'),
		0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Church Affiliation display
println('customizeChurchAffilationDisplay' + customizeChurchAffilationDisplay)

if (customizeChurchAffilationDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_isAttendingYes'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Child Care display
println('customizeChildCareDisplay' + customizeChildCareDisplay)

if (customizeChildCareDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Seat Me display
println('customizeSeatMeDisplay' + customizeSeatMeDisplay)

if (customizeSeatMeDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate comments display
println('customizeCommentsDisplay' + customizeCommentsDisplay)

if (customizeCommentsDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Dietary display
println('customizeDietaryDisplay' + customizeDietaryDisplay)

if (customizeDietaryDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Spirituality display
println('customizeSpiritualityDisplay' + customizeSpiritualityDisplay)

if (customizeSpiritualityDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_spirituality'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

//Validate Preferred Contact display
println('customizePreferredContatDisplay' + customizePreferredContatDisplay)

if (customizePreferredContatDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_email'), 
        0, FailureHandling.CONTINUE_ON_FAILURE)
}

/*//Validate Payments
if (customizePmtsFeeDisplay == 'yes') {
    WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_continuetoPayment'), 
        1, FailureHandling.CONTINUE_ON_FAILURE)
}
*/
