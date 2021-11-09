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

//Validate created session details on session tile and session overview

WebUI.openBrowser(GlobalVariable.globalLoginUrl)

WebUI.delay(2)

WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword)

WebUI.click(findTestObject('page_login/button_login_logIn'))

WebUI.delay(2)
WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_manageSessionsRetreat'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'itemContainer\']//label[@id=\'sessionName\'][text()=\''sessName'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'itemContainer\']//label[@id=\'sessionName\'][text()=\'' +
		sessName) + '\']', true)


WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'itemContainer\']//label[@id=\'sessionName\'][text()=\'' +
		sessName) + '\']//ancestor::div[@id=\'itemContainer\']//div[@id=\'sessionLocation\'][text()=\'') + primLoc) + '\']',
		true)

WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Validate schedule on tile
def sessionStartDate = startDateDay.toInteger()

if (sessionStartDate < 10) {
	startDateDay = ('0' + sessionStartDate.toString())
}

println('startDateDay' + startDateDay)

def startMonthConverted = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.monthConversion'(startDateMonth)

if (startMonthConverted.toInteger() < 10) {
	startMonthConverted = ('0' + startMonthConverted.toString())
}

println('startMonthConverted' + startMonthConverted)

def startDate = (((startMonthConverted + '/') + startDateDay) + '/') + startDateYear

def sessionEndDate = endDateDay.toInteger()

if (sessionEndDate < 10) {
	endDateDay = ('0' + sessionEndDate.toString())
}

println('endDateDay' + endDateDay)

def endMonthConverted = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.monthConversion'(endDateMonth)

if (endMonthConverted.toInteger() < 10) {
	endMonthConverted = ('0' + endMonthConverted.toString())
}

println('endMonthConverted' + endMonthConverted)

def endDate = (((endMonthConverted + '/') + endDateDay) + '/') + endDateYear

def schedule = (startDate + '-') + endDate

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'itemContainer\']//label[@id=\'sessionName\'][text()=\'' +
		sessName) + '\']//ancestor::div[@id=\'itemContainer\']//div[@id=\'sessionSchedule\'][text()=\'') + schedule) + '\']',
		true)

WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/label_sessionTile_sessionNameOnTile',
		[('sessionName') : sessName]), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_sessionName'),
		startDate, FailureHandling.CONTINUE_ON_FAILURE)

String sessionEndDate_1 = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'),
		'value')

SimpleDateFormat sdf = new SimpleDateFormat('MM-dd-yyyy', Locale.ENGLISH)

Date parsedDate = sdf.parse(sessionEndDate_1)

println(parsedDate)

def sessionLeaders

DateTimeFormatter dtf = DateTimeFormatter.ofPattern('MM-dd-yyyy')

LocalDateTime now = LocalDateTime.now()

println('Curr' + dtf.format(now))

Date currentTimeParsed = sdf.parse(dtf.format(now))

println('currentTimeParsed' + currentTimeParsed)

//Validate details on Session Overview page
def sessTypeActual = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_sessionTypes'),
		'textContent', FailureHandling.CONTINUE_ON_FAILURE)
println "sessTypeActual"+sessTypeActual
def typeFlag
if(sessTypeActual.contains(sessType))
{
	typeFlag="True"
}
WebUI.verifyMatch(typeFlag, "True", true, FailureHandling.CONTINUE_ON_FAILURE)


def sessNameActual = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_sessionName'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(sessNameActual, sessName, true, FailureHandling.CONTINUE_ON_FAILURE)

def primaryLocActual = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_primaryLocation'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(primaryLocActual, primLoc, true, FailureHandling.CONTINUE_ON_FAILURE)

def addressActual = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_address'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(addressActual, address, true, FailureHandling.CONTINUE_ON_FAILURE)

def numberOfMeetingsActual = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_numberOfMeetings'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(numberOfMeetingsActual, numberOfMeetings, true, FailureHandling.CONTINUE_ON_FAILURE)

//Validate Registration link on Overview
if (parsedDate.before(currentTimeParsed)) {

	
	def sessionParticipantRegistationLink = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_participantRegistration'),
			FailureHandling.CONTINUE_ON_FAILURE)

	def sessionVolunteerRegistationLink = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/link_sessionOverview_volunteerRegistration'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.openBrowser(sessionParticipantRegistationLink, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyTextPresent('This session has ended and registration is no longer available.', false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.openBrowser(sessionVolunteerRegistationLink, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyTextPresent('This session has ended and registration is no longer available.', false, FailureHandling.CONTINUE_ON_FAILURE)
}

/*WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'),
		FailureHandling.CONTINUE_ON_FAILURE)
*/
