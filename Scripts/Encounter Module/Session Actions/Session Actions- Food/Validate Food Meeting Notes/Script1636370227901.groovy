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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFeedback'))

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

meetingNoteXpath = '//div[@id=\'foodBudgetSection\']//following::div[@class=\'meeting\']'

List<WebElement> meetingNotes = driver.findElements(By.xpath(meetingNoteXpath))

def totMeetingNotes = meetingNotes.size()

println('totMeetingNotes' + totMeetingNotes)

println('General Notes::' + WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes'), 
        'value'))

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes'), 
        'value'), ExpectedGeneralFoodNoteText, false, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.verifyMatch(WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes')),ExpectedGeneralFoodNoteText , false, FailureHandling.CONTINUE_ON_FAILURE)
String genNotesLength = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes'), 
    'value').length()

println('genNotesLength:::+genNotesLength' + genNotesLength)

WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes'), 
        'value').length().toString(), '4000', false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

for (int meetingNumber = 1; meetingNumber <= totMeetingNotes; meetingNumber++) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//textarea[contains(@class,\'food-notes\')])[' + meetingNumber) + 
        ']', true, FailureHandling.CONTINUE_ON_FAILURE)

    ExpectedMeetingFoodNoteBaseTextMod = ((meetingNumber.toString() + ' - ') + ExpectedMeetingFoodNoteBaseText.substring(
        meetingNumber.toString().length() + 3))

    WebUI.verifyMatch(WebUI.getAttribute(dynamicObject, 'value'), ExpectedMeetingFoodNoteBaseTextMod, false, FailureHandling.CONTINUE_ON_FAILURE)

    println('ExpectedMeetingFoodNoteBaseText size:' + WebUI.getAttribute(dynamicObject, 'value').length())

    WebUI.verifyMatch(WebUI.getAttribute(dynamicObject, 'value').length().toString(), '4000', false, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}

