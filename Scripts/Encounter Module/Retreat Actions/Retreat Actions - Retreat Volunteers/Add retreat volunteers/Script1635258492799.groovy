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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/button_retreatVolunteer_page'))

WebUI.delay(2)

println('LastName' + LastName)

if (LastName != '') {
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/input_addVolunteer_lastName'),
			LastName, FailureHandling.CONTINUE_ON_FAILURE)
}

if (duplicateCheck == 'yes') {
	def duplicateName = (LastName + ', ') + FirstName

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'lastNameInput\']//div//span[contains(@id,\'lastAndFirstNameLabel\')][text()=\'' +
			duplicateName) + '\']//span[text()=\' - Current Participant\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/icon_addParticipant_close'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('CommonPageObjects/lightbox_common_unsavedChanges/button_unsavedChanges_discardChanges'),
			FailureHandling.CONTINUE_ON_FAILURE) /*WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_primaryRoleValue',
	 [('primaryRoleValue') : PrimaryRole]), FailureHandling.CONTINUE_ON_FAILURE)
	 println WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_primaryRoleValue',
	 [('primaryRoleValue') : PrimaryRole]), "xpath", FailureHandling.CONTINUE_ON_FAILURE)*/
	//964 changes starts here
	/*
	 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_secondaryRoleValue',
	 [('secondaryRoleValue') : SecondaryRole]), FailureHandling.CONTINUE_ON_FAILURE)*/
} else {
	if (FirstName != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/input_addVolunteer_firstName'),
				FirstName, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (Email != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/input_addVolunteer_emailAddress'),
				Email, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PhoneNumber != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/input_addVolunteer_phoneNumber'),
				PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (AdditionalComments != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/input_addVolunteer_additionalComments'),
				AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (DietaryRestrictions != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/textarea_addVolunteer_dietaryRestrictions'),
				DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)
	}

	println('PrimaryRole' + PrimaryRole)
	WebUI.comment("964 changes starts here")
	if(Primaryclear == 'yes')
	{
		if (PrimaryRole != '') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_primaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.delay(2)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'primaryRoleDropdown\']//div//span[text()=\'' +
					PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

			//validating the clear icon
			WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/icon_addVolunteer_clearPrimaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/icon_addVolunteer_clearPrimaryRole'))

			WebUI.delay(1)
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//ng-select[@id=\'primaryRoleDropdown\']//div[@class=\'ng-select-container\']',
					true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
	else
	if (PrimaryRole != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_primaryRole'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'primaryRoleDropdown\']//div//span[text()=\'' +
				PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	}
	if(secondaryclear == 'yes')
	{
		if (SecondaryRole != '') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_secondaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.delay(2)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'secondaryRoleDropdown\']//div//span[text()=\'' +
					SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
			//validating the clear icon
			WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/icon_addVolunteer_clearSecondaryRole'), FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(1)
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/icon_addVolunteer_clearSecondaryRole'), FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//ng-select[@id=\'secondaryRoleDropdown\']//div[@class=\'ng-select-container\']',
					true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
	else
	if (SecondaryRole != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/dropDown_addVolunteer_secondaryRole'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'secondaryRoleDropdown\']//div//span[text()=\'' +
				SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment("964 changes ends here")
	}

	if (DateOfBirthYear != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/button_retreatSignUp_dateOfBirth'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectyear'),
				DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectmonth'),
				DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

		daySelection = new TestObject('day-selection')

		daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' +
				DateOfBirthDay) + '\']', true)

		WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (Gender != '') {
		switch (Gender.toString().toLowerCase()) {
			case 'male':
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/radio_addVolunteer_male'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'female':
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/radio_addVolunteer_female'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
			case 'decline':
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/radio_addVolunteer_declineToAnswer'),
				FailureHandling.CONTINUE_ON_FAILURE)

				break
		}
	}

	if (PreferredContactMethodEmail != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/checkbox_addVolunteer_email'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodText != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/checkbox_addVolunteer_text'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodPhoneCall != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/checkbox_addVolunteer_phone'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	WebUI.delay(2)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreat_addVolunteer/button_addVolunteer_saveAndClose'),
			FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)

}
