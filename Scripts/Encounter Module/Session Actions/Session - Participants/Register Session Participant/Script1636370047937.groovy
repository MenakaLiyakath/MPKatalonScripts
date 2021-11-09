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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

/*Enter script to validate fields as per customize registraation form
 * Open session based on input and get values from session sheet for customizze
 * validate the fields visiblity as per sheet
 *
 * */
WebUI.navigateToUrl(GlobalVariable.globalizedParticipantRegLink)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_lastName'),
		LastName)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_firstName'),
		FirstName)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_phoneNumber'),
		PhoneNumber)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_emailAddress'),
		Email)

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_genderMale'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	if (Gender == 'Male') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_genderMale'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (Gender == 'Female') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_genderFemale'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (Gender == 'Decline') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_genderdecline'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_age'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	if (Age != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_age'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_age'),
				Age)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'ageDropdown\']//span[text()=\'' + Age) +
				'\']', true)

		WebUI.click(dynamicObject)
	}
}

/*if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_referenceSource'),
 1, FailureHandling.CONTINUE_ON_FAILURE)) {
 if (RefSource != '') {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_referenceSource'),
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_referenceSource'),
 RefSource)
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'referenceSourceDropdown\']//span[text()=\'' +
 RefSource) + '\']', true)
 WebUI.click(dynamicObject)
 }
 }
 */
if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_doYouAttendchurchparish'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	if (DoYouAttendChurch != '') {
		if (DoYouAttendChurch == 'Yes') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_isAttendingYes'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_church'),
					Church, FailureHandling.CONTINUE_ON_FAILURE)
		} else {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_isAttendingNo'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignUp_religiousAffiliation'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignUp_religiousAffiliation'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id = \'religiousAffiliationDropdown\']//div//span[text()=\''+religiousAffiliation+'\']',
			true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

/*if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/label_participantSignup_areYouMember'),
 1, FailureHandling.CONTINUE_ON_FAILURE)) {
 if (Areyouamember != '') {
 if (Areyouamember == 'No') {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radio_participantSignup_areYouMemberNo'),
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_church'),
 Church, FailureHandling.CONTINUE_ON_FAILURE)
 } else {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radio_participantSignup_areYouMemberYes'),
 FailureHandling.CONTINUE_ON_FAILURE)
 }
 }
 }*/
//christian faith added
if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_christianFaith'),
	1, FailureHandling.CONTINUE_ON_FAILURE)) {
		if (ChristianFaith != '') {
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'termsOfChristianFaithDropdown\']//input', true, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.setText(dynamicObject, ChristianFaith, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'termsOfChristianFaithDropdown\']//ng-dropdown-panel//div//span', true, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	
		}
	}




if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/dropDown_participantSignup_spirituality'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	if (Spirituality != '') {
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'spiritualityDropdown\']//input', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.setText(dynamicObject, Spirituality, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'spiritualityDropdown\']//ng-dropdown-panel//div//span', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	}
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/checkBox_participantSignup_childCare'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_childCareRequest'),
			Childcare)
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_seatingNotes'),
			SeatingConnection)
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_comments'),
			AdditionalComments)
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/input_participantSignup_dietaryRestrictions'),
			DietaryRestrictions)
}

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_email'),
1, FailureHandling.CONTINUE_ON_FAILURE)) {
	if (PreferredContactMethodEmail != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_email'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodText != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_text'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodPhoneCall != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/radioButton_participantSignup_phoneCall'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}
}

/* if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_continuetoPayment'),
 1, FailureHandling.CONTINUE_ON_FAILURE)) {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_continuetoPayment'),
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/page_payment/label_payment_description'),
 FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtDesc, false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/page_payment/label_payment_feeLabel'),
 FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtFeeLabel, false, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/page_payment/label_payment_price'),
 FailureHandling.CONTINUE_ON_FAILURE), GlobalVariable.globalPmtPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
 if (PayNow == 'yes') {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/page_payment/radio_payment_now'),
 FailureHandling.CONTINUE_ON_FAILURE)
 } else {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/page_payment/radio_payment_later'),
 FailureHandling.CONTINUE_ON_FAILURE)
 }
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'))
 } else {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'))
 }*/
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormParticipants/button_participantSignup_signUpNow'))
