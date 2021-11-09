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

WebUI.delay(3)

//Card#709 changes starts here
   WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_addParticipant'), 
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'), 
 LastName, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/icon_addParticipant_close'), 
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyElementPresent(findTestObject('Object Repository/CommonPageObjects/lightbox_common_unsavedChanges/label_unsavedChanges_wantToProceed'), 
 2, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.click(findTestObject('CommonPageObjects/lightbox_common_unsavedChanges/button_unsavedChanges_discardChanges'), 
 FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipants_header'), 
 2, FailureHandling.CONTINUE_ON_FAILURE)
//Card#709 changes ends here
