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

if (LastName!='')
{
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/button_sessionFeedback_add'))
WebUI.delay(1)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_sessionParticipants'), FailureHandling.CONTINUE_ON_FAILURE)
ParticipantName=LastName+", "+FirstName
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionParticipantsDropdown\']//span[@class=\'ng-option-label\'][text()=\''+ParticipantName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementNotPresent(dynamicObject, 0, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/icon_feedback_close'))
}