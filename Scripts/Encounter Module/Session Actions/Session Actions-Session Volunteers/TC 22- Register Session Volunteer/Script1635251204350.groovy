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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.navigateToUrl(GlobalVariable.globalizedVolunteerRegLink, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_emailAddress'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_skills'), 
    Skills, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_comments'), 
    AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_dietaryRestrictions'), 
    DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

if (PreferredRoles != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_preferredRoles'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_preferredRoles'), 
        PreferredRoles, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.sendKeys(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_preferredRoles'), 
        Keys.chord(Keys.ENTER), FailureHandling.CONTINUE_ON_FAILURE)
}
//println "Areyouamember"+Areyouamember

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/label_volunteerSignup_areYouMember'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    if (Areyouamember != '') {
        if (Areyouamember == 'No') {
            WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/radio_volunteerSignup_areYouMemberNo'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/input_volunteerSignup_parish'), 
                Church, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/radio_volunteerSignup_areYouMemberYes'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

if (DateOfBirthYear != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/button_volunteerSignup_dateOfBirth'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/dropDown_volunteerSignup_year'), 
        DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/dropDown__volunteerSignup_month'), 
        DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

    daySelection = new TestObject('day-selection')

    daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + DateOfBirthDay) + 
        '\']', true)

    WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.comment('Card#856 changes starts here')

println(PreferredContactMethodEmail)

println(PreferredContactMethodText)

println(PreferredContactMethodPhoneCall)

if (PreferredContactMethodEmail != '') {
    if (PreferredContactMethodEmail.toString().toLowerCase() == 'yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/checkbox_volunteerSignup_preferredContactEmail'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodText != '') {
    if (PreferredContactMethodText.toString().toLowerCase() == 'yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/checkbox_volunteerSignup_preferredContactText'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

if (PreferredContactMethodPhoneCall != '') {
    if (PreferredContactMethodPhoneCall.toString().toLowerCase() == 'yes') {
        WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/checkbox_volunteerSignup_preferredContactPhone'), 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

WebUI.comment('Card#856 changes starts here')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsSignupFormVolunteer/button_volunteerSignup_submit'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', false, FailureHandling.CONTINUE_ON_FAILURE)

