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


/* This script is to verify completed filter for sessions*/

WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("Append 0 to day if less than 10")
def sessionEndDate = endDateDay.toInteger()

if(sessionEndDate<10)
{
	endDateDay="0"+sessionEndDate.toString()
}
println "endDateDay"+endDateDay
WebUI.comment("Handle AM/PM and convert hour")
if(endingAMPM=='PM')
{
	def sessionEndHour=endingHour.toInteger()
	def sessionEndHourConverted=sessionEndHour+12
	endingHour=sessionEndHourConverted.toString()

}
WebUI.comment("Convert month to numbers")


def endMonthConverted=CustomKeywords.'customOmegaKeywords.customKeywordsOmega.monthConversion'(endDateMonth)
def endDate=endMonthConverted+"-"+endDateDay+"-"+endDateYear
println "endDate"+endDate

String enddateandtime = endDate + ' '+ endingHour + ':' + endingMinutes + ':' + '00'

println('enddateandtime::' + enddateandtime)



Date parsedEndDate = new SimpleDateFormat('MM-dd-yyyy hh:mm:ss').parse(enddateandtime)

println('Converted Session End Date' + parsedEndDate)

Date currentDate = Calendar.getInstance().getTime()

println('Current Date:::' + currentDate)

println('date::' + currentDate)



WebUI.comment("Validation for Completed Filter")
if (parsedEndDate < currentDate) {

	WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//label[@id=\'sessionName\'][text()=\'' + sessName) +	'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

}


WebUI.uncheck(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)
