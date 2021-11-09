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



    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']//td[text()=\'' + 
        FirstName) + '\']/preceding-sibling::td[text()=\'') + LastName) + '\']/preceding-sibling::td', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/icon_sessionsParticipants_delete'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_deleteParticipants/button_deleteParticipants_confirmDelete'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']//td[text()=\'' + 
        FirstName) + '\']/preceding-sibling::td[text()=\'') + LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

