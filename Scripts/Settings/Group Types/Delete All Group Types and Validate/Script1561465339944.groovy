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


//Click on Settings button
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_settings'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)


//Validate if the delete icon is disabled
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_settings/page_settings_groupTypes/lightbox_settings_groupTypes/button_groupType_deleteIcon'), 'disabled', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)


//Select all checkbox and try to delete - Validate for erroe message
def grouptypeCheckboxXpath = "//input[@id='checkBoxKey']"

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> growTypeCheckboxList = driver.findElements(By.xpath(grouptypeCheckboxXpath))

def numberofgrouptypes = growTypeCheckboxList.size()
for (def groupTypeIndex= 0;groupTypeIndex<= numberofgrouptypes-1;groupTypeIndex++)
{
	WebElement grouptypeCheckbox = growTypeCheckboxList.get(groupTypeIndex)
	grouptypeCheckbox.click()
}
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_settings_groupTypes/button_groupType_deleteIcon'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('module_settings/page_settings_groupTypes/lightbox_settings_groupTypes/label_groupType_groupTypesCountErrorMessage'), 2, FailureHandling.CONTINUE_ON_FAILURE)


/*//Click on Settings button

WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'))

WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_settings'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
*/