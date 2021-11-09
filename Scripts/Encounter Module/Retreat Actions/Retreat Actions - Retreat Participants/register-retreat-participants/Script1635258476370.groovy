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

println "GlobalVariable.globalizedRetreatParticipantRegLink"+GlobalVariable.globalizedRetreatParticipantRegLink
WebUI.delay(2)
WebUI.navigateToUrl(GlobalVariable.globalizedRetreatParticipantRegLink)
WebUI.delay(4)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/input_participantSignup_lastName'),
		LastName)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/input_participantSignup_firstName'),
		FirstName)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/input_participantSignup_phoneNumber'),
		PhoneNumber)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/input_participantSignup_emailAddress'),
		Email)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/dropDown_participantSignup_comments'),
		AdditionalComments)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/dropDown_participantSignup_dietaryRestrictions'),
		DietaryRestrictions)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

if (IsAttending == 'Yes') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/radio_participantSignup_isAttendingYes'))
}

if (IsAttending == 'No') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/radio_participantSignup_isAttendingNo'))
}
WebUI.comment("Changes for card 744 Starts here")
if (IsAttending == 'Maybe') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/radio_participantSignup_isAttendingMayBe'), FailureHandling.CONTINUE_ON_FAILURE)
}

if (Session != '') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/dropDown_participantSignup_associatedSession'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//span[@class=\'ng-option-label\'][text()=\'' + Session) +
			'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject)
}


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsParticipantSignupForm/button_participantSignup_register'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', false, FailureHandling.CONTINUE_ON_FAILURE)
//Validate RSVP participant on group

