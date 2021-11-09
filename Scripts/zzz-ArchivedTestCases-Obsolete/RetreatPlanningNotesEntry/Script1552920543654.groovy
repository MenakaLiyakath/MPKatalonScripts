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

WebUI.callTestCase(findTestCase('Encounter Module/Retreat Actions/Retreat Actions- Create New Retreat/Create New Retreat'), [('retreatOverviewLinkbgcolor') : '', ('retreatOverviewSavebg') : ''
        , ('retreatName') : 'AlphaRetreat1', ('retreatPrimaryLoc') : 'The Church', ('retreatAddress') : '123 Fourth Ave., Ann Arbor, MI 48104'
        , ('retreatNameHeader') : '', ('numberOfDays') : 0, ('year') : startDateYear, ('month') : startDateMonth, ('day') : startDateDay
        , ('dayOneStartHour') : '07', ('dayOneStartMinutes') : '40', ('dayOneStartAMPM') : 'PM', ('dayTwoStartHour') : '09'
        , ('dayTwoStartMinutes') : '01', ('dayTwoStartAMPM') : 'AM', ('dayThreeStartHour') : '05', ('dayThreeStartMinutes') : '00'
        , ('dayThreeStartAMPM') : 'PM', ('dayOneEndHour') : '08', ('dayOneEndMinutes') : '59', ('dayOneEndAMPM') : 'PM', ('dayTwoEndHour') : '12'
        , ('dayTwoEndMinutes') : '01', ('dayTwoEndAMPM') : 'PM', ('dayThreeEndHour') : '06', ('dayThreeEndMinutes') : '00'
        , ('dayThreeEndAMPM') : 'PM', ('checkValue') : '', ('isOvernight') : inputIsOvernight, ('numberOfDaysString') : numDays
        , ('actualDayOneStartAMPM') : '', ('actualDayOneEndAMPM') : '', ('actualDayTwoStartAMPM') : '', ('actualDayTwoEndAMPM') : ''
        , ('actualDayThreeStartAMPM') : '', ('actualDayThreeEndAMPM') : '', ('actualDayOneStartHour') : '', ('actualDayOneStartMinutes') : ''
        , ('actualDayTwoStartHour') : '', ('actualDayTwoStartMinutes') : '', ('actualDayThreeStartHour') : '', ('actualDayThreeStartMinutes') : ''], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat1', false)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_retreatPlanningNotes'), 'Planning Notes')

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'), planningNotesToEnter)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'))

WebUI.click(findTestObject('null'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat1', false)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'))

actualPlanningNotesText = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'), 'value')

WebUI.verifyMatch(actualPlanningNotesText, planningNotesToEnter, false)

