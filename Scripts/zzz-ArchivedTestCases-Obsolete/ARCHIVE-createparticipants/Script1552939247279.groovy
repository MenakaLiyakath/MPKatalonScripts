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

if (indicateDataSource == 'excelsheet') {
    TestData ourParticipantDataSet = findTestData(indicateDataFile)

    for (def index : (0..ourParticipantDataSet.getRowNumbers() - 1)) {
        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowLastNameCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowFirstNameCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowPhoneNumberCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowEmailCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        not_run: WebUI.setText(findTestObject('null'), 
            ourParticipantDataSet.internallyGetValue('newParticipantRowSeatingNotesCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowChildcareCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowCommentsCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
                'newParticipantRowDietaryRestrictionsCell', index), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(1)
    }
}

if ((indicateDataSource == 'custom') && (indicateCustomParticipantNumber > 0)) {
    for (def index : (1..indicateCustomParticipantNumber)) {
        WebUI.setText(findTestObject('null'), participantLastName + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantFirstName + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantPhoneNumber + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantEmail + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        not_run: WebUI.setText(findTestObject('null'), 
            participantSeatingConnection + index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantChildcare + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantDietaryRestrictionsCell, 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.setText(findTestObject('null'), participantOtherComments + 
            index.toString(), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)
    }
}

