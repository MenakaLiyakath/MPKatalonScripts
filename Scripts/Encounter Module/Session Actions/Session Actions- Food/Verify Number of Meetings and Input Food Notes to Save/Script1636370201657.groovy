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


WebUI.delay(2)
def numberOfMeetings = WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_numberOfMeetings'), 
    'value', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionFood'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

meetingNoteXpath = '//div[@id=\'foodBudgetSection\']//following::div[@class=\'meeting\']'

List<WebElement> meetingNotes = driver.findElements(By.xpath(meetingNoteXpath))

def totMeetingNotes = meetingNotes.size()

println('totMeetingNotes' + totMeetingNotes)

WebUI.verifyMatch(numberOfMeetings, totMeetingNotes.toString(), false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

for (int meetingNumber = 1; meetingNumber <= totMeetingNotes; meetingNumber++) {
    WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//textarea[contains(@class,\'food-notes\')])[' + meetingNumber) + 
        ']', true, FailureHandling.CONTINUE_ON_FAILURE)

    MeetingFoodNoteBaseTextMod = ((meetingNumber.toString() + ' - ') + MeetingFoodNoteBaseText.substring(meetingNumber.toString().length() + 
        3))

    WebUI.setText(dynamicObject, MeetingFoodNoteBaseTextMod, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/input_sessionFood_generalNotes'), GeneralFoodNoteText, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsFood/button_sessionFood_save'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

