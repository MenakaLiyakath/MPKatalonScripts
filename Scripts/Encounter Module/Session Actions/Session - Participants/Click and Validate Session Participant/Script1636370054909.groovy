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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.lang.String as String
import java.util.Date as Date
import java.util.Calendar as Calendar
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Input filter values')

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/input_sessionVolunteer_lastName'),
		LastName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/kendoFilter_sessionVolunteer_lastName'))


CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/input_sessionVolunteer_firstName'),
		FirstName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/kendoFilter_sessionVolunteer_firstName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'participantsGrid\']//table[@class=\'k-grid-table\']//td[text()=\'' +
		FirstName) + '\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\'') + LastName) + '\']', true)

WebUI.click(dynamicObject)

/* Click on Basic tab*/
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_basicInfo'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

println(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'),
		'disabled', FailureHandling.CONTINUE_ON_FAILURE))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/button_editProfile_save'),
		'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_lastName'),
		'value'), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_firstName'),
		'value'), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

if(religiousAffiliation!='')
{

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'religious-affiliation-input\']//div//span[@class=\'ng-value-label\'][text()=\'' +
			religiousAffiliation) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)


}

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_email'),
		'value'), Email, false, FailureHandling.CONTINUE_ON_FAILURE)

if (!(PhoneNumber.substring(0, 1) == '(')) {
	PhoneNumber = ((((('(' + PhoneNumber.substring(0, 3)) + ') ') + PhoneNumber.substring(3, 6)) + '-') + PhoneNumber.substring(
			6))
}

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_phoneNumber'),
		'value'), PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

if (PreferredContactMethodEmail != '') {
	if (PreferredContactMethodEmail.toString().toLowerCase() == 'yes') {
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactEmail'),
				2, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactEmail'),
				2, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

if (PreferredContactMethodText != '') {
	if (PreferredContactMethodText.toString().toLowerCase() == 'yes') {
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/checkBox__editProfile_preferredContactText'),
				2, FailureHandling.CONTINUE_ON_FAILURE)
	}
} else {
	WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/checkBox__editProfile_preferredContactText'),
			2, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredContactMethodPhoneCall != '') {
	if (PreferredContactMethodPhoneCall.toString().toLowerCase() == 'yes') {
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactPhoneCall'),
				2, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/radio_editProfile_preferredContactPhoneCall'),
				2, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

if (Church != '') {
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_parish'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Church, false, FailureHandling.CONTINUE_ON_FAILURE)
}



def dateofBirthonsession = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_dateOfBirth'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

println('dateofBirthonsession++++++' + dateofBirthonsession)

def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'

if (dateofBirthonsession != '') {
	Date participantDOBconverted = new SimpleDateFormat('MM-dd-yyyy hh:mm:ss').parse(dateofBirthonsessionwithtime)

	println('Converted DOB Date' + participantDOBconverted)

	Date date1 = Calendar.getInstance().getTime()

	print('Current date::' + date1)

	LocalDate today = LocalDate.now()

	print('Current local date date::' + today)

	int DateOfBirthYear_int = Integer.parseInt(DateOfBirthYear)

	int DateOfBirthDay_int = Integer.parseInt(DateOfBirthDay)

	int dobMonth

	switch (DateOfBirthMonth.toLowerCase()) {
		case 'jan':
			dobMonth = 1

			break
		case 'feb':
			dobMonth = 2

			break
		case 'mar':
			dobMonth = 3

			break
		case 'apr':
			dobMonth = 4

			break
		case 'may':
			dobMonth = 5

			break
		case 'june':
		case 'jun':
			dobMonth = 6

			break
		case 'july':
		case 'jul':
			dobMonth = 7

			break
		case 'august':
		case 'aug':
			dobMonth = 8

			break
		case 'september':
		case 'sep':
		case 'sept':
			dobMonth = 9

			break
		case 'october':
		case 'oct':
			dobMonth = 10

			break
		case 'november':
		case 'nov':
			dobMonth = 11

			break
		case 'december':
		case 'dec':
			dobMonth = 12

			break
	}

	LocalDate birthday = LocalDate.of(DateOfBirthYear_int, dobMonth, DateOfBirthDay_int)

	Period p = Period.between(birthday, today)

	println('Age**********' + p)

	def completeage = p.toString()

	String[] completeage_split

	completeage_split = completeage.split('Y')

	def age = (completeage_split[0]).toString().replace('P', '')

	print('Final Age:::' + age)
}


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_journeyPoints'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/dropDown_editProfile_experience'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//span[@class=\'ng-option-label\'][text()=\'' +
		Session) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

/*if (HaveAttended != '') {
 WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@class=\'row form-group\']//label[@id=\'participant-alpha-attended-label\']/following-sibling::div//span[@class=\'ng-value-label\']',
 true, FailureHandling.CONTINUE_ON_FAILURE)
 WebUI.delay(2)
 WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), HaveAttended, false, FailureHandling.CONTINUE_ON_FAILURE)
 }*/
if (Childcare != '') {
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_childCareRequest'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), Childcare, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (SeatingConnection != '') {
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_seatWith'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), SeatingConnection, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (RefSource != '') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_referenceSource'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'participant-reference-source-input\']//span[@class=\'ng-value-label\']',
			true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), RefSource, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (SeatingConnection != '') {
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_seatWith'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), SeatingConnection, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (AdditionalComments != '') {
	WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_comments'),
			'value', FailureHandling.CONTINUE_ON_FAILURE), AdditionalComments, false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_faithJourney'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.comment('changes for card 900 and 901 starts here ')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/icon_editProfile_close'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'),
		FailureHandling.CONTINUE_ON_FAILURE)

/*WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'), 
 FailureHandling.CONTINUE_ON_FAILURE)*/
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

if (Session != '') {
	WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/label_sessionTile_sessionNameOnTile',
			[('sessionName') : Session]), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

	def overviewStartDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_startDate'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	def overviewEndDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	def amPm = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_startAMPM'),
			'textContent', FailureHandling.CONTINUE_ON_FAILURE)

	def actualStartDate = overviewStartDate.toString().replace('-', '/')

	println('actualStartDate' + actualStartDate)

	/*	    def dropDownInput = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'), 
	 'value', FailureHandling.CONTINUE_ON_FAILURE)*/
	WebUI.comment('Calculating the Start Date and Time')

	def startHour

	def startMinutes

	startHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimehours'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	startMinutes = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimeminutes'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.comment('converting the P.M time to 24hours Format')

	if (amPm == 'PM') {
		def convertedStartHour = startHour.toInteger() + 12

		startHour = convertedStartHour.toString()
	}

	def startDateAndTime = ((((actualStartDate + ' ') + startHour) + ':') + startMinutes) + ':00'

	Date startdate = new SimpleDateFormat('MM/dd/yyyy hh:mm:ss').parse(startDateAndTime)

	println('startdate' + startdate)

	WebUI.comment('Calculating the End Date and Time')

	def endHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endtimehours'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	def endMinutes = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endTimeMinutes'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	def actualEndDate = overviewEndDate.toString().replace('-', '/')

	println('actualEndDate' + actualEndDate)

	WebUI.comment('converting the P.M time to 24hours Format')

	if (amPm == 'PM') {
		def convertedEndHour = endHour.toInteger() + 12

		endHour = convertedEndHour.toString()
	}

	def endDateAndTime = ((((actualEndDate + ' ') + endHour) + ':') + endMinutes) + ':00'

	println('endDateAndTime' + endDateAndTime)

	Date endDate = new SimpleDateFormat('MM/dd/yyyy hh:mm:ss').parse(endDateAndTime)

	println('endDate' + endDate)

	Date todayDate = Calendar.getInstance().getTime()

	println('Current Date:::' + todayDate)

	WebUI.comment('navigating to participant Tab and open the participant')

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.comment('Input filter values')

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_lastName'),
			LastName)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_lastName'))

	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

	WebUI.delay(1)

	WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_firstName'),
			FirstName)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_firstName'))

	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

	WebUI.delay(1)

	WebUI.comment('click and open person')

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//kendo-grid[@id=\'participantsGrid\']//table[@class=\'k-grid-table\']//td[text()=\'' +
			FirstName) + '\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\'') + LastName) + '\']', true)

	WebUI.click(dynamicObject)

	WebUI.comment('navigating to faith jouney')

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_faithJourney'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)

	WebUI.comment('Validating experience time  for Partcipant')

	if (startdate > todayDate) {
		def expectedTimeFrame = ' Starting  ' + actualStartDate+' '

		def actualTimeFrame = WebUI.getAttribute(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('(//div[@id=\'current-faith-journey-table\']//div[text()=\'Current Experience\']//ancestor::div//div//a[text()=\'' +
				Session) + '\']//parent::div//following-sibling::div)[2]', true, FailureHandling.CONTINUE_ON_FAILURE), 'textContent',
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(actualTimeFrame, expectedTimeFrame, false, FailureHandling.CONTINUE_ON_FAILURE)
	} else {
		if (endDate < todayDate) {
			def expectedTimeFrame = (((' ' + actualStartDate) + ' - ') + actualEndDate) + ' '

			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'past-faith-journey-table\']//div[text()=\'Past Experience\']//ancestor::div//div//a[text()=\'' +
					Session) + '\']//parent::div//following-sibling::div[text()=\'') + expectedTimeFrame) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		} else {
			def expectedTimeFrame = (((' ' + actualStartDate) + '  - ') + actualEndDate) + ' '

			def actualTimeFrame = WebUI.getAttribute(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('(//div[@id=\'current-faith-journey-table\']//div[text()=\'Current Experience\']//ancestor::div//div//a[text()=\'' +
					Session) + '\']//parent::div//following-sibling::div)[2]', true, FailureHandling.CONTINUE_ON_FAILURE),
					'textContent', FailureHandling.CONTINUE_ON_FAILURE)

			WebUI.verifyMatch(actualTimeFrame, expectedTimeFrame, false, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
}

if (continueValidation.toString().toLowerCase() == 'yes') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/icon_editProfile_close'),
			FailureHandling.CONTINUE_ON_FAILURE)
}

