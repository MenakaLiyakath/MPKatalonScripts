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

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_duplicateNotification'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)) {

Name = ((LastName + ', ') + FirstName)
//Card#709 changes starts here
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'))
WebUI.delay(2)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('(//div[@class=\'duplicate-buckets\']//tr//td[text()=\'' + 
        Name) + '\']/ancestor::tr//td[text()=\'') + Childcare) + '\']/ancestor::tr//input)[2]', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/CommonPageObjects/lightbox_common_unsavedChanges/label_unsavedChanges_wantToProceed'), 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/lightbox_common_unsavedChanges/button_unsavedChanges_discardChanges'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/label_resolveDuplicants_header'), 2, FailureHandling.CONTINUE_ON_FAILURE)

//Card#709 changes ends here


    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'))

    WebUI.delay(2)

 

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('(//div[@class=\'duplicate-buckets\']//tr//td[text()=\'' + 
        Name) + '\']/ancestor::tr//td[text()=\'') + Childcare) + '\']/ancestor::tr//input)[2]', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_update'))

    WebUI.delay(5)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_resolve'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@class=\'duplicate-buckets\']//tr//td[text()=\'' + 
        Name) + '\']/ancestor::tr//td[text()=\'') + Childcare) + '\']/ancestor::tr//td[text()=\'Verified\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_resolveDuplicants/button_resolveDuplicants_close'))
} else {
    println('No duplicates found to resolve')
}

