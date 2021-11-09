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
import com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword as SetDateCalendarKeyword
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import Java.lang.*

/*
 * This script is to create different sessions --------for different session
 * type and dates and also perform customization for the session registration
 * forms
 */
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionTiles/button_manage_createSessionButton'),FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_sessionTypes'),FailureHandling.CONTINUE_ON_FAILURE)

println(sessType)

modifiedObject=WebUI.modifyObjectProperty(findTestObject('CommonPageObjects/placeholderObject'),'xpath', 'equals', '//mat-option//span[@class=\'mat-option-text\'][text()=\'' +sessType + '\']',true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(modifiedObject,FailureHandling.CONTINUE_ON_FAILURE)

//Validate required fields initially
WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'),FailureHandling.CONTINUE_ON_FAILURE)

if(sessName!=''){WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_sessionName'),sessName,FailureHandling.CONTINUE_ON_FAILURE)}

//Validate required fields after filling Session name
WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'),FailureHandling.CONTINUE_ON_FAILURE)

if(primLoc!=''){WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_primaryLocation'),primLoc,FailureHandling.CONTINUE_ON_FAILURE)}

//Validate required fields after filling session name and primary location
WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'),FailureHandling.CONTINUE_ON_FAILURE)

if(address!=''){WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_address'),address,FailureHandling.CONTINUE_ON_FAILURE)}

if(numberOfMeetings!=''){WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_numberOfMeetings'),numberOfMeetings,FailureHandling.CONTINUE_ON_FAILURE)}

if(maximumParticipants!=''){WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_maximumSessionParticipants'),maximumParticipants,FailureHandling.CONTINUE_ON_FAILURE)}

WebUI.comment('Set Start Date and End Date')

//Set Start Date/Time for session
if((((((startDateYear!='')&&(startDateMonth!=''))&&(startDateDay!=''))&&(endDateYear!=''))&&(endDateMonth!=''))&&(endDateDay!=''))

{

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_startDate'),FailureHandling.CONTINUE_ON_FAILURE)

	CustomKeywords.'customOmegaKeywords.selectDateOnCalendar.selectDate'(startDateMonth, startDateDay, startDateYear)

	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_endDate'),FailureHandling.CONTINUE_ON_FAILURE)
	println(endDateMonth)
	println(endDateDay)
	println(endDateYear)

	CustomKeywords.'customOmegaKeywords.selectDateOnCalendar.selectDate'(endDateMonth, endDateDay, endDateYear)

	//Validate required fields after filling session name, primary location and   Start date
	WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'),FailureHandling.CONTINUE_ON_FAILURE)

	//Set End Date/Time and End Date/Time
	sessionStartTime = ' ' +startingHour + ':' + startingMinutes + ' ' + startingAMPM+' '

	sessionEndTime = ' ' + endingHour + ':'+ endingMinutes + ' ' + endingAMPM+' '

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_startTime'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
	
	startTimeObj=WebUI.modifyObjectProperty(findTestObject('CommonPageObjects/placeholderObject'),'xpath', 'equals', '//mat-option[contains(@id,\'mat-option-\')]//span[text()=\''+sessionStartTime+'\']',true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(startTimeObj, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/dropDown_sessionOverview_endTime'))
	
	endTimeObj=WebUI.modifyObjectProperty(findTestObject('CommonPageObjects/placeholderObject'),'xpath', 'equals', '//mat-option[contains(@id,\'mat-option-\')]//span[text()=\''+sessionEndTime+'\']',true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(endTimeObj, FailureHandling.CONTINUE_ON_FAILURE)


	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

	//Validate Close Registration date gets autofilled
	def closeRegistrationDate  = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_closeRegistrationDate'), 'value',FailureHandling.CONTINUE_ON_FAILURE)

	def sessionEndDate =  WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_endDate'), 'value', FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.verifyMatch(closeRegistrationDate, sessionEndDate, false,FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview__Save'), FailureHandling.CONTINUE_ON_FAILURE)
}
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_retreat_sidebar/link_retreatSidebar_addOrViewSessionOrRetreatMenu'), FailureHandling.CONTINUE_ON_FAILURE)
	/*
	 * //Customize participant registration form
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/button_sessionOverview_customizeRegistrationForms'),
	 * FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * //Expand all the sections for customization
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_sessionDescriptionExpand'),FailureHandling.
	 * CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_personalInformationExpand'),FailureHandling.
	 * CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_skillsStrengthGiftsInterstExpand'),
	 * FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_faithExpand'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_preferenceExpand'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_otherExpand'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_paymentsExpand'), FailureHandling.CONTINUE_ON_FAILURE)
	 * //Customize Session Description display
	 * println('customizeSessionDescDisplay'+ customizeSessionDescDisplay)
	 * 
	 * if (customizeSessionDescDisplay == 'yes') { if (customizeSessionDescription
	 * != '') { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_sessionDescription'),FailureHandling.
	 * CONTINUE_ON_FAILURE) WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * lightbox_customizeForm_customizeSessionDescription/textArea_sessionDesc'),
	 * customizeSessionDescription, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * lightbox_customizeForm_customizeSessionDescription/button_saveDesc'),
	 * FailureHandling.CONTINUE_ON_FAILURE) } }
	 * 
	 * //Validation for
	 * "At least one method of communication is required error message" by switching
	 * email and phone toggle off
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_emailDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_phoneDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/
	 * Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_errorMessage'), 2, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_emailDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_phoneDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/
	 * Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_errorMessage'), 2, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * //Validation for
	 * "At least one method of communication is required error message" by switching
	 * email and phone checkkbox off
	 * WebUI.uncheck(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_emailRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.uncheck(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_phoneRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/
	 * Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_errorMessage'), 2, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_emailRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.check(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_phoneRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.verifyElementNotPresent(findTestObject('Encounter(SessionOrRetreat)/
	 * Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * label_customizeForm_errorMessage'), 2, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * //PERSONAL INFORMATION SECTION CUSTOMIZATION //Validation for
	 * "At least one method of communication is required error message" by switching
	 * toggle off //Customize gender display println('customizeGenderContatDisplay'+
	 * customizeGenderContatDisplay)
	 * 
	 * if (customizeGenderContatDisplay == 'yes') {
	 * println('customizeGenderContatRequired' + customizeGenderContatRequired)
	 * 
	 * if (customizeGenderContatRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_genderRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * } } else { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_genderDisplay'), FailureHandling.CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize age display println('customizeAgeDisplay' + customizeAgeDisplay)
	 * 
	 * if (customizeAgeDisplay == 'yes') { //Customize age display
	 * println('customizeAgeRequired' + customizeAgeRequired)
	 * 
	 * if (customizeAgeRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_ageRequired'), FailureHandling.CONTINUE_ON_FAILURE) }
	 * } else { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_spirituality'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * }
	 * 
	 * //Custom Questions
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_customQuestions'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * 
	 * //Customize Spirituality display println('customizeSpiritualityDisplay' +
	 * customizeSpiritualityDisplay)
	 * 
	 * if (customizeSpiritualityDisplay == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_spirituality'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * //Customize Spirituality display println('customizeSpiritualityRequired' +
	 * customizeSpiritualityRequired)
	 * 
	 * if (customizeSpiritualityRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * input_customizeForm_spirituality'), FailureHandling.CONTINUE_ON_FAILURE) } }
	 * else { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_spirituality'), FailureHandling.CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Hear About ACT display println('customizeHearAboutACTSDisplay' +
	 * customizeHearAboutACTSDisplay)
	 * 
	 * if (customizeHearAboutACTSDisplay == 'yes') {
	 * 
	 * //Customize Hear About ACT display println('customizeHearAboutACTRequired' +
	 * customizeHearAboutACTRequired)
	 * 
	 * if (customizeHearAboutACTRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_whyDidYouDecideToRegisterrequired'),
	 * FailureHandling.CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_hearAboutACTSDisplay'),
	 * FailureHandling.CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Have you attended ACT display
	 * println('customizeHaveAboutACTSDisplay' + customizeHaveAboutACTSDisplay)
	 * 
	 * if (customizeHaveAboutACTSDisplay == 'yes') {
	 * 
	 * //Customize Have About ACT display println('customizeHaveAboutACTRequired' +
	 * customizeHaveAboutACTRequired)
	 * 
	 * if (customizeHaveAboutACTRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_haveYouAttendedRequired'),
	 * FailureHandling.CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_attendedAboutACTSDisplay'),
	 * FailureHandling.CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Religious Affiliation display println('customize
	 * religiousaffiliation Display' + customizeReligiousDisplay)
	 * 
	 * if (customizeReligiousDisplay == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_religiousAffiliationDisplay'),FailureHandling.
	 * CONTINUE_ON_FAILURE) //Customize Spirituality display
	 * println('customizeSpiritualityRequired' +customizeReligiousRequired) if
	 * (customizeReligiousRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_religiousAffiliationRequired'),FailureHandling.
	 * CONTINUE_ON_FAILURE) } }
	 * 
	 * //Customize Christian faith display println('customize christian faith
	 * Display' + customizeChristianfaithDisplay)
	 * 
	 * if (customizeChristianfaithDisplay == 'yes') { WebUI.comment('Christian faith
	 * is already in enabled state')
	 * 
	 * if (customizeChristianfaithRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_christianfaithDisplayRequired'),FailureHandling.
	 * CONTINUE_ON_FAILURE) } }
	 * 
	 * //Customize Church Affiliation display
	 * println('customizeChurchAffilationDisplay' +
	 * customizeChurchAffilationDisplay)
	 * 
	 * if (customizeChurchAffilationDisplay == 'yes') {
	 * println('customizeChurchAffilationDisplay' +
	 * customizeChurchAffilationDisplay)
	 * 
	 * if (customizeChurchAttend == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_editChurchAffiliationSelection'),
	 * FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/
	 * Session/page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_selectAffiliation'),
	 * 1,FailureHandling.CONTINUE_ON_FAILURE)) {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * radio_customizeForm_doYouAttend'), FailureHandling.CONTINUE_ON_FAILURE)
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_selectAffiliation'),FailureHandling.CONTINUE_ON_FAILURE)
	 * } } } else { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_parishChurchAffiliationDisplay'),FailureHandling.
	 * CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Child Care display println('customizeChildCareDisplay' +
	 * customizeChildCareDisplay)
	 * 
	 * if (customizeChildCareDisplay == 'yes') { //Customize Child Care display
	 * println('customizeChildCareRequired' + customizeChildCareRequired)
	 * 
	 * if (customizeChildCareRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_childCareRequired'),FailureHandling.
	 * CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_childCareDisplay'), FailureHandling.CONTINUE_ON_FAILURE)
	 * }
	 * 
	 * //Customize Seat Me display println('customizeSeatMeDisplay' +
	 * customizeSeatMeDisplay)
	 * 
	 * if (customizeSeatMeDisplay == 'yes') { //Customize Seat Me display
	 * println('customizeSeatMeRequired' + customizeSeatMeRequired)
	 * 
	 * if (customizeSeatMeRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * input_customizeForm_seatMeWithRequired'),FailureHandling.CONTINUE_ON_FAILURE)
	 * } } else { WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_seatMeWithDisplay'),FailureHandling.CONTINUE_ON_FAILURE)
	 * }
	 * 
	 * //Customize comments display println('customizeCommentsDisplay' +
	 * customizeCommentsDisplay)
	 * 
	 * if (customizeCommentsDisplay == 'yes') { //Customize comments display
	 * println('customizeCommentsRequired' + customizeCommentsRequired)
	 * 
	 * if (customizeCommentsRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_prefferedContactRequired'),
	 * FailureHandling.CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_prefferedContactDisplay'),FailureHandling.
	 * CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Dietary display println('customizeDietaryDisplay' +
	 * customizeDietaryDisplay)
	 * 
	 * if (customizeDietaryDisplay == 'yes') { println('customizeDietaryeRequired' +
	 * customizeDietaryeRequired)
	 * 
	 * if (customizeDietaryeRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_dietaryRestrictionsRequired'),FailureHandling.
	 * CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_dietaryRestrictionsDisplay'),FailureHandling.
	 * CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Preferred Contact display
	 * println('customizePreferredContatDisplay' + customizePreferredContatDisplay)
	 * 
	 * if (customizePreferredContatDisplay == 'yes') { //Customize Preferred Contact
	 * display println('customizePreferredContatRequired' +
	 * customizePreferredContatRequired)
	 * 
	 * if (customizePreferredContatRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_prefferedContactRequired'),FailureHandling.
	 * CONTINUE_ON_FAILURE) } } else {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_prefferedContactDisplay'),FailureHandling.
	 * CONTINUE_ON_FAILURE) }
	 * 
	 * //Customize Payments if (customizePmtsFeeDisplay == 'yes') { //Customize
	 * Payments Fee toggle println('customizePaymentsFee' + customizePmtFeeRequired)
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * toggle_customizeForm_pmtFee'), FailureHandling.CONTINUE_ON_FAILURE) if
	 * (customizePmtFeeRequired == 'yes') {
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * checkBox_customizeForm_pmtfeeRequired'), FailureHandling.CONTINUE_ON_FAILURE)
	 * } WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * textarea_customizeForm_pmtfeeDescription'),
	 * customizePmtFeeDescription,FailureHandling.CONTINUE_ON_FAILURE)
	 * WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * input_customizeForm_pmtfeeLabel'),
	 * customizePmtFeeLabel,FailureHandling.CONTINUE_ON_FAILURE)
	 * WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * input_customizeForm_pmtfeePrice'),
	 * customizePmtPrice,FailureHandling.CONTINUE_ON_FAILURE) }
	 * 
	 * WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/
	 * page_sessionOverview/lightbox_sessionOverview_customizeForms/
	 * button_customizeForm_update'), FailureHandling.CONTINUE_ON_FAILURE) }
	 */



