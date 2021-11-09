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

WebUI.comment('Check for existing groups and delete group if available')

WebUI.delay(2)

def groupTableXpath = '//div[@id=\'sessionPageContainer\']//table[@class=\'group-table\']'

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> groupTableElementList = driver.findElements(By.xpath(groupTableXpath))

def totalGroups = groupTableElementList.size()

println('totalGroups' + totalGroups)

if (totalGroups > 0) {
	//def closeGroupIconXpath = '//div[@id=\'sessionPageContainer\']//table[@class=\'group-table\']//i'
	List<WebElement> closeGroupIconElementList = driver.findElements(By.xpath('//div[@id=\'sessionPageContainer\']//table[@class=\'group-table\']//i[contains(@class,\'delete-group-button\')]'))

	println('closeGroupIconElementList Count' + closeGroupIconElementList.size())

	def totalcloseGroupIcon = closeGroupIconElementList.size()
	println "totalcloseGroupIcon"+totalcloseGroupIcon

	for (def iconIndex = 0; iconIndex <=totalcloseGroupIcon-1; iconIndex++) {
		List<WebElement> closeGroupIconElementList1 = driver.findElements(By.xpath('//div[@id=\'sessionPageContainer\']//table[@class=\'group-table\']//i[contains(@class,\'delete-group-button\')]'))
		println "closeGroupIconElementList1 size"+closeGroupIconElementList1.size()
		WebElement closeGroupIcon = closeGroupIconElementList1.get(0)

		closeGroupIcon.click()

		WebUI.delay(2)
	}

	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_save'),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2)
}

WebUI.setText(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/input_sessionGroups_numberOfGroups'),
		'2', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_create'))

WebUI.delay(2)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_groups_autoAssignButtonWithSeatingPreferences'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/lightbox_sessionGroups_AutoAssign/button_AutoAssign_autoAssign'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionsGroups/button_sessionGroups_save'),
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

def participanrCountXpath = '//div[@id=\'sessionPageContainer\']//table[@class=\'group-table\']//span[contains(@class,\'numberOfParticipantsAndVolunteersInGroup\')]'

List<WebElement> participanrCountList = driver.findElements(By.xpath(participanrCountXpath))

WebElement participanrCount1 = participanrCountList.get(0)

WebElement participanrCount2 = participanrCountList.get(1)

println "participanrCount1"+participanrCount1
println "participanrCount2"+participanrCount2

WebUI.comment('Split and get the participant count of first group')

//Split for group 1
def group1CountGetText=participanrCount1.getText()

println "group1CountGetText"+group1CountGetText
String[] group1CountGetText_split1

group1CountGetText_split1 = group1CountGetText.split('\\(')

def group1CountGetText_value1 = group1CountGetText_split1[1].toString()

println "group1CountGetText_value1"+group1CountGetText_value1

String[] group1CountGetText_value1_split1

group1CountGetText_value1_split1 = group1CountGetText_value1.split('\\)')

def group1CountGetText_value1_split1_value = group1CountGetText_value1_split1[0].toString()

println "group1CountGetText_value1_split1_value"+group1CountGetText_value1_split1_value

//Split for Group2
def group2CountGetText=participanrCount1.getText()

println "group2CountGetText"+group2CountGetText
String[] group2CountGetText_split1

group2CountGetText_split1 = group2CountGetText.split('\\(')

def group2CountGetText_value1 = group2CountGetText_split1[1].toString()

println "group2CountGetText_value1"+group2CountGetText_value1

String[] group2CountGetText_value1_split1

group2CountGetText_value1_split1 = group2CountGetText_value1.split('\\)')

def group2CountGetText_value1_split1_value = group2CountGetText_value1_split1[0].toString()

println "group2CountGetText_value1_split1_value"+group2CountGetText_value1_split1_value

def group1ParticipantCount = group1CountGetText_value1_split1_value.toInteger()

def group2ParticipantCount = group2CountGetText_value1_split1_value.toInteger()

def totalParticipant = group1ParticipantCount + group2ParticipantCount

println('totalParticipant' + totalParticipant)

WebUI.comment('Navigate to Session Tile and validate participant count')

WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'equals', ('//div[@id=\'itemContainer\']//div[@id=\'itemHeader\']//label[@id=\'sessionName\'][text()=\'' +
		SessName) + '\']//ancestor::div[@id=\'itemContainer\']//div[@id=\'itemBody\']//div//div[@id=\'participants\']', true,
		FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getText(dynamicObject, FailureHandling.CONTINUE_ON_FAILURE), totalParticipant.toString(), false,
		FailureHandling.CONTINUE_ON_FAILURE)

