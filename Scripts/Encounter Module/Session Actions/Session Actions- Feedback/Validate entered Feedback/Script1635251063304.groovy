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

WebUI.delay(2)

println('LastName' + LastName)

println('FirstName' + FirstName)

if (LastName != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'sessionParticipantFeedbackTableContainer\']//table//tr//td[text()=\'' + 
        LastName) + '\']//following-sibling::td[text()=\'') + FirstName) + '\']//ancestor::tr//td//button', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    LastName = 'Anonymous'

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'sessionParticipantFeedbackTableContainer\']//table//tr//td[text()=\'' + 
        LastName) + '\']//ancestor::tr//td//button', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(2)

//Validate if participant drop down /Anonymous checkbox is not editable
if (LastName != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionParticipantsDropdown\']//input', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getAttribute(dynamicObject, 'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/checkBox_feedback_isAnonymous'), 
            'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
}

//Edit Values
if (FeedbackRating != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionRatingDropdown\']//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), FeedbackRating, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (impactDetails != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_impactDetail'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), impactDetails, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (improveExperience != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_improvementDesc'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), improveExperience, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (spiritualityBefore != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'spiritualityBeforeDropdown\']//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), spiritualityBefore, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (spiritualityAfter != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'spiritualityAfterDropdown\']//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), spiritualityAfter, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (futureInterest != '') {
    if (futureInterest == 'Yes') {
        WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/radio_feedback_interested'), 
                'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (futureInterest == 'No') {
        WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/radio_feedback_notInterested'), 
                'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (comments != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_comments'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), comments, false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/icon_feedback_close'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

