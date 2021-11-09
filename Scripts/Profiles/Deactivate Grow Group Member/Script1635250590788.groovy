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
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/tab_editPeople_journeyPoints'))

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/radio_editPeople_activeMemberNo'))

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/button_editPeople_save'))

WebUI.comment('Navigate to Grow page and open group ')

WebUI.delay(3)

WebUI.click(findTestObject('CommonPageObjects/img_common_home'))

WebUI.delay(1)

WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_grow'))

WebUI.delay(1)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//div[text()=\'' + 
    GroupName) + '\']/ancestor::div[@id=\'itemHeader\']//following-sibling::div//div[@id=\'groupAudience\'][text()=\'') + 
    Audience) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject)

WebUI.delay(1)

WebUI.comment('Navigate to member tab and validate if the member is removed')

if ((Role == '') || (Role == 'Participant')) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((((('//div[@id=\'divParticipantRows\']//div[text()=\'' + 
        LastName) + '\']//following-sibling::div[text()=\'') + FirstName) + '\']//following-sibling::div[text()=\'') + Role) + 
        '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((((('//div[@id=\'divLeaderRows\']//div[text()=\'' + LastName) + 
        '\']//following-sibling::div[text()=\'') + FirstName) + '\']//following-sibling::div[text()=\'') + Role) + '\']', 
        true, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.comment('Navigate to people page')

WebUI.click(findTestObject('Object Repository/CommonPageObjects/img_common_home'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/CommonPageObjects/page_home/image_homePage_profiles'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName)

WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

WebUI.delay(1)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//td//span[text()=\'' + 
    LastName) + '\']', true)

WebUI.click(dynamicObject)

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/tab_editPeople_faithJourney'))

WebUI.comment('Navigate to Faith Journey Tab')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_faithJourney'), 
    FailureHandling.CONTINUE_ON_FAILURE)

DateTimeFormatter dtf = DateTimeFormatter.ofPattern('MM/dd/yyyy')

LocalDateTime now = LocalDateTime.now()

println('Curr' + dtf.format(now))

def currentDateString = dtf.format(now).toString()

println('currentDateString' + currentDateString)

def timeframeDate = (currentDateString + ' - ') + currentDateString

println('timeframeDate' + timeframeDate)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ((('//div[@id=\'container-faith-journey\']//div[@class=\'row past-experience-rows experience-rows\']//div//a[text()=\'' + 
    GroupName) + '\']//ancestor::div[@class=\'row past-experience-rows experience-rows\']//div[text()=\'Member\']//ancestor::div[@class=\'row past-experience-rows experience-rows\']//div[text()=\'') + 
    timeframeDate) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Navigate to Journey points Tab')

