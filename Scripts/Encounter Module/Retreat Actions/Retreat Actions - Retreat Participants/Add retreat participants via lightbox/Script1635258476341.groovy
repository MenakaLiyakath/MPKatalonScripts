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

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipant_addParticipant'), 
    FailureHandling.CONTINUE_ON_FAILURE)

//Verify if the Save and close button is disabled initally
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/button_addParticipant_saveAndClose'), 
        'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

//Enter input values on lightbox for test

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/input_addParticipant_lastName'), 
        LastName, FailureHandling.CONTINUE_ON_FAILURE)
	if(duplicateCheck=='yes')
	{
		def duplicateName=LastName+", "+FirstName
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'lastNameInput\']//div//span[contains(@id,\'lastAndFirstNameLabel\')][text()=\''+duplicateName+'\']//span[text()=\' - Current Participant\']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementPresent(dynamicObject,2, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/icon_addParticipant_close'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('CommonPageObjects/lightbox_common_unsavedChanges/button_unsavedChanges_discardChanges'),
			FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
	{

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/input_addParticipant_firstName'), 
        FirstName, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/input_addParticipant_phoneNumber'), 
        PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/input_addParticipant_emailAddress'), 
        Email, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)
	
	WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/button_addParticipant_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/textarea_addParticipant_dietaryRestriction'), 
        DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_addParticipant/button_addParticipant_saveAndClose'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	
	WebUI.delay(2)
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//tr[@id=\'participantsTableHeaderRow\']//following::tr[@class=\'retreat-participant-row\']//td[text()=\''+LastName+'\']//following::td[text()=\''+FirstName+'\']//following::td[text()=\''+Email+'\']//following::td[text()=\''+yesValue+'\']',
		true, FailureHandling.CONTINUE_ON_FAILURE)
	
	
	
	WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	
}
