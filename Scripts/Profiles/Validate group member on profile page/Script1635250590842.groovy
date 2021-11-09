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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_lastName'), 
        'value'), LastName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_firstName'), 
        'value'), FirstName, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightbox_findPeople_addPeople/input_addPeople_emailAddress'), 
        'value'), Email, false, FailureHandling.CONTINUE_ON_FAILURE)


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

WebUI.comment('Navigate to Journey Points tab')

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/tab_editPeople_journeyPoints'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('module_profiles/lightBox_findPeople_editPeople/dropDown_editPeople_experience'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//ng-select[@id=\'experience-dropdown\']//div//span[@class=\'ng-option-label\'][text()=\'' + 
    GroupName) + '\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)


WebUI.verifyMatch(WebUI.getAttribute(findTestObject('module_profiles/lightBox_findPeople_editPeople/radio_editPeople_activeMemberYes'), 'checked', FailureHandling.CONTINUE_ON_FAILURE), 'true', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//ng-select[@id=\'roles-dropdown\']//span[@class=\'ng-value-label\']', 
    true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), Role, false, FailureHandling.CONTINUE_ON_FAILURE)

