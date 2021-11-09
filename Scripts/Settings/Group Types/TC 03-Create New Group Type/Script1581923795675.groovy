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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

/*
//Login to Application
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.globalLoginUrl)

WebUI.waitForElementVisible(findTestObject('page_login/link_login_dontRememberPassword'), 0)

try {
	neworlastlogin = WebUI.getText(findTestObject('page_login/link_login_dontRememberPassword'))

	if (neworlastlogin == 'Not your account?') {
		WebUI.click(findTestObject('page_login/link_login_dontRememberPassword'))

		WebUI.delay(2)
	}
	
	WebUI.setText(findTestObject('page_login/input_login_email'), username)
	
	

	WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword)

	WebUI.click(findTestObject('page_login/button_login_logIn'))

	WebUI.delay(1)
}
catch (def e) {
	neworlastlogin = WebUI.getText(findTestObject('page_login/link_login_dontRememberPassword'))

	if (neworlastlogin == 'Not your account?') {
		WebUI.click(findTestObject('page_login/link_login_dontRememberPassword'))

		WebUI.delay(2)
	}
	
	WebUI.click(findTestObject('page_login/link_login_dontRememberPassword'))

	WebUI.setText(findTestObject('page_login/input_login_email'), username)

	WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword)

	WebUI.click(findTestObject('page_login/button_login_logIn'))

	WebUI.delay(1)
}

*/

//Click on Settings button
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_settings'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

//Add a new group type
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_addIcon'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_settings/page_settings_groupTypes/input_emiliaSettings_groupTypeKey'), GroupTypeOnSettings, 
    FailureHandling.CONTINUE_ON_FAILURE)

//Set type Color
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/label_emiliaSettings_pickColor'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('module_settings/page_settings_groupTypes/container_emiliaSettings_groupColor'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

def SetgroupTypeElementValue

switch (GroupTypeColourOnSettings) {
    case 'one':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color1'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'two':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color2'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'three':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color3'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'four':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color4'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'five':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color5'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'six':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color6'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'seven':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color7'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'eight':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color8'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'nine':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color9'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'ten':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color10'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'eleven':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color11'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'twelve':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color12'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
    case 'thirteen':
        WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/color_colorPallete_color13'), 
            FailureHandling.CONTINUE_ON_FAILURE)

        break
}

WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_emiliaSettings_colorPallete/icon_colorPallete_close'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

//Verify if the added group type is displayed on the settings page
def flagGroupTypeMatches = 'false'

WebDriver driver = DriverFactory.getWebDriver()

def groupTypeXpath = '//input[starts-with(@id,\'groupTypeKey\')]'

List<WebElement> groupTypeElementcoll = driver.findElements(By.xpath('//input[starts-with(@id,\'groupTypeKey\')]'))

def totType = groupTypeElementcoll.size()

println('totGroupType::' + totType)

for (def grouptypeelementindex = 0; grouptypeelementindex < totType; grouptypeelementindex++) {
    WebElement groupTypeElement = groupTypeElementcoll.get(grouptypeelementindex)

    println('SetgroupTypeElementValue::' + SetgroupTypeElementValue)

    SetgroupTypeElementValue = groupTypeElement.getAttribute('value')

    if (SetgroupTypeElementValue.toString().equalsIgnoreCase(GroupTypeOnSettings)) {
        flagGroupTypeMatches = 'true'

        break
    }
}

println('flagGroupTypeMatches' + flagGroupTypeMatches)

WebUI.verifyMatch(flagGroupTypeMatches, 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

