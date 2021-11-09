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

WebUI.navigateToUrl(GlobalVariable.globalizedRetreatVolunteerRegLink, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_emailAddress'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_skills'), 
    Skills, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_additionalComments'), 
    AdditionalComments, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_dietaryRestrictions'), 
    DietaryRestrictions, FailureHandling.CONTINUE_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/label_retreatSignUp_areYouMember'), 
    1, FailureHandling.CONTINUE_ON_FAILURE)) {
    if (Areyouamember != '') {
        if (Areyouamember.toString().toLowerCase() == 'no') {
            WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/radio_retreatSignUp_areYouMemberNo'), 
                FailureHandling.CONTINUE_ON_FAILURE)

            WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/input_retreatSignUp_parish'), 
                Church, FailureHandling.CONTINUE_ON_FAILURE)
        } else {
            WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/radio_retreatSignUp_areYouMemberYes'), 
                FailureHandling.CONTINUE_ON_FAILURE)
        }
    }
}

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

println('PreferredRoles' + PreferredRoles)

if (PreferredRoles != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/ngselect_retreat_preferredRolesDropDown'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//*[@id=\'preferredRolesDropDown\']//span[@class=\'ng-option-label\'][text()=\'' + 
        PreferredRoles) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject)
}

WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

if (DateOfBirthYear != '') {
    WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/button_retreatSignUp_dateOfBirth'), 
        FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

    /*	//Calendar plugin Implementation starts here- card 768
		int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

		CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/calendar_retreatSignUp_dob'),
				DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)
		//Calendar plugin Implementation Ends here- card 768
*/
    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectyear'), 
        DateOfBirthYear, false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/dropDown_retreatSignUp_Selectmonth'), 
        DateOfBirthMonth, false, FailureHandling.CONTINUE_ON_FAILURE)

    daySelection = new TestObject('day-selection')

    daySelection.addProperty('xpath', ConditionType.EQUALS, ('//div[contains(@class,\'ngb-dp-day\')]/div[text()=\'' + DateOfBirthDay) + 
        '\']', true)

    WebUI.click(daySelection, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatsVolunteerSignupForm/button_retreatSignUp_submit'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent('Thank you for registering!', false, FailureHandling.CONTINUE_ON_FAILURE)

