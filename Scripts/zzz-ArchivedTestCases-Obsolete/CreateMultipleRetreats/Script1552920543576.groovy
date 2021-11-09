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

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('DB Action/DB Action-MP DB activity'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/HomePage'), [:], FailureHandling.STOP_ON_FAILURE)

TestData ourDataSet = findTestData('excelRetreats')

for (def index : (0..ourDataSet.getRowNumbers() - 1)) {
    WebUI.callTestCase(findTestCase('Encounter Module/Retreat Actions/Retreat Actions- Create New Retreat/Create New Retreat'), [('retreatName') : ourDataSet.internallyGetValue(
                'retreatName', index), ('retreatPrimaryLoc') : ourDataSet.internallyGetValue('retreatPrimaryLoc', index)
            , ('retreatAddress') : ourDataSet.internallyGetValue('retreatAddress', index), ('numberOfDaysString') : ourDataSet.internallyGetValue(
                'numberOfDays', index), ('year') : ourDataSet.internallyGetValue('year', index), ('month') : ourDataSet.internallyGetValue(
                'month', index), ('day') : ourDataSet.internallyGetValue('day', index), ('dayOneStartHour') : ourDataSet.internallyGetValue(
                'dayOneStartHour', index), ('dayOneStartMinutes') : ourDataSet.internallyGetValue('dayOneStartMinutes', 
                index), ('dayOneStartAMPM') : ourDataSet.internallyGetValue('dayOneStartAMPM', index), ('dayTwoStartHour') : ourDataSet.internallyGetValue(
                'dayTwoStartHour', index), ('dayTwoStartMinutes') : ourDataSet.internallyGetValue('dayTwoStartMinutes', 
                index), ('dayTwoStartAMPM') : ourDataSet.internallyGetValue('dayTwoStartAMPM', index), ('dayThreeStartHour') : ourDataSet.internallyGetValue(
                'dayThreeStartHour', index), ('dayThreeStartMinutes') : ourDataSet.internallyGetValue('dayThreeStartMinutes', 
                index), ('dayThreeStartAMPM') : ourDataSet.internallyGetValue('dayThreeStartAMPM', index), ('dayOneEndHour') : ourDataSet.internallyGetValue(
                'dayOneEndHour', index), ('dayOneEndMinutes') : ourDataSet.internallyGetValue('dayOneEndMinutes', index)
            , ('dayOneEndAMPM') : ourDataSet.internallyGetValue('dayOneEndAMPM', index), ('dayTwoEndHour') : ourDataSet.internallyGetValue(
                'dayTwoEndHour', index), ('dayTwoEndMinutes') : ourDataSet.internallyGetValue('dayTwoEndMinutes', index)
            , ('dayTwoEndAMPM') : ourDataSet.internallyGetValue('dayTwoEndAMPM', index), ('dayThreeEndHour') : ourDataSet.internallyGetValue(
                'dayThreeEndHour', index), ('dayThreeEndMinutes') : ourDataSet.internallyGetValue('dayThreeEndMinutes', 
                index), ('dayThreeEndAMPM') : ourDataSet.internallyGetValue('dayThreeEndAMPM', index), ('isOvernight') : ourDataSet.internallyGetValue(
                'isOvernight', index)], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Encounter Module/Retreat Actions/Retreat Actions- Create New Retreat/Create New Retreat'), [('retreatOverviewLinkbgcolor') : '', ('retreatOverviewSavebg') : ''
        , ('retreatName') : 'AlphaRetreat3', ('retreatPrimaryLoc') : 'The Church3', ('retreatAddress') : '123 Fourth Ave, A2'
        , ('retreatNameHeader') : '', ('numberOfDays') : 0, ('year') : '2019', ('month') : 'Jan', ('day') : '6', ('dayOneStartHour') : '07'
        , ('dayOneStartMinutes') : '40', ('dayOneStartAMPM') : 'PM', ('dayTwoStartHour') : '09', ('dayTwoStartMinutes') : '01'
        , ('dayTwoStartAMPM') : 'AM', ('dayThreeStartHour') : '05', ('dayThreeStartMinutes') : '00', ('dayThreeStartAMPM') : 'PM'
        , ('dayOneEndHour') : '08', ('dayOneEndMinutes') : '59', ('dayOneEndAMPM') : 'PM', ('dayTwoEndHour') : '12', ('dayTwoEndMinutes') : '01'
        , ('dayTwoEndAMPM') : 'PM', ('dayThreeEndHour') : '06', ('dayThreeEndMinutes') : '00', ('dayThreeEndAMPM') : 'PM'
        , ('checkValue') : '', ('isOvernight') : 'true', ('numberOfDaysString') : '2', ('checkAMPM') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat3', false, 0)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat3', false)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'))

WebUI.delay(2)

retreatSavedName = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(retreatSavedName, 'AlphaRetreat3', false, FailureHandling.CONTINUE_ON_FAILURE)

retreatSavedPrimaryLoc = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_primaryLocation'), 'value')

WebUI.verifyMatch(retreatSavedPrimaryLoc, 'The Church3', false)

retreatSavedAddress = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_address'), 'value')

WebUI.verifyMatch(retreatSavedAddress, '123 Fourth Ave, A2', false)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_address'), '120 Fourth Ave., Ann Arbor, MI 48104', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.deleteAllCookies()

WebUI.closeBrowser()

WebUI.callTestCase(findTestCase('null'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('zzz-ArchivedTestCases-Obsolete/HomePage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/dropDown_manage_retreatDropdown'), 'AlphaRetreat3', false)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_openRetreatButton'))

WebUI.delay(2)

retreatSavedAddress = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_address'), 'value')

WebUI.verifyMatch(retreatSavedAddress, '120 Fourth Ave., Ann Arbor, MI 48104', false)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow()

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(500, 300, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(1000, 600, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow()

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(500, 300, FailureHandling.CONTINUE_ON_FAILURE)

checkValue = WebUI.getElementWidth(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyGreaterThanOrEqual(checkValue, 34, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setViewPortSize(1200, 800)

