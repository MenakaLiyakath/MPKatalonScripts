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

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_findPeople'))

WebUI.delay(5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/button_Profiles_addPerson'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 'disabled', 
    0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_firstName'), FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 'disabled', 
    0, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_phoneNumber'), PhoneNumber, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotHasAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), 
    'disabled', 0, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_parishInput'), Church, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_dobCalendar'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Changes for card 316 starts here')

if (MobileCarrier != '') {
    WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/dropDown_addPeople_mobileCarrier'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//*[@id = \'mobile-carrier-input\']//div/span[text()=\'' + 
        MobileCarrier) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)
}

if (MobileCarrier == 'Other - Not Listed') {
    if (OtherCarrier != '') {
        WebUI.setText(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_otherCarrier'), OtherCarrier, 
            FailureHandling.CONTINUE_ON_FAILURE)
    }
}

WebUI.comment('Changes for card 316 ends here')

//Calendar plugin Implementation starts here- card 768
int dobMonthInt = CustomKeywords.'customOmegaKeywords.customKeywordsOmega.pickCalendarDate'(DateOfBirthMonth)

/*CustomKeywords.'com.katalon.plugin.keyword.calendar.SetDateCalendarKeyword.setDate'(findTestObject('module_profiles/lightbox_findPeople_addPeople/calendar_addPeople_dob'),
		DateOfBirthDay.toInteger(), dobMonthInt, DateOfBirthYear.toInteger(), 2000, FailureHandling.CONTINUE_ON_FAILURE)*/
//Calendar plugin Implementation Ends here- card 768
/*churchSelection = new TestObject('church-selection')

churchSelection.addProperty('xpath', ConditionType.EQUALS, '//*[@id=\'parish\']//span[contains(@class,\'ng-option-label\')]', 
    true)

WebUI.click(churchSelection, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)


*/
WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/button_addPeople_save'), FailureHandling.CONTINUE_ON_FAILURE)

