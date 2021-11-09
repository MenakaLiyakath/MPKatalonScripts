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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
//import java.time.Period;
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.time.Month as Month
import java.time.Period as Period

WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

def participantnameobj = new TestObject('participantnameobj')

participantnameobj.addProperty('xpath', ConditionType.EQUALS, ((('//td[text()=\'' + FirstName) + '\']/preceding-sibling::td[text()=\'') + 
    LastName) + '\']', true)

//participantLnameobj = new TestObject('participantLnameobj')
//
//participantLnameobj.addProperty('xpath', ConditionType.EQUALS, '//tr[@id=\'personsTableHeaderRow\']/following-sibling::tr//td[text()=\''+LastName+'\']', true)
if (WebUI.verifyElementPresent(participantnameobj, 2, FailureHandling.OPTIONAL)) {
    WebUI.click(participantnameobj, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    if (DateOfBirthYear != '') {
        WebUI.clearText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_dateOfBirth'), FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/button_volunteerSignup_dateOfBirth'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/dropDown_volunteerSignup_year'), DateOfBirthYear, 
            false, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/dropDown__volunteerSignup_month'), DateOfBirthMonth, 
            false, FailureHandling.CONTINUE_ON_FAILURE)

        daySelection = new TestObject('daySelection')

        daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + 
            DateOfBirthDay) + '\']', true)

        WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.refresh(FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

    if (WebUI.verifyElementPresent(participantnameobj, 2, FailureHandling.OPTIONAL)) {
        WebUI.click(participantnameobj, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

        def dateofBirthonsession = WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_dateOfBirth'), 
            'value', FailureHandling.CONTINUE_ON_FAILURE)

        println('dateofBirthonsession++++++' + dateofBirthonsession)

        def dateofBirthonsessionwithtime = dateofBirthonsession + ' 00:00:00'

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
        
        LocalDate birthday = LocalDate.of(DateOfBirthYear_int, dobMonth, DateOfBirthDay_int //Birth date
            )

        //LocalDate birthday = LocalDate.of(2000, Month.JANUARY, 11);  //Birth date
        Period p = Period.between(birthday, today)

        println('Age**********' + p)

        def completeage = p.toString()

        String[] completeage_split

        completeage_split = completeage.split('Y')

        def age = completeage_split[0].toString().replace('P', '')

        print('Final Age:::' + age)

        WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/tab_addPeople_sessionsInfo'), FailureHandling.CONTINUE_ON_FAILURE)

        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/label_addPeople_personNameAndAge')).contains((', ' + 
            age) + ' years old'))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/label_addPeople_personNameAndAge')), 
                'should match ' + age, false, FailureHandling.CONTINUE_ON_FAILURE)

            println('Age of the Participant is not displayed ')
        } else {
            println('Age of the Participant is displayed properly')
        }
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/label_addPeople_referenceSource')).contains(SessType))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/label_addPeople_referenceSource')), 
                'should match ' + SessType, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(('How did you hear about' + SessType) + '? is not displayed')
        } else {
            println(('How did you hear about' + SessType) + '? is displayed')
        }
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_referenceSource')).equalsIgnoreCase(
            RefSource))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_referenceSource')), 
                'should match ' + RefSource, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(RefSource + 'is not displayed for How did you hear')
        } else {
            println(RefSource + 'is displayed for How did you hear')
        }
        
        if (!(WebUI.verifyElementChecked(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_isParticipant'), 2, FailureHandling.OPTIONAL))) {
            WebUI.verifyMatch('Participant check box not checked', 'should be', false, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            println('Participant check box is checked')
        }
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_seatWith')).equalsIgnoreCase(SeatingConnection))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_seatWith')), 'should match ' + 
                SeatingConnection, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(('Seat with' + SeatingConnection) + ' Participant does not match')
        } else {
            println(('Seat with' + SeatingConnection) + ' Participant matches')
        }
        
         
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_assignedGroup')).equalsIgnoreCase(
            GroupName))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_assignedGroup')), 
                'should match ' + GroupName, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(GroupName + 'does not Match GroupName on Session Info Tab')
        } else {
            println(GroupName + 'Matches GroupName on Session Info Tab')
        }
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_childCareRequest')).equalsIgnoreCase(
            Childcare))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_childCareRequest')), 
                'should match ' + Childcare, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(Childcare + 'does not Match childcare on Session Info Tab')
        } else {
            println(Childcare + 'Matches childcare on Session Info Tab')
        }
        
        if (!(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_comments')).equalsIgnoreCase(AdditionalComments))) {
            WebUI.verifyMatch(WebUI.getText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_comments')), 'should match ' + 
                AdditionalComments, false, FailureHandling.CONTINUE_ON_FAILURE)

            println(AdditionalComments + 'does not Match Comments on Session Info Tab')
        } else {
            println(AdditionalComments + 'Matches Comments  on Session Info Tab')
        }
    }
}

