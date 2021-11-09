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

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/button_manage_createSessionButton'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_sessionTypes'))

typeSelection = new TestObject('type-selection')

typeSelection.addProperty('xpath', ConditionType.EQUALS, '//span[text()=\'Alpha\']', true)

WebUI.click(typeSelection)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_sessionName'), SessName)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_primaryLocation'), PrimLoc)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_address'), Address)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_numberOfMeetings'), NumberOfMeetings)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_startDate'))

WebUI.delay(1)

'checking that calendar popout starts week on Sunday column'
WebUI.selectOptionByValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_year'), '2019', true)

WebUI.selectOptionByValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_month'), '1', true)

WebUI.verifyElementText(findTestObject('null'), 'Su', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('null'), '6', 
    FailureHandling.CONTINUE_ON_FAILURE)

'actually setting start date now'
WebUI.selectOptionByValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_year'), startDateYear, 
    true)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_month'), startDateMonth, 
    true)

calendarDateVariable = ('Sessions/Session-Overview-Page/calendarDates/calendar-date-' + startDateDay)

WebUI.click(findTestObject(calendarDateVariable), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimehours'), startingHour)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimeminutes'), startingMinutes)

actualStartDateAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_startAMPM'))

if (startingAMPM != actualStartDateAMPM) {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_startAMPM'))
}

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_endDate'))

WebUI.delay(1)

'setting end date info'
WebUI.selectOptionByValue(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_year'), endDateYear, 
    true)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/select-sessionOverview_month'), endDateMonth, 
    true)

calendarDateVariable = ('Sessions/Session-Overview-Page/calendarDates/calendar-date-' + endDateDay)

WebUI.click(findTestObject(calendarDateVariable), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeHours'), endingHour)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'), 'disabled', 0)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTimeMinutes'), endingMinutes)

actualEndDateAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button__sessionOverview_endAMPM'))

if (endingAMPM != actualEndDateAMPM) {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button__sessionOverview_endAMPM'))
}

'clicking away from edit field to make Save button active'
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_endTime'))

WebUI.delay(1)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/alert_sessionOverview_savedSuccessfully'), 0)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeader'), 'Session Leader(s)')

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_sessionLeaderHelperText'), 'Assigned in Volunteers')

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimehours'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow()

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimehours'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(500, 300, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimehours'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(1000, 600, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimeminutes'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow()

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimeminutes'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(500, 300, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_starttimeminutes'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(1500, 900, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session - Participants/Session Participants-Quick add Session Participants'), [('indicateDataSource') : indicatingDataSourceParticipants
        , ('indicateDataFile') : indicatingDataFileParticipants, ('participantLastName') : 'Doe', ('participantFirstName') : 'Jane'
        , ('participantPhoneNumber') : '734661973', ('participantEmail') : 'janedoe@menloinnovations.com', ('participantSeatingConnection') : 'Sit me with John Doe'
        , ('participantChildcare') : '2 children - seven and five', ('participantOtherComments') : 'Looking forward to it!'
        , ('participantDietaryRestrictionsCell') : 'No bread', ('participantRefSource') : 'Church announcement', ('participantAge') : '27'
        , ('participantChurch') : 'St. Mary\'s Cathedral', ('participantCheckbox') : 'unchecked', ('indicateCustomParticipantNumber') : indicatingNumberOfParticipants], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/sidebar/addOrViewSessionOrRetreatLink'))

WebUI.delay(1)

