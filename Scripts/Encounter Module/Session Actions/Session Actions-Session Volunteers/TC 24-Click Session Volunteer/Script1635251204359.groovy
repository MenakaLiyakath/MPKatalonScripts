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
//import java.time.Period;
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import java.lang.String
import java.util.Date as Date
import java.util.Calendar as Calendar







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

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'volunteerGrid\']//table[@class=\'k-grid-table\']//td[text()=\'' +  FirstName + '\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\'' + LastName + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

/*Click on Basic Tab*/
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_basicInfo'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_lastName'),
		'value'), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_firstName'),
		'value'), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

if(PhoneNumber!='')
{
if (!(PhoneNumber.substring(0, 1) == '(')) {
	PhoneNumber = ((((('(' + PhoneNumber.substring(0, 3)) + ') ') + PhoneNumber.substring(3, 6)) + '-') + PhoneNumber.substring(
			6))
}
}

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_phone'),
		'value'), PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_email'),
		'value'), Email, false, FailureHandling.CONTINUE_ON_FAILURE)



switch (Gender) {
	case 'Male':
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_male'),
		1)

		break
	case 'Female':
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_feMale'),
		1)

		break
	case 'Decline to Answer':
		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_declineToAnswer'),
		1)
}

if (PreferredContactMethodEmail != '') {
	WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactEmail'),
			2, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredContactMethodText != '') {
	WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactText'),
			2, FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredContactMethodPhoneCall != '') {
	WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactPhone'),
			2, FailureHandling.CONTINUE_ON_FAILURE)
}

def dateofBirthonsession = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_dateOfBirth'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

println('dateofBirthonsession++++++' + dateofBirthonsession)

def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'

if (dateofBirthonsession == '') {
	WebUI.verifyMatch(DateOfBirthMonth, '', false)

	WebUI.verifyMatch(DateOfBirthDay, '', false)

	WebUI.verifyMatch(DateOfBirthYear, '', false)
}

if (dateofBirthonsession != '') {
	Date participantDOBconverted = new SimpleDateFormat('MM-dd-yyyy hh:mm:ss').parse(dateofBirthonsessionwithtime)

	println('Converted Session End Date' + participantDOBconverted)

	Date date1 = Calendar.getInstance().getTime()

	print('Current date::' + date1)

	LocalDate today = LocalDate.now()

	print('Current local date date::' + today //Today's date
			)

	int DateOfBirthYear_int = Integer.parseInt(DateOfBirthYear)

	int DateOfBirthDay_int = Integer.parseInt(DateOfBirthDay)

	int dobMonth

	//switch(DateOfBirthMonth.toString().toLowerCase()) {
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

	String dobMonth_string

	if (dobMonth < 10) {
		dobMonth_string = ('0' + dobMonth.toString())
	} else {
		dobMonth_string = dobMonth.toString()
	}

	String dobday

	if (DateOfBirthDay_int < 10) {
		dobday = ('0' + DateOfBirthDay_int.toString())
	} else {
		dobday = DateOfBirthDay_int.toString()
	}

	String dobString = (((dobMonth_string + '-') + dobday) + '-') + DateOfBirthYear

	if (dateofBirthonsession != dobString) {
		WebUI.verifyMatch(dateofBirthonsession, dobString, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	LocalDate birthday = LocalDate.of(DateOfBirthYear_int, dobMonth, DateOfBirthDay_int)

	//Birth date
	Period p = Period.between(birthday, today)

	println('Age**********' + p)

	def completeage = p.toString()

	String[] completeage_split

	completeage_split = completeage.split('Y')

	def age = completeage_split[0].toString().replace('P', '')

	print('Final Age:::' + age)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_journeyPoints'),
			FailureHandling.CONTINUE_ON_FAILURE)

	if (!(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/label_editProfile_personNameAndAge')).contains(
	(', ' + age) + ' years old'))) {
		WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/label_editProfile_personNameAndAge')),
				'should match ' + age, false, FailureHandling.CONTINUE_ON_FAILURE)

		println('Age of the Participant is not displayed ')
	} else {
		println('Age of the Participant is displayed properly')
	}
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_basicInfo'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_journeyPoints'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

println('Session Text' + WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_experienceDropdown')))

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_experienceDropdown')),
		Session, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_roleinSession')),
		participantOrVolunteer, false, FailureHandling.CONTINUE_ON_FAILURE)

println('Primary role on app' + WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_primaryRole')))

println('Primaty Role' + PrimaryRole)

println('Secondary role on app' + WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_secondaryRole')))

println('Secondary Role' + SecondaryRole)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_primaryRole')),
		PrimaryRole, false, FailureHandling.CONTINUE_ON_FAILURE)

if (PreferredRoles != '') {
	println('Preferred role on app' + WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_preferredRole')))

	println('Preferred Role' + PreferredRoles)

	WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_preferredRole')),
			PreferredRoles, false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/dropDown_editProfile_secondaryRole')),
		SecondaryRole, false, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.delay(1)

WebUI.comment('changes for card 900 and 901 starts here ')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/icon_editProfile_close'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
 FailureHandling.CONTINUE_ON_FAILURE)
 
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

	    def dropDownInput = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
	 'value', FailureHandling.CONTINUE_ON_FAILURE)
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

	WebUI.comment('navigating to Volunteer Tab and open the Volunteer')

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//table[@id=\'volunteersTable\']//tr[@class=\'volunteer-row\']//td[text()=\'' +
			FirstName) + '\']/preceding-sibling::td[text()=\'') + LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject)

	WebUI.comment('navigating to faith jouney')

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_faithJouney'),
			FailureHandling.CONTINUE_ON_FAILURE)


	WebUI.delay(2)

	WebUI.comment('Validating experience time  for Partcipant')

	if (startdate > todayDate) {
		def expectedTimeFrame = ' Starting  ' + actualStartDate

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

WebUI.comment('changes for card 900 and 901 ends here ')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/tab_editProfile_basicInfo'),
		FailureHandling.CONTINUE_ON_FAILURE)

if (continueExecution == 'yes') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/icon_editProfile_close'),
			FailureHandling.CONTINUE_ON_FAILURE)
}
