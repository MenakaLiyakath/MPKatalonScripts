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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.text.ParseException as ParseException
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period
import com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword as SetDateCalendarKeyword



/* This script is to verify Timeframe(Last 6 Months) filter for sessions*/
WebUI.comment("Get the duration between start date and current date")


WebUI.comment("Append 0 to day if less than 10")
def sessionStartDate = startDateDay.toInteger()

if(sessionStartDate<10)
{
	startDateDay="0"+sessionStartDate.toString()
}
println "startDateDay"+startDateDay
WebUI.comment("Handle AM/PM and convert hour")
if(startingAMPM=='PM')
{
	def sessionStartHour=startingHour.toInteger()
	def sessionStartHourConverted=sessionStartHour+12
	startingHour=sessionStartHourConverted.toString()

}
WebUI.comment("Convert month to numbers")

def startMonthConverted=CustomKeywords.'customOmegaKeywords.customKeywordsOmega.monthConversion'(startDateMonth)
def startDate=startMonthConverted+"-"+startDateDay+"-"+startDateYear

String startdateandtime = (((((startDate + ' ') + endingHour) + ':') + endingMinutes) + ':') + '00'

println('startdateandtime::' + startdateandtime)

Date parsedStartDate = new SimpleDateFormat('MM-dd-yyyy hh:mm:ss').parse(startdateandtime)

println('Converted Session start Date' + parsedStartDate)
Date currentDate1 = Calendar.getInstance().getTime()


long dateDifference = currentDate1.getTime() - parsedStartDate.getTime()
float daysBetween = (dateDifference / (1000*60*60*24));
println "daysBetween"+daysBetween

WebUI.comment("Validate Last 6 Months")
if(daysBetween<=180)
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_sessionTimeFrame'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionTimeFrameSelect\']//div//span[text()=\'Last 6 Months\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//label[@id=\'sessionName\'][text()=\'' + sessName) +	'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

}
