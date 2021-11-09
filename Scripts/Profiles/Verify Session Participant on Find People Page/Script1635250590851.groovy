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


WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))
	
	CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', "Is equal to")
	
	
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//table[@id=\'personsTable\']//div[@class=\'table-container\']//table//tr//td//span[text()=\''+LastName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)
/*
WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), 'Some Last Name', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/icon_addPeople_close'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//table[@id=\'personsTable\']//div[@class=\'table-container\']//table//tr//td//span[text()=\''+LastName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)*/

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), 'value'), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_firstName'), 'value'), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), 'value'), Email, false, FailureHandling.CONTINUE_ON_FAILURE)

if (!(PhoneNumber.substring(0, 1) == '(')) {
    PhoneNumber = ((((('(' + PhoneNumber.substring(0, 3)) + ') ') + PhoneNumber.substring(3, 6)) + '-') + PhoneNumber.substring(
        6))
}

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_phoneNumber'), 'value'), PhoneNumber, false, FailureHandling.CONTINUE_ON_FAILURE)

if (Church != '') {
    WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/label_editProfile_parish')), 
        Church, false, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Church == '') {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', '//ng-select[@id=\'parish\']//div[contains(@class,\'ng-select-container\')]', 
        true)

    ifHasValue = WebUI.getAttribute(dynamicObject, 'class')

    if (ifHasValue.indexOf('ng-has-value') > -1) {
        WebUI.verifyMatch(ifHasValue, 'parish is populated but shouldnt be', false)
    }
}

def dateofBirthonsession = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionParticipants_editProfile/input_editProfile_dateOfBirth'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

println('dateofBirthonsession++++++' + dateofBirthonsession)

def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'

/*	
	if (dateofBirthonsession == '')
	{
		WebUI.verifyMatch(DateOfBirthMonth, '', false)
		WebUI.verifyMatch(DateOfBirthDay, '', false)
		WebUI.verifyMatch(DateOfBirthYear, '', false)
	}*/
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

    //LocalDate birthday = LocalDate.of(2000, Month.JANUARY, 11);  //Birth date
    Period p = Period.between(birthday, today)

    println('Age**********' + p)

    def completeage = p.toString()

    String[] completeage_split

    completeage_split = completeage.split('Y')

    def age = completeage_split[0].toString().replace('P', '')

    print('Final Age:::' + age)
}


