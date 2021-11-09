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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)
def sessionTileXpath="//div[@id='itemHeader']"
def totalVolunteer=0
WebUI.comment("Fetching the Total number of volunteers from Each Session")
WebDriver driver = DriverFactory.getWebDriver()
List<WebElement> sessionTileList = driver.findElements(By.xpath(sessionTileXpath))
def totalSessionTile=sessionTileList.size()
println "totalSessionTile" +totalSessionTile
if(totalSessionTile!=0)
{


for (i = 0; i < totalSessionTile; i++)
{
	println "i" +i
	List<WebElement> sessionTileList1 = driver.findElements(By.xpath(sessionTileXpath))
	sessionTileList1.get(i).click()
	WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/menu_session/link_sessionMenu_sessionVolunteers'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	def checkBoxXpath="//table[@id='volunteersTable']//tr//td//input"
	List<WebElement> checkBoxList = driver.findElements(By.xpath(checkBoxXpath))
	def checkboxSize=checkBoxList.size()
	totalVolunteer=totalVolunteer+checkboxSize
	println "totalVolunteer"+totalVolunteer
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/page_encounter_sidebar/link_sessionMenu_addOrViewSessionOrRetreat'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Encounter(SessionOrRetreat)/Session/page_sessionOverview/checkBox_sessionOverview_completedSession'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
}
}

GlobalVariable.globalizedVolunteerCount=totalVolunteer
println GlobalVariable.globalizedVolunteerCount