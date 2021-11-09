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
import com.kms.katalon.core.webui.keyword.builtin.ModifyObjectPropertyKeyword
import internal.GlobalVariable as GlobalVariable
import java.lang.String
/*import java.io.**/
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.text.DateFormat
import java.math.RoundingMode
import java.text.DecimalFormat

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//table[@class=\'volunteers-table\']//tr[@class=\'retreat-volunteer-row\']//td[text()=\'' + 
    FirstName) + '\']/preceding-sibling::td[text()=\'') + LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject)

WebUI.delay(2)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_last-name'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_firstName'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

if (PhoneNumber != '') {
    if (!(PhoneNumber.substring(0, 1) == '(')) {
        PhoneNumber = ((((('(' + PhoneNumber.substring(0, 3)) + ') ') + PhoneNumber.substring(3, 6)) + '-') + PhoneNumber.substring(
            6))
    }
    
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_phoneNumber'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Email != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_emailAddress'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), Email, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (DietaryRestrictions != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_dietaryRestrictions'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), DietaryRestrictions, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Skills != '') {
    WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_skills'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE), Skills, false, FailureHandling.CONTINUE_ON_FAILURE)
}

//Card#584 changes
if (PreferredContactMethodEmail != '') {
    if (PreferredContactMethodEmail == 'Yes') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_EmailCheckbox'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_EmailCheckbox'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodText != '') {
    if (PreferredContactMethodText == 'Yes') {
        WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_TextCheckbox'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_TextCheckbox'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodPhoneCall != '') {
    if (PreferredContactMethodPhoneCall == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_phoneCallCheckbox'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementNotChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_phoneCallCheckbox'), 
            2, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (Church != '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'parish\']//div[@class=\'ng-value\']//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), Church, false, FailureHandling.CONTINUE_ON_FAILURE)
}

//Card#584 changes ends here
if (inputSource != 'Form') {
    if (Gender != '') {
        if (Gender == 'Male') {
            WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderOne'), 
                    'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        if (Gender == 'Female') {
            WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderTwo'), 
                    'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
        }
        
        if (Gender == 'Decline to Answer') {
            WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderThree'), 
                    'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}

WebUI.delay(2)


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/tab_editVolunteer_journePoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)
def currentExperience=WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_experienceDropDown'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/dropDown_editVolunteer_experience'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//span[@class=\'ng-option-label\'][text()=\'' + 
    Retreat) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject)

WebUI.delay(1)

WebUI.delay(1)

WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/label_editVolunteer_volunteerRoleInRetreat'), 
        FailureHandling.CONTINUE_ON_FAILURE), 'Volunteer', false, FailureHandling.CONTINUE_ON_FAILURE)


    if (PrimaryRole != '') {
        WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/label_editVolunteer_volunteerPrimaryRole'), 
                FailureHandling.CONTINUE_ON_FAILURE), PrimaryRole, false, FailureHandling.CONTINUE_ON_FAILURE)
    }



    if (SecondaryRole != '') {
        WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/label_editVolunteer_volunteerSecondaryRole')), 
            SecondaryRole, false, FailureHandling.CONTINUE_ON_FAILURE)
    }

WebUI.comment("changes for card 900 and 901 starts here ") 

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/icon_editVolunteer_closeIcon'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

if (Retreat != '') {
	WebUI.doubleClick(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/label_retreatTile_retreatNameOntile',
			[('retreatName') : Retreat]), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	def overviewStartDate=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/Input_overview_startDate'),'value', FailureHandling.CONTINUE_ON_FAILURE)
	def overviewEndDate=WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/Input_overview_endDate'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
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
	WebUI.comment("navigating to volunteer Tab and open the volunteer")
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_retreatVolunteersMenu'), FailureHandling.CONTINUE_ON_FAILURE)		
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//table[@class=\'volunteers-table\']//tr[@class=\'retreat-volunteer-row\']//td[text()=\'' +
		FirstName) + '\']/preceding-sibling::td[text()=\'') + LastName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(dynamicObject)
	WebUI.comment("navigating to faith jouney")
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/tab_editVolunteer_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	WebUI.comment("Validating experience time  for volunteer")
	if(startdate>todayDate)
	{
		
    def expectedTimeFrame= " Starting  "+actualStartDate
	def actualTimeFrame=WebUI.getAttribute(WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals','(//div[@id=\'current-faith-journey-table\']//div[text()=\'Current Experience\']//ancestor::div//div//a[text()=\''+Retreat+'\']//parent::div//following-sibling::div)[2]', true, FailureHandling.CONTINUE_ON_FAILURE), 'textContent', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualTimeFrame, expectedTimeFrame, false, FailureHandling.CONTINUE_ON_FAILURE)
	}
	else
	{
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
	
}
	
WebUI.comment("changes for card 900 and 901 ends here ")

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/tab_editVolunteer_basicInfo'), 
    FailureHandling.CONTINUE_ON_FAILURE)

if(continueValidation.toString().toLowerCase()=='yes')
{
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/icon_editVolunteer_closeIcon'), FailureHandling.CONTINUE_ON_FAILURE)
	
}