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

WebUI.delay(3)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']//td[text()=\''+Email+'\']/ancestor::tr//td[text()=\''+LastName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject)
WebUI.delay(2)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/input_createProfile_skills'),Skills,FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_deleteVolunteers/button_deleteVolunteers_save'),FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(5)
if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'), 2,FailureHandling.CONTINUE_ON_FAILURE))
{
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_resolve'))
	WebUI.delay(5)
	Name = LastName+", "+FirstName
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@class=\'duplicate-buckets\']//table//tbody//tr//td[text()=\''+Name+'\']/ancestor::tr//td[text()=\''+Skills+'\']/ancestor::tr//input)[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@class=\'duplicate-buckets\']//tr//td[text()=\''+Name+'\']/ancestor::tr//td[text()=\''+Skills+'\']/ancestor::tr//input)[1]', true, FailureHandling.CONTINUE_ON_FAILURE)	
	WebUI.click(dynamicObject)
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_duplicateVolunteer/button_duplicateVolunteer_update'))
	WebUI.delay(5)
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_resolve'))
	WebUI.delay(2)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@class=\'duplicate-buckets\']//table//tbody//tr//td[text()=\''+Name+'\']/ancestor::tr//td[text()=\''+Skills+'\']/ancestor::tr//input)[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//div[@class=\'duplicate-buckets\']//tr//td[text()=\''+Name+'\']/ancestor::tr//td[text()=\''+Skills+'\']/ancestor::tr//input)[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementNotPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_duplicateVolunteer/button_duplicateVolunteer_close'))
}
else
println "No duplicates found to resolve"

WebUI.delay(2)