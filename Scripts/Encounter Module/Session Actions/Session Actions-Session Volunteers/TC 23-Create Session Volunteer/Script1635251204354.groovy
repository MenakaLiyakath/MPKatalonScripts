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
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import java.util.Date as Date
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.lang.String as String
import com.kms.katalon.core.testobject.ConditionType as ConditionType


def name = (LastName + ', ') + FirstName

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_quickAdd'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/modal__sessionsParticipants_participant'),
		2)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_lastName'),
		LastName, FailureHandling.CONTINUE_ON_FAILURE)


	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_firstName'), FirstName, FailureHandling.CONTINUE_ON_FAILURE)
	
	
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_phoneNumber'),
			PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_emailAddress'),
			Email, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_dietaryRestrictions'),
			DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_comments'),
			AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment("964 changes starts here")
	if(Primaryclear == 'yes')
	{
		if (PrimaryRole != '') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/dropDown_createProfile_primaryRole'))

			WebUI.delay(1)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'primaryRoleDropdown\']//span[text()=\'' +
					PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(1)

			WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/icon_createProfile_clearPrimaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(1)
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/icon_createProfile_clearPrimaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//ng-select[@id=\'primaryRoleDropdown\']//div[@class=\'ng-select-container\']',
					true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	else
	if (PrimaryRole != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/dropDown_createProfile_primaryRole'))

		WebUI.delay(1)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'primaryRoleDropdown\']//span[text()=\'' +
				PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if(secondaryclear == 'yes')
	{
		if (SecondaryRole != '') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/dropDown_createProfile_secondaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.delay(1)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'secondaryRoleDropdown\']//span[text()=\'' +
					SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(1)
			WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/icon_createProfile_clearSecondaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)


			WebUI.delay(1)
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/icon_createProfile_clearSecondaryRole'),
					FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//ng-select[@id=\'secondaryRoleDropdown\']//div[@class=\'ng-select-container\']',
					true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
	else
	if (SecondaryRole != '') {

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/dropDown_createProfile_secondaryRole'), FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//*[@id=\'secondaryRoleDropdown\']//span[text()=\'' +
				SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.comment("964 changes ends here")
	}

	switch (Gender) {
		case 'Male':
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_genderMale'))

			break
		case 'Female':
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_genderFemale'))

			break
		case 'Decline to Answer':
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_genderDecline'))
	}

	if (DateOfBirthYear != '') {
		WebUI.clearText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_dateOfBirth'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/button_createProfile_dateOfBirth'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/select_createProfile_year'),
				DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/select_createProfile_month'),
				DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@class=\'ngb-dp-day\']//div[text()=\'' +
				DateOfBirthDay) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodEmail.toString().toLowerCase() == 'yes') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactEmail'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (PreferredContactMethodText.toString().toLowerCase() == 'yes') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactText'),
				FailureHandling.CONTINUE_ON_FAILURE)
		
	}

	if (PreferredContactMethodPhoneCall.toString().toLowerCase() == 'yes') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactPhone'),
				FailureHandling.CONTINUE_ON_FAILURE)
	}

	WebUI.delay(1)


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/button_createProfile_saveAndClose'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/modal__sessionsParticipants_participant'),
		2)


