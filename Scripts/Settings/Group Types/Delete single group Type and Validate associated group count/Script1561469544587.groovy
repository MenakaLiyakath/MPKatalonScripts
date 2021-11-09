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

WebUI.openBrowser(GlobalVariable.globalLoginUrl)


WebUI.setText(findTestObject('page_login/input_login_email'), GlobalVariable.globalTestUser)

WebUI.setEncryptedText(findTestObject('page_login/input_login_password'), GlobalVariable.globalTestUserPassword)

WebUI.click(findTestObject('page_login/button_login_logIn'))
WebUI.delay(2)
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_settings'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

def numberofGroupsXpath = "//div[starts-with(@id,'noOfGroupUsed')]"

WebDriver driver = DriverFactory.getWebDriver()
//Getting the list of number of groups
List<WebElement> numberofgroupsList = driver.findElements(By.xpath(numberofGroupsXpath))

def numberofgrouptypes = numberofgroupsList.size()

def checkboxxpath = "//input[@id='checkBoxKey']"
//Getting the list of disabled check boxes
List<WebElement> checkboxList = driver.findElements(By.xpath(checkboxxpath))

for (def groupTypeIndex= 0;groupTypeIndex<= numberofgrouptypes-1;groupTypeIndex++)
{
	WebElement grouptypenumber = numberofgroupsList.get(groupTypeIndex)
	WebElement checkboxclick = checkboxList.get(groupTypeIndex)
	def numberofthisType=grouptypenumber.getText().toInteger()

	//Verifying whether group type having more than 0 number of groups is not clickable
	if (numberofthisType > 0)
	{
		WebUI.verifyMatch(checkboxclick.getAttribute('disabled'), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)
	}

}
def grouptypeXpath1 = "//input[starts-with(@id,'groupTypeKey')]"
List<WebElement> growTypeList1 = driver.findElements(By.xpath(grouptypeXpath1))
//getting the count of group types
def numberofgrouptypes1 = growTypeList1.size()
def grouptypeCheckboxXpath2 = "//input[@id='checkBoxKey']"
List<WebElement> growTypeCheckboxList2 = driver.findElements(By.xpath(grouptypeCheckboxXpath2))
for (def groupTypeIndex1= 0;groupTypeIndex1<= numberofgrouptypes1-1;groupTypeIndex1++)
{
	WebElement grouptype1 = growTypeList1.get(groupTypeIndex1)
	WebElement typeCheckBox = growTypeCheckboxList2.get(groupTypeIndex1)
	//delete one group type
	if(	grouptype1.getAttribute('value')==GroupTypeOnSettings)
		typeCheckBox.click()
}

WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_settings_groupTypes/button_groupType_deleteIcon'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ul[@id=\'groupTypesList\']//li[text()=\''+GroupTypeOnSettings+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
//verify single group type which is not associated with any group has been deleted
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('module_settings/page_settings_groupTypes/lightbox_settings_deleteGroupTypes/button_groupType_confirmDelete'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)
WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_grow'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('module_grow/page_group/button_group_addGroup'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('module_grow/page_group/tab_group_details/input_group_Type'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupType\']//span[text()=\''+GroupTypeOnSettings+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
//verify whether deleted element not listed in the group type
WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

