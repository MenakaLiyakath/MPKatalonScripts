import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.time.LocalDate as LocalDate
import java.time.Month as Month

//test
LocalDate currentdate = LocalDate.now()

print(currentdate)

int currentDay = currentdate.getDayOfMonth()

print(currentDay)

Month currentMonth = currentdate.getMonth()

print(currentMonth)

int currentYear = currentdate.getYear()

print(currentYear)

def strMonth

switch (currentMonth.toString().toLowerCase()) {
    case '1':
    case 'january':
    case 'jan':
        strMonth = 'JAN'

        break
    case '2':
    case 'february':
    case 'feb':
        strMonth = 'FEB'

        break
    case '3':
    case 'march':
    case 'mar':
        strMonth = 'MAR'

        break
    case '4':
    case 'april':
    case 'apr':
        strMonth = 'APR'

        break
    case '5':
    case 'may':
    case 'may':
        strMonth = 'MAY'

        break
    case '6':
    case 'june':
    case 'jun':
        strMonth = 'JUN'

        break
    case '7':
    case 'july':
    case 'jul':
        strMonth = 'JUL'

        break
    case 'august':
    case 'aug':
    case '8':
        strMonth = 'AUG'

        break
    case '9':
    case 'september':
    case 'sep':
        strMonth = 'SEP'

        break
    case '10':
    case 'october':
    case 'oct':
        strMonth = 'OCT'

        break
    case '11':
    case 'november':
    case 'nov':
        strMonth = 'NOV'

        break
    case '12':
    case 'december':
    case 'dec':
        strMonth = 'DEC'

        break
}

calendarCurrentMonYear = ((((' ' + strMonth) + ' ') + currentYear) + ' ')

print('calendarCurrentMonYear' + calendarCurrentMonYear)

WebUI.click(findTestObject('CommonPageObjects/lightbox_calendar/drop_calendar_monthYear', [('calendarSelect') : 'calendarCurrentMonYear']), 
    FailureHandling.CONTINUE_ON_FAILURE)

if (year() < '2016') {
    WebUI.click(findTestObject('Object Repository/CommonPageObjects/lightbox_calendar/label_calendar_previousYearNavigation'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (year() > '2039') {
    WebUI.click(findTestObject('Object Repository/CommonPageObjects/lightbox_calendar/label_calendar_nextYearNavigation'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

def strYear = (' ' + year.tostring()) + ' '

def strMonth = (' ' + month.tostring()) + ' '

def strDay = (' ' + day.tostring()) + ' '

WebUI.click(findTestObject('CommonPageObjects/lightbox_calendar/label_calendar_year', [('calendarYear') : 'strYear']))

WebUI.click(findTestObject('CommonPageObjects/lightbox_calendar/label_calendar_month', [('calendarMonth') : 'strMonth']), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/lightbox_calendar/label_calendar_day', [('calendarDay') : 'strDay']), FailureHandling.CONTINUE_ON_FAILURE)

