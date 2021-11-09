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

WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_last-name'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_emailAddress'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

if (Gender != '') {
    if (Gender == 'Male') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderOne'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (Gender == 'Female') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderTwo'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    if (Gender == 'Decline to Answer') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/radioButton_editVolunteer_genderThree'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (DietaryRestrictions != '') {
    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_dietaryRestrictions'), 
        DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)
}

if (Skills != '') {
    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_skills'), 
        Skills, FailureHandling.CONTINUE_ON_FAILURE)
}

//Card# 584
if (PreferredContactMethodEmail != '') {
    if (PreferredContactMethodEmail == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_EmailCheckbox'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodText != '') {
    if (PreferredContactMethodText == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_TextCheckbox'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodPhoneCall != '') {
    if (PreferredContactMethodPhoneCall == 'Yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/input_editVolunteer_phoneCallCheckbox'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (DateOfBirthYear != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/button_editVolunteer_dateOfBirth'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    //Calendar plugin Implementation starts here- card 768
    int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

    CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/calendar_editVolunteer_dob'), 
        DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE //Calendar plugin Implementation Ends here- card 768
        ) /*      WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectyear'),
	 DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectmonth'),
	 DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)
	 daySelection = new TestObject('day-selection')
	 daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' +
	 DateOfBirthDay) + '\']', true)
	 WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)
	 WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)*/
}

/*
WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/dropDown_editVolunteer_parish'), 
    Church, FailureHandling.CONTINUE_ON_FAILURE)*/
//Card# 584 ends here
WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/tab_editVolunteer_journePoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('changes for card 965 starts here')

if (PreferredRoles == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/icon_editVolunteer_clearPreferredRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_preferredRole'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-preferred-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
        PreferredRoles) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

if (PrimaryRole == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/icon_editVolunteer_clearPrimaryRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_primaryRole'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-primary-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
        PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

if (SecondaryRole == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/icon_editVolunteer_clearSecondaryRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_secondaryRoleDropdown'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-secondary-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
        SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

WebUI.comment('changes for card 965 ends here')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatVolunteer/lightbox_retreatVolunteer_editVolunteer/button_editVolunteer_save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

