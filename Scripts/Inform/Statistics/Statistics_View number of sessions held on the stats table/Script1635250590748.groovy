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
import java.util.Date as Date
import java.util.Calendar as Calendar

def totSess_ManageSession = WebUI.getNumberOfTotalOption(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'))

def session = 0

for (i = 1; i < totSess_ManageSession; i++) {
    WebUI.selectOptionByIndex(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 
        i)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

    String sessionEndDate = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'), 
        'value')

    String sessionEndHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeHours'), 
        'value')

    String sessionEndMin = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeMinutes'), 
        'value')

    String enddateandtime = (((((sessionEndDate + ' ') + sessionEndHour) + ':') + sessionEndMin) + ':') + '00'

    println('sessionEndDate::' + sessionEndDate)

    Date date1 = new SimpleDateFormat('yyyy-MM-dd hh:mm:ss').parse(enddateandtime)

    println('Converted Session End Date' + date1)

    Date date = Calendar.getInstance().getTime()

    println('Current Date:::' + date)

    println('date::' + date)

    if (date1 < date) {
        session = (session + 1)
    }
    
    WebUI.click(findTestObject('module_inform/link_inform_addOrViewSessionOrRetreat'))
}

println('session::::' + session)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_stats'))

def totsessiononstatus = WebUI.getText(findTestObject('module_inform/label_inform_numberOfCompletedSessions'))

int totsession_int = Integer.parseInt(totsessiononstatus)

println('Total number of sessions on Stats (integer) is :::::' + totsession_int)

if (session == totsession_int) {
    println('Total Session Matches')
} else {
    println('Total Session does not Match')
}

