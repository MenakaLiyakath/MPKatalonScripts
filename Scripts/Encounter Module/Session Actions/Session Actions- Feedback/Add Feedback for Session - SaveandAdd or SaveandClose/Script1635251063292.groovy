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
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/button_sessionFeedback_add'))
WebUI.delay(2)

def feedbackRowCount=findTestData('Data Files/Session Feedback').getRowNumbers()
for(def feedbackRowindex=1;feedbackRowindex<=feedbackRowCount;feedbackRowindex++)
{

	LastName=findTestData('Data Files/Session Feedback').getValue(1, feedbackRowindex)
	FirstName=findTestData('Data Files/Session Feedback').getValue(2, feedbackRowindex)
	FeedbackRating=findTestData('Data Files/Session Feedback').getValue(3, feedbackRowindex)
	impactDetails=findTestData('Data Files/Session Feedback').getValue(6, feedbackRowindex)
	improveExperience=findTestData('Data Files/Session Feedback').getValue(7, feedbackRowindex)
	spiritualityBefore=findTestData('Data Files/Session Feedback').getValue(8, feedbackRowindex)
	spiritualityAfter=findTestData('Data Files/Session Feedback').getValue(9, feedbackRowindex)
	futureInterest=findTestData('Data Files/Session Feedback').getValue(10, feedbackRowindex)
	comments=findTestData('Data Files/Session Feedback').getValue(11, feedbackRowindex)
	SaveType=findTestData('Data Files/Session Feedback').getValue(12, feedbackRowindex)


	ParticipantName=LastName+", "+FirstName
	if (LastName!='')
	{
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_sessionParticipants'), FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionParticipantsDropdown\']//span[@class=\'ng-option-label\'][text()=\''+ParticipantName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_sessionRating'), FailureHandling.CONTINUE_ON_FAILURE)

	}
	else
	{
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/checkBox_feedback_isAnonymous'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
	}
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
	if(spiritualityBefore!='')
	{
		
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityBefore'), FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityBeforeDropdown'), spiritualityBefore, FailureHandling.CONTINUE_ON_FAILURE)


		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityBeforeDropdown',[('selectBeforeSpirituality'):spiritualityBefore]), FailureHandling.CONTINUE_ON_FAILURE)

	}
	if(spiritualityAfter!='')
	{
		
		

		
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/dropDown_feedback_spiritualityAfter'), FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/input_feedback_spiritualityAfterDropdown'), spiritualityAfter, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/option_feedback_spiritualityAfterDropdown',[('selectAfterSpirituality'):spiritualityAfter]), FailureHandling.CONTINUE_ON_FAILURE)

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

	if(SaveType=='Save and add new')
	{
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/button_feedback_saveAndEnterNew'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)
	}

	if(SaveType=='Save and close')
	{
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/button_feedback_saveAndClose'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(1)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/button_sessionFeedback_add'))
		WebUI.delay(2)
	}
	
	if(feedbackRowindex==feedbackRowCount)
	{
		
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionFeedback/lightbox_sessionFeedback_addFeedback/icon_feedback_close'), FailureHandling.CONTINUE_ON_FAILURE)
		
	}
}