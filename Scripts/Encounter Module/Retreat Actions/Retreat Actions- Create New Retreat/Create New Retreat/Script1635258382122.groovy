import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.stringtemplate.v4.compiler.STParser.ifstat_return

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

/* Just to verify merging concepts*/
/*This script is to create a new retreat*/


numberOfDays = numberOfDaysString.toInteger()
//Navigate to Retreat tab and create a new retreat
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_manageSessionRetreat/button_manage_createRetreatButton'))

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Verify default values and labels on Retreat overview
WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_retreatType'),
		'Retreat', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_address'),
		'Address', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_retreatName'),
		'Retreat Name*', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_retreatName'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'),
		'AlphaRetreat', FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'), retreatName, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_primaryLocation'),
		'Primary Location*', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_primaryLocation'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_primaryLocation'),
		retreatPrimaryLoc, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//Verify if the Overview menu is highlighted
retreatOverviewSavebg = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'background-color', FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.verifyMatch(retreatOverviewSavebg, 'rgba(27, 143, 200, 1)', false, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'),
		' ', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

'first pass name, will be edited with variable name'
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'),
		'AlphaRetreat', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_address'),
		'Address', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_address'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_address'),
		retreatAddress, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyOptionSelectedByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
		'1', false, 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyOptionsPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
		['3', '2', '1'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
		'4', false, 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyOptionNotPresentByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
		'0', false, 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_firstEndTimeDay1'),
		'Day 1 End Time*', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_isOvernight'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightNo'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightYes'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_startDate'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_calendarYear'),
		year, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_calendarMonth'),
		month, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//button[@id=\'startDateButton\']//preceding::div[@class=\'ngb-dp-day\']//div[@class=\'btn-light\'][text()=\''+day+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'),
		dayOneStartHour, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'),
		dayOneStartMinutes, FailureHandling.CONTINUE_ON_FAILURE)

actualDayOneStartAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
		FailureHandling.CONTINUE_ON_FAILURE)

if (dayOneStartAMPM != actualDayOneStartAMPM) {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
			FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
		dayOneEndHour, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
		dayOneEndMinutes, FailureHandling.CONTINUE_ON_FAILURE)

actualDayOneEndAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
		FailureHandling.CONTINUE_ON_FAILURE)

if (dayOneEndAMPM != actualDayOneEndAMPM) {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
			FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'),
		1, FailureHandling.CONTINUE_ON_FAILURE)

if (isOvernight == 'false') {
	//For 2 Day Retreats
	if (numberOfDays > 1) {
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
				'2', false)

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightNo'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_isOvernight'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightNo'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightYes'),
				FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementChecked(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightNo'),
				0, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneStartHour, false)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneStartMinutes, false)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
				dayOneStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
				dayOneEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'),
				dayTwoStartHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeMin_day2'),
				dayTwoStartMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		actualDayTwoStartAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/button_overview_AMPMstart2'),
				FailureHandling.CONTINUE_ON_FAILURE)

		if (dayTwoStartAMPM != actualDayTwoStartAMPM) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/button_overview_AMPMstart2'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours2'),
				dayTwoEndHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
				'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes2'),
				dayTwoEndMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		actualDayTwoEndAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
				FailureHandling.CONTINUE_ON_FAILURE)

		if (dayTwoEndAMPM != actualDayTwoEndAMPM) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/label_overview_startTimeDay3'),
			1, FailureHandling.CONTINUE_ON_FAILURE)

	if (numberOfDays > 2) {
		WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
				'3', false)

		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightNo'),
				FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
				dayOneStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayOneEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
				dayOneEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeMin_day2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/button_overview_AMPMstart2'),
				dayTwoStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
				dayTwoEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/label_overview_startTimeDay3'),
				dayThreeStartHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/input_overview_startTimeMin_day3'),
				dayThreeStartMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		actualDayThreeStartAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/button_overview_AMPMstart3'),
				FailureHandling.CONTINUE_ON_FAILURE)

		if (dayThreeStartAMPM != actualDayThreeStartAMPM) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/button_overview_AMPMstart3'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours3'),
				dayThreeEndHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
				'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes3'),
				dayThreeEndMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		actualDayThreeEndAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend3'),
				FailureHandling.CONTINUE_ON_FAILURE)

		if (dayThreeEndAMPM != actualDayThreeEndAMPM) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend3'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
}

//Overnight 2 & 3 day Retreats
if ((isOvernight == 'true') && (numberOfDays > 1)) {
	WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_numberOfDays'),
			numberOfDaysString, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/radio_overview_isOvernightYes'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_firstEndTimeDay1'),
			('Day ' + numberOfDaysString) + ' End Time*', FailureHandling.CONTINUE_ON_FAILURE)

	checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(checkValue, '', false, FailureHandling.CONTINUE_ON_FAILURE)

	checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(checkValue, '', false, FailureHandling.CONTINUE_ON_FAILURE)

	checkValue = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(checkValue, 'AM', false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_startDate'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_calendarYear'),
			year, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/dropDown_overview_calendarMonth'),
			month, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//button[@id=\'startDateButton\']//preceding::div[@class=\'ngb-dp-day\']//div[@class=\'btn-light\'][text()=\'' +
			day) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	actualDayOneStartHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(actualDayOneStartHour, dayOneStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

	actualDayOneStartMinutes = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(actualDayOneStartMinutes, dayOneStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

	actualDayOneStartAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(actualDayOneStartAMPM, dayOneStartAMPM, false, FailureHandling.CONTINUE_ON_FAILURE)

	//Overnight 2 day retreat
	if (numberOfDays == 2) {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				dayTwoEndHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
				'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				dayTwoEndMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		actualDayOneEndAMPM = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
				FailureHandling.CONTINUE_ON_FAILURE)

		if (dayOneEndAMPM != actualDayOneEndAMPM) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	//Overnight 3 day retreat
	if (numberOfDays == 3) {
		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				dayThreeEndHour, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
				'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				dayThreeEndMinutes, FailureHandling.CONTINUE_ON_FAILURE)

		if (dayThreeEndAMPM != WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'))) {
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
					FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'),
			1, FailureHandling.CONTINUE_ON_FAILURE)

	//Click to lose focus, enable Save button
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_address'),
			FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.verifyElementNotHasAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

retreatOverviewSavebg = WebUI.getCSSValue(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		'background-color', FailureHandling.CONTINUE_ON_FAILURE)

'Enter Retreat Planning Notes'
WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_overview_retreatPlanningNotes'),
		'Planning Notes', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'),
		planningNotesToEnter, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_addOrViewSessionOrRetreatMenu'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//label[@id=\'retreatName\'][text()=\'AlphaRetreat\']', true,
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

actualPlanningNotesText = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_planningNotes'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualPlanningNotesText, planningNotesToEnter, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_Overview_headerTitle'),
		'Retreat Overview: AlphaRetreat', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_retreatName'),
		retreatName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

retreatNameHeader = WebUI.concatenate(((['Retreat Overview: ', retreatName]) as String[]), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/label_Overview_headerTitle'),
		retreatNameHeader, FailureHandling.CONTINUE_ON_FAILURE)

//Retreat has been created, leaving page to then return and verify saved info
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_addOrViewSessionOrRetreatMenu'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//label[@id=\'retreatName\'][text()=\'' + retreatName) +
		'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

actualDayOneStartHour = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeHours_day1'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualDayOneStartHour, dayOneStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

actualDayOneStartMinutes = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/input_overview_startTimeMin_day1'),
		'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(actualDayOneStartMinutes, dayOneStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay1/button_overview_AMPMstart1'),
		dayOneStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

if (isOvernight == 'false') {
	checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(checkValue, dayOneEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

	checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
			'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(checkValue, dayOneEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
			dayOneEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)

	if (numberOfDays > 1) {
		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeHours_day2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/input_overview_startTimeMin_day2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay2/button_overview_AMPMstart2'),
				dayTwoStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
				dayTwoEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend2'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (numberOfDays > 2) {
		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/label_overview_startTimeDay3'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeStartHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/input_overview_startTimeMin_day3'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeStartMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/retreat_startTimeDay3/button_overview_AMPMstart3'),
				dayThreeStartAMPM, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours3'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes3'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend3'),
				dayThreeEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

if (isOvernight == 'true') {
	if (numberOfDaysString == '2') {
		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayTwoEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
				dayTwoEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)
	}

	if (numberOfDaysString == '3') {
		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endtimehours1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeEndHour, false, FailureHandling.CONTINUE_ON_FAILURE)

		checkValue = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/input_overview_endTimeMinutes1'),
				'value', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyMatch(checkValue, dayThreeEndMinutes, false, FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.verifyElementText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_AMPMend1'),
				dayThreeEndAMPM, FailureHandling.CONTINUE_ON_FAILURE)
	}
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
	FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)


//Retreat registration link implementation
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_retreatOverview_customizeRegistrationForms'), FailureHandling.CONTINUE_ON_FAILURE)


//Verifying the retreat customize participant registration lightbox and the values.
if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreat_customizeRegForm'), 10, FailureHandling.CONTINUE_ON_FAILURE)) {
//
	WebUI.comment('text verification block')
if (WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_update'), FailureHandling.CONTINUE_ON_FAILURE)) {
	
	if (ChildCareRequestDisplay == 'yes') {
		println ('ChildCareRequired' + ChildCareRequired)
			if(ChildCareRequired == 'yes'){
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired'), FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.comment('Child care request checked successfully')
			} else {
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_childcarerequestDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Toggling done successfully')
				}
	} else {
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_childcarerequestDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.waitForElementNotClickable('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', 10,true, FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.verifyElementNotVisible('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', FailureHandling.CONTINUE_ON_FAILURE)
				//WebUI.verifyElementNotClickable('Object Repository/module_encounter(SessionOrRetreat)/module_retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatchildcareRequired', FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.comment('Toggling done successfully')
	}
	
	if(DietaryRestrictionsDisplay == 'yes'){
		println('DietaryRestrictions Required ' + DietaryRestrictionsRequired)
				if(DietaryRestrictionsRequired == 'yes') {
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/check_retreatdietaryrestrictionsRequired'), FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Dietary Restrictions checked successfully')
				} else {
					WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_dietaryrestrictionsDisplay'), FailureHandling.CONTINUE_ON_FAILURE)WebUI.delay(3, FailureHandling.CONTINUE_ON_FAILURE)
					WebUI.comment('Toggling done successfully')
				}
		} else {
				WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/toggle_dietaryrestrictionsDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
				WebUI.comment('Dietary restrictions toggling done successfully')
		}
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_update'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment('Customize Retreat Registration Form updated successfully')
} else {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/lightbox_retreatOverview_customizeForms/button_retreatcustomizeForm_close'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment('close block')
}

} else {
	WebUI.comment('Customize Retreat Participant Registration Form lightbox is FAILED to display')
	return
}
WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'), FailureHandling.CONTINUE_ON_FAILURE)) {
WebUI.comment('Save button is in disabled state')
} else {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatOverview/button_overview_save'),
	FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.comment('Save button click is successful')
}

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_addOrViewSessionOrRetreatMenu'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_retreatTiles/tab_retreatTile_retreats'),
		FailureHandling.CONTINUE_ON_FAILURE)