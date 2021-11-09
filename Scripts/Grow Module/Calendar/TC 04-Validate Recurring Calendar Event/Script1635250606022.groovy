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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/button_calendar_addEvent'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Validate Radio buttons for Daily
WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/button_calendar_daily'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_on'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_never'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_after'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_on'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_after'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/calendar_recursive_daily/radio_dailyCalendar_never'), 
    FailureHandling.CONTINUE_ON_FAILURE)

//Validate Radio buttons for Weekly
WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_weekly'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_on'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_never'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_after'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_on'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_after'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_weekly/radio_weeklyCalendar_never'), FailureHandling.CONTINUE_ON_FAILURE)

//Validate Radio buttons for Monthly
WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_monthly'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_after'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_day'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_never'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_on'))

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_repeatOnDay'))

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_repeatOnWeeKDay'))

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_after'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_day'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_never'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_on'))

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_repeatOnDay'))

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_monthly/radio_monthlyCalendar_repeatOnWeeKDay'))

//Validate Radio buttons for Yearly
WebUI.click(findTestObject('module_grow/page_calendar/button_calendar_yearly'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_after'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_never'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_on'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_repeatOnDay'))

WebUI.verifyElementClickable(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_repeatOnMonth'))

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_after'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_never'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_on'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_repeatOnDay'))

WebUI.click(findTestObject('module_grow/page_calendar/calendar_recursive_yearly/radio_yearlyCalendar_repeatOnMonth'))

