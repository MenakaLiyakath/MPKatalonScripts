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


WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Set edited values for existing events
if (Group != '') {
	WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/dropDown_scheduleMeeting_groupName'),
		FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'group-name\']//div//span[text()=\'' +
		Group) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_meetingName'), 
        Meeting, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.comment('Set start Date/Time and End Date/time ')

    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/button_editMeeting_startDate'))

    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(StartYear, StartMonth, StartDay, dynamicObject)

    WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/button_editMeeting_endDate'), FailureHandling.CONTINUE_ON_FAILURE)

    CustomKeywords.'verificationFunctions.kendoGridCalendar.kendoDatePicker'(EndYear, EndMonth, EndDay, dynamicObject)

    WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_location'), 
        Location, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/input_editMeeting_room'), Room, 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/textArea_editMeeting_address'), 
        Address, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_editMeeting/button_editMeeting_save'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2)
}

//Navigate back to Week page to make the flow run 
WebUI.click(findTestObject('Object Repository/module_grow/page_calendar/button_calendar_week'), FailureHandling.CONTINUE_ON_FAILURE)



