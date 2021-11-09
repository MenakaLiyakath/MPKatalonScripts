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
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


WebUI.openBrowser(GlobalVariable.globalBaseHomeURL, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/label_sessionTile_sessionNameOnTile', 
        [('sessionName') : sessName]), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//Validate Registration links

def sessionEndDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

def actualEndDate = sessionEndDate.replace('-', '/')

def endHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endtimehours'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

def endMinutes = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endTimeMinutes'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

def amPm = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button__sessionOverview_endAMPM'), 
    'textContent', FailureHandling.CONTINUE_ON_FAILURE)

if (amPm == 'PM') {
    def convertedEndHour = endHour.toInteger() + 12

    endHour = convertedEndHour.toString()
}

def endDateAndTime = ((((actualEndDate + ' ') + endHour) + ':') + endMinutes) + ':00'

Date endDateConverted = new SimpleDateFormat('MM/dd/yyyy hh:mm:ss').parse(endDateAndTime)

Date todayDate = Calendar.getInstance().getTime()

if (endDateConverted < todayDate) {
    def sessionParticipantLink = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_participantRegistration'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    def sessionVolunteerLink = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_volunteerRegistration'), 
        FailureHandling.CONTINUE_ON_FAILURE)
	
	def thankYou='Thank you for your interest!'
	WebUI.navigateToUrl(sessionParticipantLink, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyTextPresent(thankYou, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.navigateToUrl(sessionVolunteerLink, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyTextPresent(thankYou, false, FailureHandling.CONTINUE_ON_FAILURE)
}


