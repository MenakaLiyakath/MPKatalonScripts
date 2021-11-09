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

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/checkbox_retreatParticipant_selectAllCheckbox'))

println "confirmAttending"+confirmAttending

if (confirmAttending == 'Yes') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipant_confirmAttendingYes'))
}

if (confirmAttending == 'No') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipant_confirmAttendingNo'))
}

if (confirmAttending == 'Maybe') {
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Retreat/page_retreatParticipants/button_retreatParticipant_confirmAttendingMaybe'))
}
WebUI.delay(2)

def participantXpath="//tr[@id='participantsTableHeaderRow']//ancestor::tbody//tr//td//input"

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> participantCheckboxList=driver.findElements(By.xpath(participantXpath))
def totalCheckBoxes=participantCheckboxList.size()


for(def attendingIndex=1;attendingIndex<=totalCheckBoxes;attendingIndex++)

{
	def attendingIndex1=attendingIndex*10
	def defindexXpath="(//tr[@id=\'participantsTableHeaderRow\']//ancestor::tbody//tr//td)["+attendingIndex1+"]"
	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals',defindexXpath, true, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), confirmAttending, false, FailureHandling.CONTINUE_ON_FAILURE)
}







