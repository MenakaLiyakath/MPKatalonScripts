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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.util.ArrayList
import java.lang.String
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
WebUI.delay(2)
WebUI.click(findTestObject('CommonPageObjects/page_home/button_homepage_findPeople'))
WebUI.delay(10)

def participantnameobj = new TestObject('participantnameobj')

println "FirstName:::"+FirstName
println "LastName:::"+LastName

participantnameobj.addProperty('xpath', ConditionType.EQUALS, ((('//td[text()=\'' + FirstName) + '\']/preceding-sibling::td[text()=\'') +
		LastName) + '\']', true)

if (WebUI.verifyElementPresent(participantnameobj, 2, FailureHandling.OPTIONAL))
{
	WebUI.click(participantnameobj, FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/tab_addPeople_sessionsInfo'), FailureHandling.CONTINUE_ON_FAILURE)
	def rowCount= findTestData('Data Files/sessionInfoValidation').getRowNumbers()
	String[] sessionArray=new String[rowCount]
	for(rowIndex=1;rowIndex<=rowCount;rowIndex++)
	{
		sessionArray[rowIndex-1]=findTestData('Data Files/sessionInfoValidation').getValue(1, rowIndex)

	}
	WebUI.click(findTestObject('module_profiles/lightbox_findPeople_addPeople/dropDown_addPeople_session'))

	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> sessionSpan = driver.findElements(By.xpath("//ng-select[@id='session-dropdown']//ng-dropdown-panel//span[@class='ng-option-label']"))
	def totSessionspans = sessionSpan.size()
	println(totSessionspans + ' total sessions in dropdown')
	if(totSessionspans>0)
	{
		
		for(sessioncount=1;sessioncount<=totSessionspans;sessioncount++ )
		{
			WebUI.modifyObjectProperty(dynamicObject, 'xpath', 'EQUALS', ('(.//ng-select[@id=\'session-dropdown\']//ng-dropdown-panel//span[@class=\'ng-option-label\'])[' + sessioncount) +
					']', true, FailureHandling.CONTINUE_ON_FAILURE)

			
			def sessionName=WebUI.getText(dynamicObject)
			if(sessionName.equals(sessionArray[sessioncount-1]))
			println "Session names are sorted as per date"
			else
			{
			WebUI.verifyMatch("Test Case fail as the session orders on dropdown are not displayed as per end date", "Error", false, FailureHandling.STOP_ON_FAILURE)
			break
			}
		}
	}
	else
		WebUI.verifyMatch("Test Case fail as the created sessions are not displayed in session Drop down", "Error", false, FailureHandling.STOP_ON_FAILURE)

}
