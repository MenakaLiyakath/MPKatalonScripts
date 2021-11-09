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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.delay(2)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_lastName'),
	LastName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/input_sessionsParticipants_firstName'),
	FirstName)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/kendoFilter_sessionsParticipants_firstName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', 'Is equal to')

WebUI.delay(1)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'volunteerGrid\']//table[@class=\'k-grid-table\']//td[text()=\'' +  FirstName + '\']//ancestor::table[@class=\'k-grid-table\']//td//span[text()=\'' + LastName + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_basicInfo'))

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_phone'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_email'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_skills'), 
    Skills, FailureHandling.CONTINUE_ON_FAILURE)

if (PreferredContactMethodEmail != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactEmail'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredContactMethodText != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactText'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (PreferredContactMethodPhoneCall != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/checkbox_createProfile_preferedcontactPhone'), 
        FailureHandling.CONTINUE_ON_FAILURE)
}

if (DateOfBirthYear != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/button_createProfile_dateOfBirth'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    //Calendar plugin Implementation starts here- card 768
    int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

    CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_createProfile/calendar_createProfile_dob'), 
        DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE) //Calendar plugin Implementation Ends here- card 768
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/tab_editProfile_journeyPoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('changes for card 965 starts here')

if (PreferredRoles == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/icon_editProfile_clearPreferredRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_preferredRole'))

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-preferred-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
        PreferredRoles) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

if (PrimaryRole == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/icon_editProfile_clearPrimaryRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_primaryRole'))


WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-primary-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
    PrimaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject)
}

if (SecondaryRole == '') {
    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/icon_editProfile_clearSecondaryRole'), 
        FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/input_editProfile_secondaryRoleDropdown'))


WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'volunteer-secondary-role-dropdown\']//div[@class=\'ng-dropdown-panel-items scroll-host\']//span[@class=\'ng-option-label\'][text()=\'' + 
    SecondaryRole) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject)
}

WebUI.comment('changes for card 965 ends here')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/lightbox_sessionVolunteer_editProfile/button_editProfile_save'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

