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

TestData ourParticipantDataSet = findTestData(indicateDataFile)

for (def index : (startIndexToGroup..(startIndexToGroup + numberToGroup) - 1)) {
	
	String currentIndexGroupName = ourParticipantDataSet.internallyGetValue('groupName', index)
	
    String lastNameCommaFirstName = (ourParticipantDataSet.internallyGetValue('newParticipantRowLastNameCell', index) + 
    ', ') + ourParticipantDataSet.internallyGetValue('newParticipantRowFirstNameCell', index)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//table[@id=\'participantGroupTable\']//td[text()=\'' + 
        lastNameCommaFirstName) + '\']/ancestor::tr[1]//select', true)

    WebUI.selectOptionByLabel(dynamicObject, currentIndexGroupName, false)

    WebUI.delay(1)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('//table[@id=\'participantGroupTable\']//td[text()=\'' + 
        lastNameCommaFirstName) + '\']/ancestor::tr[1]', true)

    WebUI.verifyElementAttributeValue(dynamicObject, 'class', 'disabled-row', 0)
	
	if (currentIndexGroupName == 'Group 1'){
		
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', "(.//table[@class='group-table'])[1]//td[contains(text(),'"+lastNameCommaFirstName+"')]", true)
	WebUI.verifyElementPresent(dynamicObject,0)
	}
	if (currentIndexGroupName == 'Group 2'){
		
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', "(.//table[@class='group-table'])[2]//td[contains(text(),'"+lastNameCommaFirstName+"')]", true)
	WebUI.verifyElementPresent(dynamicObject,0)
	}
}

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//button[@id=\'saveButton\']', true)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

