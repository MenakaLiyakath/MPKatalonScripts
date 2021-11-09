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


def name=LastName+", "+FirstName
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/button_sessionsParticipants_addParticipant'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/modal__sessionsParticipants_participant'), 
    2)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'), 
    'Par', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Verify if create new and similar records spans are displayed')

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_similarRecord'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_createNewrecord'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Split the total similar records and convert it to integer')

def similarRecordText = WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_similarRecord'), 
    FailureHandling.CONTINUE_ON_FAILURE)

String[] splitArray = similarRecordText.split('\\(')

def totalSimilarRecords1 = splitArray[1]

String[] splitArray1 = totalSimilarRecords1.split('\\)')

def totalSimilarRecords2 = splitArray1[0]

def totalSimilarRecordFinal = totalSimilarRecords2

WebUI.comment('Get the total count of options in last name dropdown and validate it against the total similar records')

WebDriver driver = DriverFactory.getWebDriver()

def similairOptionsXpath = '//ng-select[@id=\'lastNameInput\']//div[@class=\'ng-option\']//span'

List<WebElement> similairOptions = driver.findElements(By.xpath(similairOptionsXpath))

def totSimilarRecordObjects = similairOptions.size() - 1



println('totSimilarRecordObjects' + totSimilarRecordObjects)

WebUI.verifyMatch(totalSimilarRecordFinal, totSimilarRecordObjects.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Create New /Select existing')

WebUI.comment('Create New')

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'), 
    'par', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipant_createNewrecord'), 
    FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'),
	LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_firstName'), 
    FirstName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_phoneNumber'), 
    PhoneNumber, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'), 
    Email, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/button_addParticipant_saveAndAddNew'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'), 
    LastName, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.modifyObjectProperty(dynamicObject, 'xpath','equals', '//ng-select[@id=\'lastNameInput\']//div[@class=\'ng-option\']//span[text()=\''+name+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addPArticipant_existingPersonNote'), 
    2)

WebUI.comment('Validate all member related fields are disabled and non member fields are editable')

WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/label_addParticipants_clearFields'), 
    2, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_firstName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_lastName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_phoneNumber'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_dietaryRestrictions'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Enter value in editable field')

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_comments'), 
    'Test Comment', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.comment('Clear fields and validate all field values are set to default')

WebUI.click(findTestObject('Object Repository/module_grow/page_group/tab_group_members/lightbox_groupMembers_addPeople/label_addPeople_clearFields'))

WebUI.delay(1)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_firstName'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_firstName'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_phoneNumber'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_phoneNumber'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/lightbox_sessionsParticipants_addParticipant/input_addParticipant_email'), 
        'value', FailureHandling.CONTINUE_ON_FAILURE), '', false, FailureHandling.CONTINUE_ON_FAILURE)

