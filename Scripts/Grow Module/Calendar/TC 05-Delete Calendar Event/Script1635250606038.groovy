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

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Convert the start date to validate against the lightbox content

def startMonthConverted = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.convertMonthName'(StartMonth)

def startDateText = (((startMonthConverted + ' ') + StartDay) + ', ') + StartYear

WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_day'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

//Click on calendar to select the start date of the event to validate
WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/button_calendar_calendar'), FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(StartYear, StartMonth, StartDay, dynamicObject)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('module_grow/page_calendar/icon_calendar_deleteEvent', [('MeetingName') : Meeting]),
2, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('module_grow/page_calendar/icon_calendar_deleteEvent', [('MeetingName') : Meeting]),
2, FailureHandling.STOP_ON_FAILURE)) {

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '(//a[@title=\'Delete\'])[1]', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	def eventDescription = WebUI.getText(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_deleteEvent/label_deleteEvent_eventDescription'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(eventDescription, Meeting, false, FailureHandling.CONTINUE_ON_FAILURE)

	def startDate = WebUI.getText(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_deleteEvent/label_deleteEvent_startDate'),
			FailureHandling.CONTINUE_ON_FAILURE)

	def dateFlag

	if (startDate.contains(startDateText)) {
		dateFlag = 'true'
	} else {
		dateFlag = 'false'
	}

	WebUI.verifyMatch(dateFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_deleteEvent/button_deleteEvent_delete'),
			FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)

	WebUI.verifyElementNotPresent(findTestObject('module_grow/page_calendar/icon_calendar_deleteEvent', [('MeetingName') : Meeting]),
	2, FailureHandling.CONTINUE_ON_FAILURE)
}

