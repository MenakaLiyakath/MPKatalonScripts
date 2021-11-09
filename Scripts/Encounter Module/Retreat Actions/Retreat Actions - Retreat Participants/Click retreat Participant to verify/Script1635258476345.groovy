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

//Click on the participant name on participant table
if (rsvp == 'yes') {
    def participantXpath = ('//tr[@id=\'participantsTableHeaderRow\']//ancestor::tbody//tr[@class=\'retreat-participant-row\']//following::td[text()=\'' + 
    LastName) + '\']'

    println('participantXpath' + participantXpath)

    WebDriver driver = DriverFactory.getWebDriver()

    List<WebElement> retreatParticipant = driver.findElements(By.xpath(participantXpath))

    def retreatParticipantCount = retreatParticipant.size().toString()

    WebUI.verifyMatch(retreatParticipantCount, '1', false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(2)

def age

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tr[@id=\'participantsTableHeaderRow\']//ancestor::tbody//tr[@class=\'retreat-participant-row\']//following::td[text()=\'' + 
    LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Validate if the Save button is disabled
println(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/button_editParticipant_save'), 
        'disabled', FailureHandling.CONTINUE_ON_FAILURE))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/button_editParticipant_save'), 
        'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

//Validate Proceed functionality
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_lastName'), 
    'Some Last Name', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/icon_editProfile_close'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/CommonPageObjects/lightbox_common_unsavedChanges/label_unsavedChanges_wantToProceed'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/lightbox_common_unsavedChanges/button_unsavedChanges_discardChanges'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tr[@id=\'participantsTableHeaderRow\']//ancestor::tbody//tr[@class=\'retreat-participant-row\']//following::td[text()=\'' + 
    LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 1, FailureHandling.CONTINUE_ON_FAILURE)

//Click on participant link
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//Validate the values of participant
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_lastName'), 
        'value'), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_firstName'), 
        'value'), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_email'), 
        'value'), Email, false, FailureHandling.CONTINUE_ON_FAILURE)

if (!(PhoneNumber.substring(0, 1) == '(')) {
    PhoneNumber = ((((('(' + PhoneNumber.substring(0, 3)) + ') ') + PhoneNumber.substring(3, 6)) + '-') + PhoneNumber.substring(
        6))
}

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_phoneNumber'), 
        'value'), PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

if (PreferredContactMethodEmail != '') {
    if (PreferredContactMethodEmail == 'Yes') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_email'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_email'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodText != '') {
    if (PreferredContactMethodText == 'Yes') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_text'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_text'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodPhoneCall != '') {
    if (PreferredContactMethodPhoneCall == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_phoneCall'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/checkbox_editParticipant_phoneCall'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (Church != '') {
    WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_parish')), 
        Church, false, FailureHandling.CONTINUE_ON_FAILURE)
}

def dateofBirthonsession = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/input_editParticipant_dateOfbirth'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

println('dateofBirthonsession++++++' + dateofBirthonsession)

def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'

if (dateofBirthonsession != '') {
    //
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
    
    LocalDate birthday = LocalDate.of(DateOfBirthYear_int, dobMonth, DateOfBirthDay_int)

    //Birth date
    Period p = Period.between(birthday, today)

    println('Age**********' + p)

    def completeage = p.toString()

    String[] completeage_split

    completeage_split = completeage.split('Y')

    age = completeage_split[0].toString().replace('P', '')

    print('Final Age:::' + age)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/tab_editParticipant_journeyPoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/select_editParticipant_experience'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//span[@class=\'ng-option-label\'][text()=\'' + 
    Retreat) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

if (Spirituality != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'spirituality-dropdown\']//div//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), Spirituality, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (AdditionalComments != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/textarea_editParticipant_comments'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), AdditionalComments, false, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(1)

if (dateofBirthonsession != '') {
    def ageText = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/label_editParticipant_personNameAndAge'))

    println('ageText' + ageText)

    def finalAgeValidation = age.toString() + ' years old'

    def ageFlag

    if (ageText.contains(finalAgeValidation)) {
        ageFlag = 'true'
    } else {
        ageFlag = 'false'
    }
    
    println('ageFlag' + ageFlag)

    WebUI.verifyMatch(ageFlag, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (rsvp == 'yes') {
    if (IsAttending != '') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_yes'), 
            0, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (IsAttending != '') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_no'), 
            0, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (IsAttending != '') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/radio_editParticipant_maybe'), 
            0, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/icon_editParticipant_close'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.comment("changes for card 900 and 901 starts here ")

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/icon_editParticipant_close'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

if (Retreat != '') {
	WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/label_retreatTile_retreatNameOntile',
			[('retreatName') : Retreat]), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	def overviewStartDate=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/Input_overview_startDate'),'value', FailureHandling.CONTINUE_ON_FAILURE)
	def overviewEndDate=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/Input_overview_endDate'),'value', FailureHandling.CONTINUE_ON_FAILURE)
	
	
	def amPm=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend3'), 'textContent', FailureHandling.CONTINUE_ON_FAILURE)
	def actualStartDate = overviewStartDate.toString().replace('-', '/')
	println "actualStartDate"+actualStartDate
	
	def dropDownInput=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),'value', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment("Calculating the Start Date and Time")
	def startHour
	def startMinutes
	startHour=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_startTimehours1'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
	startMinutes=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_startTimeMinutes1'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.comment("converting the P.M time to 24hours Format")
	if (amPm=='PM')
	{
	 def convertedStartHour=startHour.toInteger()+12
	  startHour= convertedStartHour.toString()
	 }
	def startDateAndTime = actualStartDate+ " " +startHour+":"+startMinutes+":00"
	Date startdate = new SimpleDateFormat('MM/dd/yyyy hh:mm:ss').parse(startDateAndTime)
	println "startdate"+startdate
			
	WebUI.comment("Calculating the End Date and Time")
	def endHour
	def endMinutes
	switch (dropDownInput) {
		case '1':
		endHour=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
		endMinutes=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
		break
		case '2':
		 endHour=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours2'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
		 endMinutes=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes2'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
			break
		case '3':
		endHour=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours3'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
		endMinutes=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes3'), 'value', FailureHandling.CONTINUE_ON_FAILURE)
		break
	}
	
	def actualEndDate = overviewEndDate.toString().replace('-', '/')
	println "actualEndDate"+actualEndDate
	WebUI.comment("converting the P.M time to 24hours Format")
	if (amPm=='PM')
	{
	 def convertedEndHour=endHour.toInteger()+12
	  endHour= convertedEndHour.toString()
	  
	 }
	def endDateAndTime = actualEndDate+ " " +endHour+":"+endMinutes+":00"
	Date endDate = new SimpleDateFormat('MM/dd/yyyy hh:mm:ss').parse(endDateAndTime)
	println "endDate"+endDate
	
	Date todayDate = Calendar.getInstance().getTime()
	println('Current Date:::' + todayDate)
	WebUI.comment("navigating to participant Tab and open the participant")

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_retreatParticipantsMenu'), FailureHandling.CONTINUE_ON_FAILURE)	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//tr[@id=\'participantsTableHeaderRow\']//ancestor::tbody//tr[@class=\'retreat-participant-row\']//following::td[text()=\'' + 
    LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject)
	WebUI.comment("navigating to faith jouney")
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/tab_editParticipant_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	WebUI.comment("Validating experience time  for Partcipant")
	if(startdate>todayDate)
	{
		
	def expectedTimeFrame= " Starting  "+actualStartDate
	def actualTimeFrame=WebUI.getAttribute(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','(//div[@id=\'current-faith-journey-table\']//div[text()=\'Current Experience\']//ancestor::div//div//a[text()=\''+Retreat+'\']//parent::div//following-sibling::div)[2]', true, FailureHandling.CONTINUE_ON_FAILURE), 'textContent', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualTimeFrame, expectedTimeFrame, false, FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
	{
		
	}
	if(endDate<todayDate)
	{
		def expectedTimeFrame= " "+actualStartDate+" - "+actualEndDate+" "
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'past-faith-journey-table\']//div[text()=\'Past Experience\']//ancestor::div//div//a[text()=\''+Retreat+'\']//parent::div//following-sibling::div[text()=\''+expectedTimeFrame+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
		}
	else
	{
		def expectedTimeFrame= " "+actualStartDate+"  - "+actualEndDate+" "
		def actualTimeFrame=WebUI.getAttribute(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','(//div[@id=\'current-faith-journey-table\']//div[text()=\'Current Experience\']//ancestor::div//div//a[text()=\''+Retreat+'\']//parent::div//following-sibling::div)[2]', true, FailureHandling.CONTINUE_ON_FAILURE), 'textContent', FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualTimeFrame, expectedTimeFrame, false, FailureHandling.CONTINUE_ON_FAILURE)
	}
	}
	

	
WebUI.comment("changes for card 900 and 901 ends here ")

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/tab_editParticipant_basicInfo'), 
    FailureHandling.CONTINUE_ON_FAILURE)

if(continueValidation.toString().toLowerCase()=='yes')
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/lightbox_retreatParticipant_editParticipant/icon_editParticipant_close'), FailureHandling.CONTINUE_ON_FAILURE)
}