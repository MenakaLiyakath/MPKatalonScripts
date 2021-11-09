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

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), '', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 'disabled', 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 
    'disabled', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_firstName'), FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_phoneNumber'), PhoneNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_skills'), Skills, FailureHandling.CONTINUE_ON_FAILURE)

if (Church != '') {
    WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_parishInput'), Church, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'parish\']//span[text()=\'' + Church) + 
        '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

switch (Gender) {
    case 'Male':
        WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/radio_editPeople_male'))

        break
    case 'Female':
        WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/radio_editPeople_feMale'))

        break
    case 'Decline to Answer':
        WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/radio_editPeople_declineAnswer'))
}

/*
if (DateOfBirthYear != '')
{
	WebUI.clearText(findTestObject('Sessions/Sessions-Participants-Page/EditProfileLightbox/dateOfBirthInput'), FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Sessions/Sessions-Participants-Page/EditProfileLightbox/dateOfBirthButton'), FailureHandling.CONTINUE_ON_FAILURE)


	//Calendar plugin Implementation starts here- card 768
	int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

	CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('module_profiles/lightBox_findPeople_editPeople/calendar_profiles_dob'),
			DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)
	//Calendar plugin Implementation Ends here- card 768

	
	 WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.selectOptionByLabel(findTestObject('Sessions/Sessions-Participants-Page/EditProfileLightbox/Selectyear'), DateOfBirthYear,
	 false, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.selectOptionByLabel(findTestObject('Sessions/Sessions-Participants-Page/EditProfileLightbox/Selectmonth'), DateOfBirthMonth,
	 false, FailureHandling.CONTINUE_ON_FAILURE)
	 daySelection = new TestObject('daySelection')
	 daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + DateOfBirthDay) +
	 '\']', true)
	 WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}
*/
switch (PreferredContactMethod) {
    case 'Email':
        WebUI.click(findTestObject('Object Repository/Sessions/Sessions-Participants-Page/EditProfileLightbox/genderOne'))

        break
    case 'Text':
        WebUI.click(findTestObject('Object Repository/Sessions/Sessions-Participants-Page/EditProfileLightbox/genderTwo'))

        break
    case 'Phone Call':
        WebUI.click(findTestObject('Object Repository/Sessions/Sessions-Participants-Page/EditProfileLightbox/genderThree'))
}

if(MobileCarrier!='')
{
	WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/dropDown_editPeople_mobileCarrier'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//*[@id = \'mobile-carrier-input\']//div/span[text()=\''+MobileCarrier+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
	
	
}

if(MobileCarrier=='Other - Not Listed')
{
	if(OtherCarrier!='')
	{
	WebUI.setText(findTestObject('module_profiles/lightBox_findPeople_editPeople/input_editPeople_otherCarrier'), OtherCarrier, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
}



WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

