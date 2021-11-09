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

def yearStart

def monthStart

def dayStart
def startMonthString
def newMonthStart

WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_day'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

//Conversion for Month year and date 
if (isToday != '') {
	//Conversion for Month year and date handled if Start date of the event is today
	Calendar now = Calendar.getInstance()

	yearStart = now.get(Calendar.YEAR)

	monthStart = (now.get(Calendar.MONTH) + 1)

	dayStart = now.get(Calendar.DATE)
	startMonthString=monthStart.toString()

	println "startMonthString"+startMonthString
	newMonthStart= CustomKeywords.'customOmegaKeywords.customKeywordsOmega.intMonthConversion'(startMonthString)

	println(yearStart)

	println(monthStart)

	println(dayStart)

	StartDay=dayStart.toString()

	println "StartDay"+StartDay
	StartYear=yearStart.toString()
	println "StartYear"+StartYear

	println newMonthStart
	StartMonth=  newMonthStart

	println StartMonth

}
else
{
	//Conversion for Month  Start date of the event is not today
	println newMonthStart
	StartMonth=  CustomKeywords.'customOmegaKeywords.customKeywordsOmega.dobMonthConversion'(StartMonth)
}
println StartMonth
monthStart = StartMonth

def monthEnd = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.dobMonthConversion'(EndMonth)

def startDate = (((monthStart + '/') + StartDay) + '/') + StartYear

def endDate = (((monthEnd + '/') + EndDay) + '/') + EndYear

println startDate
println endDate

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Click on calendar to select the start date of the event to validate
WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/button_calendar_calendar'), FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(StartYear, StartMonth, StartDay, dynamicObject)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//multi-day-view//table[@class=\'k-scheduler-table\']//following-sibling::div//div//div[contains(text(),\'' +
		Meeting) + '\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.STOP_ON_FAILURE)) {
	WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	//Validate lightbox values
	WebUI.verifyMatch(WebUI.getText(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_groupName',
			[('groupName') : Group]), FailureHandling.CONTINUE_ON_FAILURE), Group, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_meetingName'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Meeting, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_startDate'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), startDate, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_endDate'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), endDate, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_location'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Location, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_room'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Room, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/module_grow/page_calendar/lightbox_calendar_editMeeting/textArea_editMeeting_address'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Address, false, FailureHandling.CONTINUE_ON_FAILURE)
}

