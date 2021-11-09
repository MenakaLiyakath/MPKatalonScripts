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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod

WebUI.callTestCase(findTestCase('DB Action/DB Action-MP DB activity'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('null'), [('loginUrl') : 'https://omega-menlo-qa-frontend.herokuapp.com/login'
        , ('username') : 'shani@menloinnovations.com', ('password') : ''], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/HomePage'), [:], FailureHandling.CONTINUE_ON_FAILURE)

TestData ourSessionDataSet = findTestData('excelSession')

excelSessionsNumber = ourSessionDataSet.getRowNumbers()

for (def index : (0..excelSessionsNumber - 1)) {
    WebUI.callTestCase(findTestCase('Encounter Module/Session Actions/Session Actions-Create New Session/Session Actions - Create New Session'), [('SessName') : ourSessionDataSet.internallyGetValue(
                'SessName', index), ('PrimLoc') : ourSessionDataSet.internallyGetValue('PrimLoc', index), ('Address') : ourSessionDataSet.internallyGetValue(
                'Address', index), ('NumberOfMeetings') : ourSessionDataSet.internallyGetValue('NumberOfMeetings', index)
            , ('startDateYear') : ourSessionDataSet.internallyGetValue('startDateYear', index), ('startDateMonth') : ourSessionDataSet.internallyGetValue(
                'startDateMonth', index), ('startDateDay') : ourSessionDataSet.internallyGetValue('startDateDay', index)
            , ('startingHour') : ourSessionDataSet.internallyGetValue('startingHour', index), ('startingMinutes') : ourSessionDataSet.internallyGetValue(
                'startingMinutes', index), ('startingAMPM') : ourSessionDataSet.internallyGetValue('startingAMPM', index)
            , ('endingHour') : ourSessionDataSet.internallyGetValue('endingHour', index), ('endingMinutes') : ourSessionDataSet.internallyGetValue(
                'endingMinutes', index), ('endingAMPM') : ourSessionDataSet.internallyGetValue('endingAMPM', index), ('endDateYear') : ourSessionDataSet.internallyGetValue(
                'endDateYear', index), ('endDateMonth') : ourSessionDataSet.internallyGetValue('endDateMonth', index), ('endDateDay') : ourSessionDataSet.internallyGetValue(
                'endDateDay', index), ('indicatingNumberOfParticipants') : ourSessionDataSet.internallyGetValue('numberOfParticipants', 
                index).toInteger(), ('indicatingNumberOfVolunteers') : ourSessionDataSet.internallyGetValue('numberOfVolunteers', 
                index).toInteger(), ('indicatingDataSourceParticipants') : ourSessionDataSet.internallyGetValue('indicatingDataSourceParticipants', 
                index), ('indicatingDataFileParticipants') : ourSessionDataSet.internallyGetValue('indicatingDataFileParticipants', 
                index), ('indicatingDataSourceVolunteers') : ourSessionDataSet.internallyGetValue('indicatingDataSourceVolunteers', 
                index), ('indicatingDataFileVolunteers') : ourSessionDataSet.internallyGetValue('indicatingDataFileVolunteers', 
                index)], FailureHandling.STOP_ON_FAILURE)
}

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_sessionsDropdown'), 'Christ The King Session 1', false)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openSessionButton'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow(FailureHandling.CONTINUE_ON_FAILURE)

TestData ourVolunteerDataSet = findTestData('sessionVolunteers')

for (def index : (0..ourVolunteerDataSet.getRowNumbers() - 1)) {
    WebUI.setText(findTestObject('null'), ourVolunteerDataSet.internallyGetValue('newVolunteerLastName', 
            index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), ourVolunteerDataSet.internallyGetValue('newVolunteerFirstName', 
            index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), '734-555-12346', FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), ourVolunteerDataSet.internallyGetValue('newVolunteerEmail', 
            index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), 'Learning, Cooking, Cleaning', FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), '2018', FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), 'cooking', FailureHandling.CONTINUE_ON_FAILURE)

    not_run: WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

    not_run: WebUI.click(findTestObject('null'))

    not_run: WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

    not_run: WebUI.click(findTestObject('null'))

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/button_sessionVolunteer_saveAndClose'))
}

currentVolunteerPoolTitle = WebUI.getText(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

currentVolunteerCount = currentVolunteerPoolTitle.substring(16, currentVolunteerPoolTitle.length() - 1)

println(currentVolunteerCount)

actualOverflowY = WebUI.getCSSValue(findTestObject('null'), 'overflow-y', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

'checking scroll on Session-Volunteers page here'
WebUI.scrollToElement(findTestObject('null'), 5, FailureHandling.CONTINUE_ON_FAILURE)

LocalDateTime t = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyy-MM-dd_hhmma')

GlobalVariable.globalizedCurrDate = t.format(formatter)

path = screenshotFolderPath.concat('/volunteer/katalonVolunteerScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Volunteers-Page/sidebar/sessionParticipantsLink'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

not_run: TestData ourParticipantDataSet = findTestData('sessionParticipantsCtKS1')

not_run: for (def index : (0..ourParticipantDataSet.getRowNumbers() - 1)) {
    WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
            'newParticipantRowLastNameCell', index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
            'newParticipantRowFirstNameCell', index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
            'newParticipantRowPhoneNumberCell', index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('null'), ourParticipantDataSet.internallyGetValue(
            'newParticipantRowEmailCell', index), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)
}

'checking scroll on Session-Participants here'
WebUI.scrollToElement(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionsParticipants_Other'), 5, FailureHandling.CONTINUE_ON_FAILURE)

'checking scroll on Session-Participants here'
WebUI.scrollToElement(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/ARCHIVE-enteredParticipants/twentiethparticipantLastName'), 5, FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowY = WebUI.getCSSValue(findTestObject('null'), 'overflow-y', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowX = WebUI.getCSSValue(findTestObject('null'), 'overflow-x', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowX, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/participants/katalonParticipantsScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Session/Sessions-Participants-Page/sidebar/sessionGroupsLink'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/input_sessionGroups_numberOfGroups'), '20', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_create'), FailureHandling.CONTINUE_ON_FAILURE)

'checking scroll on Groups page group panel here'
WebUI.scrollToElement(findTestObject('null'), 5, FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowY = WebUI.getCSSValue(findTestObject('null'), 'overflow-y', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/groups-grouping/katalon20GroupsScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/label_sessionGroups_participantTable'), FailureHandling.CONTINUE_ON_FAILURE)

'checking scroll on Groups page participants panel here'
WebUI.scrollToElement(findTestObject('null'), 0, FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowY = WebUI.getCSSValue(findTestObject('null'), 'overflow-y', 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/groups-participants/katalonGroupParticipantsScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/sidebar/addOrViewSessionOrRetreatLink'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/RetreatPlanningNotesEntry'), [('actualPlanningNotesText') : '', ('planningNotesToEnter') : 'What does it mean to be a custom software shop? For starters, it means we never assume one size fits all. We approach each project with an open mind, letting its needs dictate what technology and language we’ll use. If you need a new mobile or web app, an update to a legacy system, or software to drive your hardware, that’s what we’ll do. We’ve been developing custom software since 2001, and there’s not a lot we haven’t done. What does it mean to be a custom software shop? For starters, it means we never assume one size fits all. We approach each project with an open mind, letting its needs dictate what technology and language we’ll use. If you need a new mobile or web app, an update to a legacy system, or software to drive your hardware, that’s what we’ll do. We’ve been developing custom software since 2001, and there’s not a lot we haven’t done. What does it mean to be a custom software shop? For starters, it means we never assume one size fits all. We approach each project with an open mind, letting its needs dictate what technology and language we’ll use. If you need a new mobile or web app, an update to a legacy system, or software to drive your hardware, that’s what we’ll do. We’ve been developing custom software since 2001, and there’s not a lot we haven’t done. What does it mean to be a custom software shop? For starters, it means we never assume one size fits all. We approach each project with an open mind, letting its needs dictate what technology and language we’ll use. If you need a new mobile or web app, an update to a legacy system, or software to drive your hardware, that’s what we’ll do. We’ve been developing custom software since 2001, and there’s not a lot we haven’t done. What does it mean to be a custom software shop? For starters, it means we never assume one size fits all. We approach each project with an open mind, letting its needs dictate what technology and language we’ll use. '
        , ('inputIsOvernight') : 'false'], FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowY = WebUI.getCSSValue(findTestObject('null'), 'overflow-y', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'auto', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'), 0, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/retreat-overview/katalonRetreatSetupScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

actualOverflowY = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'), 'overflow-y', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualOverflowY, 'auto', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToPosition(0, 100, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/retreat-overview/katalonPlanningNotesScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

'*'
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_associateSessions1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementNotPresent(findTestObject('null'), 1)

WebUI.verifyElementNotPresent(findTestObject('null'), 1)

'THIS IS HARD-CODED for now. Based on how many sessions created overlap retreat dates.'
countOfOverlappingSessions = 9

'for now, we\'ve hard-coded that there should be nine overlapping sessions to associate with this retreat. Could make count formulaic in future.'
if (countOfOverlappingSessions == 9) {
    WebUI.verifyElementPresent(findTestObject('null'), 0, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('null'), 1, FailureHandling.CONTINUE_ON_FAILURE)

    actualOverflowY = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_overview_associateSessions/container_overview_associateSessionView'), 'overflow-y', 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyMatch(actualOverflowY, 'scroll', false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.scrollToElement(findTestObject('null'), 0, FailureHandling.CONTINUE_ON_FAILURE)
}

System.out.print('GlobalVariable.globalizedCurrDate: \n' + GlobalVariable.globalizedCurrDate)

System.out.println()

path = screenshotFolderPath.concat('/retreat-overview/katalonRetreatAssocSessionsScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_overview_associateSessions/button_overview_associateSession'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'))

WebUI.delay(1)

WebUI.click(findTestObject('null'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Participants/enteredParticipants/table_retreatParticipants_participantsTableTR20'), 0, FailureHandling.CONTINUE_ON_FAILURE)

path = screenshotFolderPath.concat('/retreat-participants/katalonRetreatParticipantsScrolled')

path = path.concat(GlobalVariable.globalizedCurrDate)

path = path.concat('.png')

WebUI.takeScreenshot(path, FailureHandling.CONTINUE_ON_FAILURE)

//TestObject to = findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Participants/enteredParticipants/VARIABLElastName')
//Change value of CSS selector
//to.findProperty('xpath').setValue('//td[text()=\'Participantlast-R\'] or . = \'Participantlast-R\'')
'to figure out later...'
not_run: new_btn = WebUI.modifyObjectProperty(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Participants/enteredParticipants/VARIABLElastName'), 
    'xpath', 'equals', '//*[1]', true, FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.getText(findTestObject('new_btn'), FailureHandling.CONTINUE_ON_FAILURE)

not_run: WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Encounter(Session or Retreat)/Retreat/Retreat Participants/enteredParticipants/VARIABLElastName'), FailureHandling.CONTINUE_ON_FAILURE)

dynamicObjectTOO = new TestObject('dynamicObject2')

dynamicObject.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//*[1]', true)

dynamicObjectTOO.addProperty('xpath', com.kms.katalon.core.testobject.ConditionType.EQUALS, '//*[1]', true)

WebUI.waitForElementVisible(dynamicObject, 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(dynamicObjectTOO, 3, FailureHandling.CONTINUE_ON_FAILURE)

actualParticipantsTBODYtext = WebUI.getText(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

System.out.print('Actual: \n' + actualParticipantsTBODYtext)

System.out.println()

assert actualParticipantsTBODYtext.contains('Participantlast-A Participantfirst1 (734) 777-8888 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-B Participantfirst2 (734) 777-8889 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-C Participantfirst3 (734) 777-8890 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-D Participantfirst4 (734) 777-8891 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-E Participantfirst5 (734) 777-8892 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-F Participantfirst6 (734) 777-8893 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-G Participantfirst7 (734) 777-8894 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-H Participantfirst8 (734) 777-8895 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-I Participantfirst9 (734) 777-8896 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-J Participantfirst10 (734) 777-8897 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-K Participantfirst11 (734) 777-8898 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-L Participantfirst12 (734) 777-8899 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-M Participantfirst13 (734) 777-8900 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-N Participantfirst14 (734) 777-8901 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-O Participantfirst15 (734) 777-8902 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-P Participantfirst16 (734) 777-8903 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-Q Participantfirst17 (734) 777-8904 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-R Participantfirst18 (734) 777-8905 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-S Participantfirst19 (734) 777-8906 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-T Participantfirst20 (734) 777-8907 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Participantlast-U Participantfirst21 (734) 777-8908 p1@menloinnovations.com Christ The King Session 1 thanks veggie No')

assert actualParticipantsTBODYtext.contains('Doe1 Jane1 (734) 661-9731 janedoe@menloinnovations.com1 Christ The King Session 2 Looking forward to it!1 No bread No')

assert actualParticipantsTBODYtext.contains('Doe2 Jane2 (734) 661-9732 janedoe@menloinnovations.com2 Christ The King Session 2 Looking forward to it!2 No bread No')

