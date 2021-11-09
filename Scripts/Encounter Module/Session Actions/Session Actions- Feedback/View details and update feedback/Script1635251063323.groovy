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
if(LastName!='')
{
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'sessionParticipantFeedbackTableContainer\']//table//tr//td[text()=\''+LastName+'\']//following-sibling::td[text()=\''+FirstName+'\']//ancestor::tr//td//button', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}
else
{
	LastName='Anonymous'
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'sessionParticipantFeedbackTableContainer\']//table//tr//td[text()=\''+LastName+'\']//ancestor::tr//td//button', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(2)
//Validate if participant drop down /Anonymous checkbox is not editable
if(LastName!='')
{
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionParticipantsDropdown\']//input', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(WebUI.getAttribute(dynamicObject, 'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

}
else
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/checkBox_feedback_isAnonymous'), 'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)



//Edit Values

if(FeedbackRating!='')
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_sessionRating'))
	WebUI.delay(1)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionRatingDropdown\']//div//span[@class=\'ng-option-label\'][text()=\''+FeedbackRating+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(1)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

if(impactDetails!='')
{
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_impactDetail'), impactDetails, FailureHandling.CONTINUE_ON_FAILURE)
}
if(improveExperience!='')
{
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_improvementDesc'), improveExperience, FailureHandling.CONTINUE_ON_FAILURE)
}
/*if(spiritualityBefore!='')
 {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityBefore'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityBeforeDropdown'), spiritualityBefore, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(1)
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityBeforeDropdown',[('selectBeforeSpirituality'):spiritualityBefore]), FailureHandling.CONTINUE_ON_FAILURE)
 }
 if(spiritualityAfter!='')
 {
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityAfter'), FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityAfterDropdown'), spiritualityAfter, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(1)
 WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityAfterDropdown',[('selectAfterSpirituality'):spiritualityAfter]), FailureHandling.CONTINUE_ON_FAILURE)
 }*/

if(spiritualityBefore!='')
{
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityBefore'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityBeforeDropdown'), spiritualityBefore, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)

	//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityBeforeDropdown',[('selectBeforeSpirituality'):spiritualityBefore]), FailureHandling.CONTINUE_ON_FAILURE)

}
if(spiritualityAfter!='')
{

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityAfter'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityAfterDropdown'), spiritualityAfter, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)
	//WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityAfterDropdown',[('selectAfterSpirituality'):spiritualityAfter]), FailureHandling.CONTINUE_ON_FAILURE)

}
if(futureInterest!='')
{
	if(futureInterest=='Yes')
	{
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/radio_feedback_interested'), FailureHandling.CONTINUE_ON_FAILURE)

	}

	if(futureInterest=='No')
	{

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/radio_feedback_notInterested'), FailureHandling.CONTINUE_ON_FAILURE)

	}
}

if(comments!='')
{
	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_comments'), comments, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/button_feedback_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)

