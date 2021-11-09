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

startingParticipantsLabel = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/label_sessionGroups_participantTable'), FailureHandling.CONTINUE_ON_FAILURE)

int startingParticipantsCount = startingParticipantsLabel.substring(15, startingParticipantsLabel.length() - 1).toInteger()

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/page_groupAssignment/button_participantBox_autoAssignButtonWithSeatingPreferences'), FailureHandling.CONTINUE_ON_FAILURE)

for (i = 1; i <= NumberToGroupWithFirstParticipant.toInteger(); i++) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '(.//table[@id=\'participantsTable\']//input)['+i+']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(dynamicObject, NameOfFirstParticipant, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '((.//table[@id=\'participantsTable\']//tr)['+(i+1)+']//span[contains(@class,\'ng-option-label\')])[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	
		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

for (i = (NumberToGroupWithFirstParticipant.toInteger() + 1); i <= (NumberToGroupWithFirstParticipant.toInteger() +NumberToGroupWithSecondParticipant.toInteger()); i++) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '(.//table[@id=\'participantsTable\']//input)['+i+']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(dynamicObject, NameOfSecondParticipant, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '((.//table[@id=\'participantsTable\']//tr)['+(i+1)+']//span[contains(@class,\'ng-option-label\')])[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	
		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/lightbox_sessionGroups_AutoAssign/button_AutoAssign_autoAssign'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_save'))
WebUI.delay(1)