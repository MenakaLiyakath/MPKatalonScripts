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

WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'),2, FailureHandling.CONTINUE_ON_FAILURE))
{

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ((('//strong[text()=\''+LastName) + ', ') + FirstName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

def name=LastName+", "+FirstName

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS','//duplicate-found-lightbox//div[@class=\'duplicate-buckets\']//td[text()=\''+name+'\']' , true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

}

