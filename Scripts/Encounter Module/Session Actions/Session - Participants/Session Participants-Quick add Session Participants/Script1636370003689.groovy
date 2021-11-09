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
import java.io.File as File


/*This script handles session paticipant creation*/

WebUI.delay(3)


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_addParticipant'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/modal__sessionsParticipants_participant'),
		2)
def name = (LastName + ', ') + FirstName
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'),
		LastName, FailureHandling.CONTINUE_ON_FAILURE)


if(WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_similarRecord'), 2, FailureHandling.CONTINUE_ON_FAILURE))
{

	setProfileDetails()
	
		WebUI.comment('Card#858 changes ends here')
	
		//findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_addParticipant')
		WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/button_addParticipant_saveAndClose'),
				FailureHandling.CONTINUE_ON_FAILURE)
	
		WebUI.waitForElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/modal__sessionsParticipants_participant'),
				2)


	
}

else
{
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@class=\'ng-option ng-option-disabled\']//span[text()=\'' +  name) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
	if(WebUI.verifyElementClickable(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE))
	{
		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}

}

def setProfileDetails()
{
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_firstName'),
			FirstName, FailureHandling.CONTINUE_ON_FAILURE)
	
	if(religiousAffiliation!='')
	{
	if(WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_religiousAffiliation'), 0, FailureHandling.CONTINUE_ON_FAILURE))
	{
	WebUI.click((findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_religiousAffiliation')), FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'religious-affiliation-input\']//ng-dropdown-panel//div//span[text()=\''+religiousAffiliation+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject)
	}
	}
	

	
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_phoneNumber'),
			PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'),
			Email, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'),
			'      ', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipants_childCareRequest'),
			Childcare, FailureHandling.CONTINUE_ON_FAILURE)

	if (SeatingConnection != '') {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_seatMeWith'),
				SeatingConnection, FailureHandling.CONTINUE_ON_FAILURE)
	}

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_dietaryRestrictions'),
			DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_comments'),
			AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)

	if (RefSource != '') {
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/dropDown_addParticipant_referenceSource'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_referenceSourceDropdown'),
				RefSource)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//*[@id=\'referenceSourceDropdown\']//div//span[@class=\'ng-option-label\']', true)

		WebUI.click(dynamicObject)
	}

	WebUI.comment('Card#858 changes starts here')

	println(PreferredContactMethodEmail)

	println(PreferredContactMethodText)

	println(PreferredContactMethodPhoneCall)

	if (PreferredContactMethodEmail != '') {
		if (PreferredContactMethodEmail.toString().toLowerCase() == 'yes') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/checkbox_addParticipant_preferredContactEmail'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	if (PreferredContactMethodText != '') {
		if (PreferredContactMethodText.toString().toLowerCase() == 'yes') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/checkbox_addParticipant_preferredContactText'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	if (PreferredContactMethodPhoneCall != '') {
		if (PreferredContactMethodPhoneCall.toString().toLowerCase() == 'yes') {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/checkbox_addParticipant_preferredContactPhone'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

}
