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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import java.util.Calendar as Calendar

/* Variable Definition */
/*want to check the merge test */
def getElementText

//Git changes
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_week'))

WebUI.delay(1)

WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_month'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Conversion for Month year and date
if (isToday.toString().toLowerCase().equals('yes')) {
	//Conversion for Month year and date handled if Start date of the event is today
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_day'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_today'))

	/*All day event */

	if (AllDay == 'yes') {
		WebUI.doubleClick(findTestObject('module_grow/page_calendar/page_calendar_todayEvents/span_todayEvents_allDayEvent'),
				FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		convertCalendarTime(StartTime)
	}
	WebUI.delay(1) //Start time and end time to be implemented once the time issue on calendar is fixed
	WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_startTime'))

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	CustomKeywords.'verificationFunctions.kendoGridCalendar.pickKendoTime'(StartTimeHours, StartTimeMinutes, StartAMPM,
			dynamicObject)
} else {
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_addEvent'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_startDate'))

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

	CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(StartYear, StartMonth, StartDay, dynamicObject)
}

if (Group != '') {
	WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/dropDown_scheduleMeeting_groupName'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'group-name\']//div//span[text()=\'' +
			Group) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/input_scheduleMeeting_meetingName'),
			Meeting, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.comment('Set start Date/Time and End Date/time ')

	WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_endDate'),
			FailureHandling.CONTINUE_ON_FAILURE)

	CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(EndYear, EndMonth, EndDay, dynamicObject) //Start time and end time to be implemented once the time issue on calendar is fixed
	/*    WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_endTime'), 
	 FailureHandling.CONTINUE_ON_FAILURE)
	 CustomKeywords.'verificationFunctions.kendoGridCalendar.pickKendoTime'(EndTimeHours, EndTimeMinutes, EndAMPM, dynamicObject)*/
}

WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/input_scheduleMeeting_location'),
		Location, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/input_scheduleMeeting_room'),
		Room, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/textArea_scheduleMeeting_address'),
		Address, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.comment('test')

