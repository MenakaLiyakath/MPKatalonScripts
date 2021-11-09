import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement


WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> sessionLabels = driver.findElements(By.xpath("//div[@id='itemContainer']"))

def totSess_ManageSession = sessionLabels.size()

println "totSess_ManageSession"+totSess_ManageSession

WebUI.delay(1)

for (sessioncount = 1; sessioncount < totSess_ManageSession; sessioncount++) {
	def sessionTileLabelXpath = (('(//div[@id=\'itemContainer\']//label[@id=\'sessionName\'])' + '[') + sessioncount) +
			']'

	println('sessionTileLabelXpath' + sessionTileLabelXpath)

	WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', sessionTileLabelXpath, true, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.doubleClick(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE)

	//Navigate to Volunteer Tab and get total Volunteer Count
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'), FailureHandling.CONTINUE_ON_FAILURE)
	def volunteerPoolText=WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsVolunteers/label_sessionVolunteers_volunteerPoolCount'), FailureHandling.CONTINUE_ON_FAILURE)
	String[] volunteerPoolText_split1 = volunteerPoolText.split('\\(')
	String[] volunteerPoolText_split2 = volunteerPoolText_split1[0].split('\\)')
	def volunteerPoolCount=volunteerPoolText_split2[0]
	println "volunteerPoolCount"+volunteerPoolCount

	//Navigate to Participant Tab and get total Participant Count
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionParticipants'), FailureHandling.CONTINUE_ON_FAILURE)
	def participantPoolText=WebUI.getText( findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsParticipants/label_sessionParticipants_participantPoolCount'), FailureHandling.CONTINUE_ON_FAILURE)
	String[] participantPoolText_split1 = participantPoolText.split("\\(")
	String[] participantPoolText_split2 = participantPoolText_split1[0].split("\\)")
	def participantPoolCount=participantPoolText_split2[0]
	println "participantPoolCount"+participantPoolCount

	//Navigate to Participant Tab and get total groups Count
	WebUI.click( findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionGroups'), FailureHandling.CONTINUE_ON_FAILURE)
	def groupPoolText=WebUI.getText( findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/label_sessionGroups_groupPoolCount'), FailureHandling.CONTINUE_ON_FAILURE)
	String[] groupPoolText_split1 = groupPoolText.split('\\(')
	String[] groupPoolText_split2 = groupPoolText_split1[0].split('\\)')
	def groupPoolCount=groupPoolText_split2[0]
	println "groupPoolCount"+groupPoolCount

	//Navigate to Session Overview Page
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionOverview') , FailureHandling.CONTINUE_ON_FAILURE)

	//Click on Delete icon and validate deletion functionality
	def sessionName=WebUI.getAttribute(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/input_sessionOverview_sessionName'),'value', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/button_sessionOverview_deleteSession'), FailureHandling.CONTINUE_ON_FAILURE)

	if((groupPoolCount=='0') && (participantPoolCount=='0') && (volunteerPoolCount=='0'))
	{
		if(WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_deleteSessionConfirmation'), 2, FailureHandling.CONTINUE_ON_FAILURE))
		{
			def confirmLightboxText_expected=WebUI.getText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_deleteSessionConfirmation'), FailureHandling.CONTINUE_ON_FAILURE)
			def confirmLightbocText_actual="You are about to delete "+ sessionName+". This contains 0 participants, 0 volunteers & 0 groups. All remaining data within this session including notes will be lost."
			WebUI.verifyMatch(confirmLightbocText_actual, confirmLightboxText_expected, false, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat') , FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', '//div[@id=\'itemContainer\']//label[@id=\''+sessionName+'\']', true, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.verifyElementNotPresent(dynamicObject, 2, FailureHandling.CONTINUE_ON_FAILURE)

		}
	}
	else
	{
		WebUI.verifyElementPresent(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/label_sessionOverview_unableToDelete'), 2, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/icon_sessionOverview_unableToDelete') , FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat') , FailureHandling.CONTINUE_ON_FAILURE)
	}

}