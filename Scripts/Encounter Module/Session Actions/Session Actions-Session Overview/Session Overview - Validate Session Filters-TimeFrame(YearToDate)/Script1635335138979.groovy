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



/* This script is to verify Timeframe(YearToDate) filter for sessions*/

WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_currentlyRunningSession'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_sessionTimeFrame'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment("Validation for TimeFrame-Year-to-Date")
//Get Current Year
int year = Calendar.getInstance().get(Calendar.YEAR)
println "year"+year
if(startDateYear.toInteger()>=year)
{
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'sessionTimeFrameSelect\']//div//span[text()=\'Year-to-Date\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//label[@id=\'sessionName\'][text()=\'' + sessName) +	'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
	
}
