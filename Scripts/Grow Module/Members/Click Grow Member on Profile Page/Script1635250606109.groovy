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

WebUI.comment('input filter values')

WebUI.setText(findTestObject('module_profiles/input_profiles_lastName'), LastName)

WebUI.click(findTestObject('module_profiles/kendoFilter_profiles_lastName'))

CustomKeywords.'customOmegaKeywords.customKeywordsOmega.KendoFilter'('li.k-item', filterOptions)

WebUI.delay(2)

WebUI.comment('click and open person')

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//kendo-grid[@id=\'peopleKendoGrid\']//table[@class=\'k-grid-table\']//td//span[text()=\''+LastName+'\']',
		true)

WebUI.click(dynamicObject)

WebUI.delay(2)

def lastNameText = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_lastName'), 
    'value')

WebUI.verifyMatch(lastNameText, LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

def firstNameText = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_firstName'), 
    'value')

WebUI.verifyMatch(firstNameText, FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

def phoneText = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_phone'), 
    'value')

if (!(Phone.substring(0, 1) == '(')) {
    Phone = ((((('(' + Phone.substring(0, 3)) + ') ') + Phone.substring(3, 6)) + '-') + Phone.substring(6))
}

WebUI.verifyMatch(phoneText, Phone, false, FailureHandling.CONTINUE_ON_FAILURE)

def emailText = WebUI.getAttribute(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_basicProfile/input_basicInfo_email'), 
    'value')

WebUI.verifyMatch(emailText, Email, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Navigate to Faith Journey Tab')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/tab_groupMembers_faithJourney'), FailureHandling.CONTINUE_ON_FAILURE)

DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
LocalDateTime now = LocalDateTime.now()
println "Curr"+dtf.format(now)

def currentDateString=dtf.format(now).toString()

println "currentDateString"+currentDateString
def timeframeDate=currentDateString+" - Ongoing"

println "timeframeDate"+timeframeDate
WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'container-faith-journey\']//div[@class=\'row current-experience-rows experience-rows\']//a[text()=\''+GroupName+'\']//ancestor::div[@class=\'row current-experience-rows experience-rows\']//div[text()=\'Member\']//ancestor::div[@class=\'row current-experience-rows experience-rows\']//div//span[text()=\''+timeframeDate+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Navigate to Journey points')


WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_editOnProfile_journeyPoints'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/select_journeyPoints_experience'))

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
    GroupName) + '\']', true)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch((WebUI.getText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/container_journeyPoints_keyGroupName'), FailureHandling.CONTINUE_ON_FAILURE)), 
    GroupName, false)

WebUI.verifyMatch(WebUI.getText(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_groupMemberEdit_journeyPoints/span_journeyPoints_role'), FailureHandling.CONTINUE_ON_FAILURE), 
    Role, false)

WebUI.click(findTestObject('module_grow/page_group/tab_group_members/lightbox_members_editOnProfile/tab_editOnProfile_basicInfo'))

