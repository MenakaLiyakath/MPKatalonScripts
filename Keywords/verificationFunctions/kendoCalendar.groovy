package verificationFunctions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import java.util.Calendar
import internal.GlobalVariable

public class kendoGridCalendar {

	@Keyword

	def kendoDatePicker(def calendarYear,def calendarMonth,def calendarDay,def dynamicObject) {

		def monthTitle=calendarYear+" "+calendarMonth
		WebUI.delay(2)

		WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/label_scheduleMeeting_selectMonthYear'),
				FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.delay(2)

		WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/label_scheduleMeeting_selectMonthYear'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-calendar-viewlist//table//tbody[@role=\'rowgroup\']//td//span[text()=\''+calendarYear+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

		println "monthTitle"+monthTitle

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-calendar-viewlist//table//tbody[@role=\'rowgroup\']//tr//td[@title=\''+monthTitle+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)




		def month=calendarMonth
		switch (month.toLowerCase()) {
			case 'jan':
				calendarMonth = "January"

				break
			case 'feb':
				calendarMonth = "February"

				break
			case 'mar':
				calendarMonth = "March"

				break
			case 'apr':
				calendarMonth = "April"

				break
			case 'may':
				calendarMonth = "May"

				break
			case 'june':
			case 'jun':
				calendarMonth = "June"

				break
			case 'july':
			case 'jul':
				calendarMonth = "July"

				break
			case 'august':
			case 'aug':
				calendarMonth = "August"

				break
			case 'september':
			case 'sep':
			case 'sept':
				calendarMonth = "September"

				break
			case 'october':
			case 'oct':
				calendarMonth = "October"

				break
			case 'november':
			case 'nov':
				calendarMonth = "November"

				break
			case 'december':
			case 'dec':
				calendarMonth = "December"

				break
		}

		def elementTitle=calendarMonth+" "+calendarDay+", "+calendarYear
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-calendar-viewlist//kendo-virtualization//table//td[contains(@title,\''+elementTitle+'\')]', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword

	def pickKendoTime(def hour, def minute, def amPm,def dynamicObject) {
		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-popup//kendo-timeselector//div//span[text()=\'hour\']//following-sibling::kendo-timelist//ul//li//span[text()=\'' +
				hour) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.scrollToElement(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-popup//kendo-timeselector//div//span[text()=\'minute\']//following-sibling::kendo-timelist//ul//li//span[text()=\'' +
				minute) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.scrollToElement(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-popup//kendo-timeselector//div//span[text()=\'AM/PM\']//following-sibling::kendo-timelist//ul//li//span[text()=\'' +
				amPm) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.scrollToElement(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(2)

		WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.click(findTestObject('module_grow/page_calendar/lightbox_calendar_scheduleMeeting/button_scheduleMeeting_setTime'))
	}
}
