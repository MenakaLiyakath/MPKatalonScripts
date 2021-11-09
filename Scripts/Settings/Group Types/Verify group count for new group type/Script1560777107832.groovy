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

println('Test Started')

def groupCountOnSettings

WebUI.click(findTestObject('module_settings/page_settings_groupTypes/button_emiliaSettings_settings'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

def groupCountOnOverview = 0

def groupTypeFinal

if (IsNew == 'yes') {
    groupTypeFinal = GroupTypeOnSettings
} else {
    groupTypeFinal = GroupType
}

//Dynamic object collection and steps to get the text of group count element of the respective group type
WebDriver driver = DriverFactory.getWebDriver()

//def groupTypeXpath = "//div[@id='groupTypesContainer']//div//input"
List<WebElement> groupTypeElementcoll = driver.findElements(By.xpath('//div[@id=\'groupTypesContainer\']//div//input[starts-with(@id,\'groupTypeKey\')]'))

def totType = groupTypeElementcoll.size()

//def groupCountXpath = "//div[@id='groupTypesContainer']//div[starts-with(@id,'noOfGroupUsed')]"
List<WebElement> groupCountElementcoll = driver.findElements(By.xpath('//div[@id=\'groupTypesContainer\']//div[starts-with(@id,\'noOfGroupUsed\')]'))

println('totGroupType::' + totType)

for (def grouptypeelementindex = 0; grouptypeelementindex < totType; grouptypeelementindex++) {
    WebElement groupTypeElement = groupTypeElementcoll.get(grouptypeelementindex)

    WebElement groupCountElement = groupCountElementcoll.get(grouptypeelementindex)

    def SetgroupTypeElementValue = groupTypeElement.getAttribute('value')

    if (SetgroupTypeElementValue.toString().equalsIgnoreCase(groupTypeFinal)) {
        flagGroupTypeMatches = 'true'

        groupCountOnSettings = groupCountElement.getText()

        groupCountOnSettings1 = groupCountElement.getAttribute('value')

        break
    }
}

println('Group count on Settings' + groupCountOnSettings)

//Navigate to Grow Overview page
WebUI.click(findTestObject('CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_grow'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

//Get count groups with above group type
def groupsXpath = '//div[@id=\'itemContainer\']'

List<WebElement> groupsElementcoll = driver.findElements(By.xpath(groupsXpath))

def totGroup = groupsElementcoll.size()

println(totGroup)

for (def groupCount = 0; groupCount < totGroup; groupCount++) {
    println('groupCount' + groupCount)

    WebUI.delay(2)

    WebUI.click(findTestObject('module_grow/sidebar_grow/link_groupSidebar_overviewMenu'), FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(2)

    List<WebElement> groupsElementcollNew = driver.findElements(By.xpath(groupsXpath))

    WebUI.delay(2)

    groupsElementcollNew.get(groupCount).click()

    WebUI.delay(2)
	
	
	
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupType\']//div//span[@class=\'ng-value-label ng-star-inserted\']',
		true, FailureHandling.CONTINUE_ON_FAILURE)

  /*  WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'groupType\']//span[@class=\'ng-value-label\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)*/

    //if(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE).equalsIgnoreCase(groupTypeFinal))
    def groupTypeInLoop = WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

    println('groupTypeInLoop' + groupTypeInLoop)

    if (groupTypeInLoop.equalsIgnoreCase(groupTypeFinal)) {
        println('groupCountOnOverview before increment' + groupCountOnOverview)

        groupCountOnOverview = (groupCountOnOverview + 1)

        println('groupCountOnOverview before increment' + groupCountOnOverview)
    }
}

println('groupCountOnOverview' + groupCountOnOverview)

println('groupCountOnSettings' + groupCountOnSettings)

WebUI.verifyMatch(groupCountOnOverview.toString(), groupCountOnSettings, false, FailureHandling.CONTINUE_ON_FAILURE)

